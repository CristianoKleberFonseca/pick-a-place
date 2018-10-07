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
		Employee employeeOne = new Employee("José Soares da Silva");
		User userOne = new User("userone", "employeeone@dbserver.com.br", "123456", employeeOne);
		userBD.add(userOne);
		Employee employeeTwo = new Employee("Abelardo Fagundes");
		User userTwo = new User("usertwo", "employeetwo@dbserver.com.br", "234567", employeeTwo);
		userBD.add(userTwo);
		Employee employeeThree = new Employee("Jacqueline Lima de Castro");
		User userThree = new User("userthree", "employeethree@dbserver.com.br", "345678", employeeThree);
		userBD.add(userThree);
		Employee employeeFour = new Employee("João Henrique Castro da Fonseca");
		User userFour = new User("userfour", "employeefour@dbserver.com.br", "456789", employeeFour);
		userBD.add(userFour);
		Employee employeeFive = new Employee("Adonildo Júnior");
		User userFive = new User("userfive", "employeefive@dbserver.com.br", "567890", employeeFive);
		userBD.add(userFive);
		Employee employeeSix = new Employee("Maria Madalena");
		User userSix = new User("usersix", "employeesix@dbserver.com.br", "678901", employeeSix);
		userBD.add(userSix);
		Employee employeeSeven = new Employee("Deisiane Cunha Barreto");
		User userSeven = new User("userseven", "employeeseven@dbserver.com.br", "789012", employeeSeven);
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
