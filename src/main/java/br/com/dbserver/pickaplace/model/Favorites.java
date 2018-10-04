package br.com.dbserver.pickaplace.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Favorites implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Employee employee;
	private List<FavoritesItems> favoritesItems = new ArrayList<FavoritesItems>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<FavoritesItems> getFavoritesItems() {
		return favoritesItems;
	}

	public void setFavoritesItems(List<FavoritesItems> favoritesItems) {
		this.favoritesItems = favoritesItems;
	}
}
