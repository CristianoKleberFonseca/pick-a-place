package br.com.dbserver.pickaplace.model;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Date processingDateResult;
	private Integer monthResult;
	private Integer yearResult;
	private Integer weekOfMonthResult;
	private Restaurant restaurant;
	private Integer quantityVotes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getProcessingDateResult() {
		return processingDateResult;
	}

	public void setProcessingDateResult(Date processingDateResult) {
		this.processingDateResult = processingDateResult;
	}

	public Integer getMonthResult() {
		return monthResult;
	}

	public void setMonthResult(Integer monthResult) {
		this.monthResult = monthResult;
	}

	public Integer getYearResult() {
		return yearResult;
	}

	public void setYearResult(Integer yearResult) {
		this.yearResult = yearResult;
	}

	public Integer getWeekOfMonthResult() {
		return weekOfMonthResult;
	}

	public void setWeekOfMonthResult(Integer weekOfMonthResult) {
		this.weekOfMonthResult = weekOfMonthResult;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getQuantityVotes() {
		return quantityVotes;
	}

	public void setQuantityVotes(Integer quantityVotes) {
		this.quantityVotes = quantityVotes;
	}
}
