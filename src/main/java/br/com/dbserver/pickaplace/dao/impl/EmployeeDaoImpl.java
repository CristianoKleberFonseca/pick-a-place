package br.com.dbserver.pickaplace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.dbserver.pickaplace.dao.EmployeeDao;
import br.com.dbserver.pickaplace.dao.UserDao;
import br.com.dbserver.pickaplace.model.Employee;
import br.com.dbserver.pickaplace.model.Restaurant;
import br.com.dbserver.pickaplace.model.User;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static List<Employee> employeeBD;
	

	static {
		Employee employeeOne = new Employee();
		employeeOne.setId(DataBaseUntil.generateID());
		employeeOne.setName("José Soares da Silva");

		Employee employeeTwo = new Employee();
		employeeTwo.setId(DataBaseUntil.generateID());
		employeeTwo.setName("Abelardo Fagundes");

		Employee employeeThree = new Employee();
		employeeThree.setId(DataBaseUntil.generateID());
		employeeThree.setName("Jacqueline Lima de Castro");

		Employee employeeFour = new Employee();
		employeeFour.setId(DataBaseUntil.generateID());
		employeeFour.setName("João Henrique Castro da Fonseca");

		Employee employeeFive = new Employee();
		employeeFive.setId(DataBaseUntil.generateID());
		employeeFive.setName("Adonildo Júnior");

		Employee employeeSix = new Employee();
		employeeSix.setId(DataBaseUntil.generateID());
		employeeSix.setName("Maria Madalena");

		Employee employeeSeven = new Employee();
		employeeSeven.setId(DataBaseUntil.generateID());
		employeeSeven.setName("Deisiane Cunha Barreto");

		employeeBD = new ArrayList<Employee>();
		employeeBD.add(employeeOne);
		associateUser(new User("employeeone", "employeeone@dbserver.com.br", "123456"), employeeOne);
		employeeBD.add(employeeTwo);
		associateUser(new User("employeetwo", "employeetwo@dbserver.com.br", "234567"), employeeTwo);
		employeeBD.add(employeeThree);
		associateUser(new User("employeethree", "employeethree@dbserver.com.br", "345678"), employeeThree);
		employeeBD.add(employeeFour);
		associateUser(new User("employeefour", "employeefour@dbserver.com.br", "456789"), employeeFour);
		employeeBD.add(employeeFive);
		associateUser(new User("employeefive", "employeefive@dbserver.com.br", "567890"), employeeFive);
		employeeBD.add(employeeSix);
		associateUser(new User("employeesix", "employeesix@dbserver.com.br", "6789012"), employeeSix);
		employeeBD.add(employeeSeven);
	}

	@Override
	public List<Employee> listAllEmployee() {
		List<Employee> listReturn = null;

		listReturn = employeeBD;

		return listReturn;
	}

	@Override
	public Employee findEmployeeByName(String name) {
		Employee employeeReturn = null;

		employeeReturn = employeeBD.stream().filter(employee -> employee.getName().equals(name)).findAny()
				.orElse(null);

		return employeeReturn;
	}

	@Override
	public Employee findEmployeeById(Long id) {
		Employee employeeReturn = null;

		employeeReturn = employeeBD.stream().filter(employee -> employee.getId().equals(id)).findAny()
				.orElse(null);

		return employeeReturn;
	}
	private static void associateUser(User user, Employee employee) {
		user.setEmployee(employee);
//		userDao.saveUser(user);
	}
}
