package br.com.dbserver.pickaplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbserver.pickaplace.dao.RestaurantDao;
import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Restaurant;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;

	public List<Restaurant> listAllRestaurant() throws BusinessException {
		List<Restaurant> listReturn = null;

		listReturn = this.restaurantDao.listAllRestaurant();
		if (listReturn == null) {
			throw new BusinessException("No have register of restaurant!!!");
		}
		return listReturn;
	}

	public Restaurant findRestaurantById(Long id) throws BusinessException {
		Restaurant restaurantReturn = null;

		restaurantReturn = this.restaurantDao.findRestaurantById(id);
		if (restaurantReturn == null) {
			throw new BusinessException(String.format("No have register of restaurant with id equals %s.", id));
		}
		return restaurantReturn;

	}

	public Restaurant findRestaurantByName(String name) throws BusinessException {
		Restaurant restaurantReturn = null;

		restaurantReturn = this.restaurantDao.findRestaurantByName(name);
		if (restaurantReturn == null) {
			throw new BusinessException(String.format("No have register of restaurant with name equals %s.", name));
		}
		return restaurantReturn;

	}

}
