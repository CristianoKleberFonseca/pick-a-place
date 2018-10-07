package br.com.dbserver.pickaplace.model;

import java.io.Serializable;

import br.com.dbserver.pickaplace.untils.DataBaseUntil;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;
	private String email;
	private String password;
	private Employee employee;

	public User() {}
	
	public User(String userName, String email, String password, Employee employee) {
		this.id = DataBaseUntil.generateID();
		this.userName= userName;
		this.email = email;
		this.password = password;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
