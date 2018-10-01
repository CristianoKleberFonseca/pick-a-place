package br.com.dbserver.pickaplace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dbserver.pickaplace.dao.UserDao;
import br.com.dbserver.pickaplace.model.Employee;
import br.com.dbserver.pickaplace.model.User;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;

@Repository
public class UserDaoImpl implements UserDao {
	private static List<User> userBD;
	
	static {
		populateDataBase();
	}
	
	private static void populateDataBase() {
		userBD = new ArrayList<User>();
		
		User userA = new User();
		userA.setId(DataBaseUntil.generateID());
		userA.setEmail("usera@gmail.com");
		Employee employeeA = new Employee();
		employeeA.setId(DataBaseUntil.generateID());
		employeeA.setName("Cristiano Kleber da Fonseca");
		userA.setEmployee(employeeA);
		userA.setUserName("usersecret");
		userA.setPassword("123456");
		
		userBD.add(userA);
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
