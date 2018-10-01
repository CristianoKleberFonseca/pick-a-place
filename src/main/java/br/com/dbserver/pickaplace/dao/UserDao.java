package br.com.dbserver.pickaplace.dao;

import br.com.dbserver.pickaplace.model.User;

public interface UserDao {
	
	public User login(String userName, String password);

}
