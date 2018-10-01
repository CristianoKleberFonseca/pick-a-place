package br.com.dbserver.pickaplace.model;

import java.io.Serializable;
import java.util.Date;

public class Vote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Date dateVoting;
	private User user;
	private Restaurant restaurant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateVoting() {
		return dateVoting;
	}

	public void setDateVoting(Date dateVoting) {
		this.dateVoting = dateVoting;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
