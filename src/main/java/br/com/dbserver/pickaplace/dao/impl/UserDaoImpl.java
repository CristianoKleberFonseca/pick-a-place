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
		userBD = new ArrayList<User>();
		Employee employeeOne = new Employee(1L, "José Soares da Silva");
		User userOne = new User(1L, "userone", "employeeone@dbserver.com.br", "123456", employeeOne);
		userBD.add(userOne);
		Employee employeeTwo = new Employee(2L, "Abelardo Fagundes");
		User userTwo = new User(2L, "usertwo", "employeetwo@dbserver.com.br", "234567", employeeTwo);
		userBD.add(userTwo);
		Employee employeeThree = new Employee(3L, "Jacqueline Lima de Castro");
		User userThree = new User(3L, "userthree", "employeethree@dbserver.com.br", "345678", employeeThree);
		userBD.add(userThree);
		Employee employeeFour = new Employee(4L, "João Henrique Castro da Fonseca");
		User userFour = new User(4L, "userfour", "employeefour@dbserver.com.br", "456789", employeeFour);
		userBD.add(userFour);
		Employee employeeFive = new Employee(5L, "Adonildo Júnior");
		User userFive = new User(5L, "userfive", "employeefive@dbserver.com.br", "567890", employeeFive);
		userBD.add(userFive);
		Employee employeeSix = new Employee(6L, "Maria Madalena");
		User userSix = new User(6L, "usersix", "employeesix@dbserver.com.br", "678901", employeeSix);
		userBD.add(userSix);
		Employee employeeSeven = new Employee(7L, "Deisiane Cunha Barreto");
		User userSeven = new User(7L, "userseven", "employeeseven@dbserver.com.br", "789012", employeeSeven);
		userBD.add(userSeven);
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
