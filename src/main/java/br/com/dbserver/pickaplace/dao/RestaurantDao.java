package br.com.dbserver.pickaplace.dao;

import java.util.List;

import br.com.dbserver.pickaplace.model.Restaurant;

public interface RestaurantDao {
	
	public List<Restaurant> listAllRestaurant();
	
	public Restaurant findRestaurantByDescription(String description);
	
	public Restaurant findRestaurantById(Long id);

}
