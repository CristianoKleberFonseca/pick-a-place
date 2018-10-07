package br.com.dbserver.pickaplace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dbserver.pickaplace.dao.RestaurantDao;
import br.com.dbserver.pickaplace.model.Restaurant;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {
	
	private static List<Restaurant> restaurantBD;
	
	static{
		Restaurant restaurantOne = new Restaurant();
		restaurantOne.setId(DataBaseUntil.generateID());
		restaurantOne.setName("China 48");
		

		Restaurant restaurantTwo = new Restaurant();
		restaurantTwo.setId(DataBaseUntil.generateID());
		restaurantTwo.setName("Tepan");
		
		Restaurant restaurantThree = new Restaurant();
		restaurantThree.setId(DataBaseUntil.generateID());
		restaurantThree.setName("Zen");
		
		Restaurant restaurantFour = new Restaurant();
		restaurantFour.setId(DataBaseUntil.generateID());
		restaurantFour.setName("Galetos");
		
		Restaurant restaurantFive = new Restaurant();
		restaurantFive.setId(DataBaseUntil.generateID());
		restaurantFive.setName("Bode do Nô");
		
		restaurantBD = new ArrayList<Restaurant>();
		restaurantBD.add(restaurantOne);
		restaurantBD.add(restaurantTwo);
		restaurantBD.add(restaurantThree);
		restaurantBD.add(restaurantFour);
		restaurantBD.add(restaurantFive);
	}
	
	@Override
	public Restaurant findRestaurantByDescription(String description) {
		Restaurant restaurantReturn = null;
		
		restaurantReturn = restaurantBD.stream().filter(
				restaurant -> restaurant.getName().equals(description)).findAny().orElse(null);
		
		return restaurantReturn;
	}

	@Override
	public List<Restaurant> listAllRestaurant() {
		List<Restaurant> listReturn = null;
		
		listReturn = restaurantBD;
		
		return listReturn;
	}

	@Override
	public Restaurant findRestaurantById(Long id) {
		Restaurant restaurantReturn = null;

		restaurantReturn = restaurantBD.stream().filter(restaurant -> restaurant.getId().equals(id)).findAny()
				.orElse(null);

		return restaurantReturn;
	}

}
