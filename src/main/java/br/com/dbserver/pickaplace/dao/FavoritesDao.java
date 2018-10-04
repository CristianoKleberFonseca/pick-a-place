package br.com.dbserver.pickaplace.dao;

import br.com.dbserver.pickaplace.model.Favorites;

public interface FavoritesDao {

	public Favorites saveFavorites(Favorites favorites);
	public Favorites findFavoritesByIdEmployee(Long idEmployee);
	public Boolean favoritesHasThisItem(Favorites favorites, Long idRestaurant);

}
