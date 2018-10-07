package br.com.dbserver.pickaplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Restaurant;
import br.com.dbserver.pickaplace.service.RestaurantService;

@RestController
@RequestMapping(value = "/api/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Restaurant>> listAllRestaurant() throws BusinessException {
		List<Restaurant> listReturn = null;
		
		listReturn = this.restaurantService.listAllRestaurant();
		
		return ResponseEntity.ok().body(listReturn);
	}
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<Restaurant> findRestaurantByName(@PathVariable("name") String name) throws BusinessException {
		Restaurant restaurantReturn = null;

			restaurantReturn = this.restaurantService.findRestaurantByName(name);
			
		return  ResponseEntity.ok(restaurantReturn);
	}

}
