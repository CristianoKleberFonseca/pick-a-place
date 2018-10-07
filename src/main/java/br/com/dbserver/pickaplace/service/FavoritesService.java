package br.com.dbserver.pickaplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbserver.pickaplace.dao.FavoritesDao;
import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Employee;
import br.com.dbserver.pickaplace.model.Favorites;
import br.com.dbserver.pickaplace.model.FavoritesItems;
import br.com.dbserver.pickaplace.model.Restaurant;

@Service
public class FavoritesService {

	@Autowired
	private FavoritesDao favoritesDao;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private EmployeeService employeeService;

	public Favorites saveFavorites(Long idEmployee, Long idRestaurant) throws BusinessException {
		Favorites favoritesReturn = null;
		Restaurant restaurant = null;
		Employee employee = null;

		// Consulta se o existe favoritos para um determinado empregado.
		favoritesReturn = this.favoritesDao.findFavoritesByIdEmployee(idEmployee);
		if (favoritesReturn == null) {
			favoritesReturn = new Favorites();
			employee = this.employeeService.findEmployeeById(idEmployee);
			favoritesReturn.setEmployee(employee);
		}
		restaurant = this.restaurantService.findRestaurantById(idRestaurant);
		//Verifica se o restaurante já está incluído neste favoritos.
		if(Boolean.FALSE.equals(this.favoritesHasThisItem(favoritesReturn, idRestaurant))) {
			favoritesReturn.getFavoritesItems().add(this.buildFavoritesItems(favoritesReturn, restaurant));
		} else {
			throw new BusinessException(String.format("The restaurant %s is already a favorite's %s", restaurant.getName(), favoritesReturn.getEmployee().getName()));
		}
		
		if (favoritesReturn != null) {
			this.favoritesDao.saveFavorites(favoritesReturn);
		}
		
		return favoritesReturn;
	}
	
	private FavoritesItems buildFavoritesItems(Favorites favorites, Restaurant restaurant) {
		FavoritesItems favoritesItemsReturn = new FavoritesItems();
		
		favoritesItemsReturn = this.favoritesDao.addFavoritesItems(restaurant);
		
		return favoritesItemsReturn;
	}
	
	public Boolean favoritesHasThisItem(Favorites favorites, Long idRestaurant) {
		Boolean hasThisItem = new Boolean(false);
		
		hasThisItem = this.favoritesDao.favoritesHasThisItem(favorites, idRestaurant);
		
		return hasThisItem;
	}
	
	public Favorites findFavoritesByIdEmployee(Long idEmployee) {
		Favorites favoritesReturn = null;
		
		this.favoritesDao.findFavoritesByIdEmployee(idEmployee);
		
		return favoritesReturn;
	}
}
