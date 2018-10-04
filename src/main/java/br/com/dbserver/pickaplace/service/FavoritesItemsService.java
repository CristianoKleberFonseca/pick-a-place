package br.com.dbserver.pickaplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.dbserver.pickaplace.model.Favorites;
import br.com.dbserver.pickaplace.model.FavoritesItems;
import br.com.dbserver.pickaplace.model.Restaurant;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;

@Service
public class FavoritesItemsService {
	private static List<FavoritesItems> favoritesItemsBD;
	
	static {
		favoritesItemsBD = new ArrayList<FavoritesItems>();
	}

	public FavoritesItems saveFavoritesItems(Favorites favorites, Restaurant restaurant) {
		FavoritesItems favoritesItemsReturn = new FavoritesItems();
		
		favorites.setId(DataBaseUntil.generateID());
		favoritesItemsReturn.setFavorites(favorites);
		favoritesItemsReturn.setRestaurant(restaurant);
		favoritesItemsBD.add(favoritesItemsReturn);
		
		return favoritesItemsReturn;
	}

}
