package br.com.dbserver.pickaplace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dbserver.pickaplace.dao.UserDao;
import br.com.dbserver.pickaplace.model.User;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;

@Repository
public class UserDaoImpl implements UserDao {
	private static List<User> userBD;
	
	static {
		userBD = new ArrayList<User>();
	}

	@Override
	public User saveUser(User user) {
		user.setId(DataBaseUntil.generateID());
		userBD.add(user);
		
		return user;
	}
	
	@Override
	public User login(String userName, String password) {
		User userReturn = null;
		
		userReturn = userBD.stream().filter(
				user -> (user.getUserName().equals(userName) && user.getPassword().equals(password))
				).findAny().orElse(null);
		
		return userReturn;
	}
}
