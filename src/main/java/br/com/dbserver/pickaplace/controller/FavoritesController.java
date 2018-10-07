package br.com.dbserver.pickaplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Favorites;
import br.com.dbserver.pickaplace.model.resource.FavoritesResource;
import br.com.dbserver.pickaplace.service.FavoritesService;

@RestController
@RequestMapping(value = "/api/favorites", produces = MediaType.APPLICATION_JSON_VALUE)
public class FavoritesController {

	@Autowired
	private FavoritesService favoritesService;
	
	@RequestMapping(value = "/saveFavorites", method = RequestMethod.POST)
	public ResponseEntity<Favorites> saveFavorites(@RequestBody FavoritesResource favoritesResource) throws BusinessException {
		Favorites favoritesReturn = null;
		
		favoritesReturn = this.favoritesService.saveFavorites(favoritesResource.getIdEmployee(), favoritesResource.getIdRestaurant());
		
		return ResponseEntity.ok(favoritesReturn);
	}
	
	@RequestMapping(value = "/findByEmployee/{idEmployee}", method = RequestMethod.GET)
	public ResponseEntity<Favorites> findFavoritesByIdEmployee(@PathVariable("idEmployee") Long idEmployee) throws BusinessException {
		Favorites favoritesReturn = null;
		
		favoritesReturn = this.favoritesService.findFavoritesByIdEmployee(idEmployee);
		
		return ResponseEntity.ok(favoritesReturn);
	}
}
