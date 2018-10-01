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
		Restaurant restarantOne = new Restaurant();
		restarantOne.setId(DataBaseUntil.generateID());
		restarantOne.setDescription("China 48");
		

		Restaurant restarantTwo = new Restaurant();
		restarantTwo.setId(DataBaseUntil.generateID());
		restarantTwo.setDescription("Tepan");
		
		Restaurant restarantThree = new Restaurant();
		restarantThree.setId(DataBaseUntil.generateID());
		restarantThree.setDescription("Zen");
		
		Restaurant restarantFour = new Restaurant();
		restarantFour.setId(DataBaseUntil.generateID());
		restarantFour.setDescription("Galetos");
		
		Restaurant restarantFive = new Restaurant();
		restarantFive.setId(DataBaseUntil.generateID());
		restarantFive.setDescription("Bode do Nô");
		
		restaurantBD = new ArrayList<Restaurant>();
		restaurantBD.add(restarantOne);
		restaurantBD.add(restarantTwo);
		restaurantBD.add(restarantThree);
		restaurantBD.add(restarantFour);
		restaurantBD.add(restarantFive);
	}
	
	@Override
	public Restaurant findRestaurantByDescription(String description) {
		Restaurant restaurantReturn = null;
		
		restaurantReturn = restaurantBD.stream().filter(
				restaurant -> restaurant.getDescription().equals(description)).findAny().orElse(null);
		
		return restaurantReturn;
	}

	@Override
	public List<Restaurant> listAllRestaurant() {
		List<Restaurant> listReturn = null;
		
		listReturn = restaurantBD;
		
		return listReturn;
	}

}
