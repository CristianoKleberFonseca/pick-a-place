package br.com.dbserver.pickaplace.model.resource;

import java.io.Serializable;

public class FavoritesResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idEmployee;
	private Long idRestaurant;
	
	public Long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}
	public Long getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(Long idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

}
