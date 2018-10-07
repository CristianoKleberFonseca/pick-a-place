package br.com.dbserver.pickaplace.model;

import java.io.Serializable;

import br.com.dbserver.pickaplace.untils.DataBaseUntil;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	
	public Employee() {
		
	}
	
	public Employee(String name) {
		this.id = DataBaseUntil.generateID();
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
