package br.com.dbserver.pickaplace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dbserver.pickaplace.dao.FavoritesDao;
import br.com.dbserver.pickaplace.model.Favorites;
import br.com.dbserver.pickaplace.model.FavoritesItems;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;

@Repository
public class FavoritesDaoImpl implements FavoritesDao {
	private static List<Favorites> favoritesBD;

	static {
		favoritesBD = new ArrayList<Favorites>();
	}

	@Override
	public Favorites saveFavorites(Favorites favorites) {
		favorites.setId(DataBaseUntil.generateID());
		favoritesBD.add(favorites);

		return favorites;
	}

	@Override
	public Favorites findFavoritesByIdEmployee(Long idEmployee) {
		Favorites favoritesReturn = null;

		favoritesReturn = favoritesBD.stream().filter(favorites -> (favorites.getEmployee() != null && favorites.getEmployee().getId().equals(idEmployee)))
				.findAny().orElse(null);

		return favoritesReturn;
	}

	@Override
	public Boolean favoritesHasThisItem(Favorites favorites, Long idRestaurant) {
		Boolean hasThisItem = false;

		FavoritesItems favoritesItemsValidate = favorites.getFavoritesItems().stream()
				.filter(favoritesItems -> favoritesItems.getRestaurant().getId().equals(idRestaurant)).findAny()
				.orElse(null);
		hasThisItem = (favoritesItemsValidate != null);
		
		return hasThisItem;
	}

}
