package br.com.dbserver.pickaplace.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dbserver.pickaplace.dao.EmployeeDao;
import br.com.dbserver.pickaplace.model.Employee;
import br.com.dbserver.pickaplace.untils.DataBaseUntil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static List<Employee> employeeBD;

	static {
		employeeBD = new ArrayList<Employee>();
		
		Employee employeeOne = new Employee();
		employeeOne.setId(DataBaseUntil.generateID());
		employeeOne.setName("José Soares da Silva");
		employeeBD.add(employeeOne);
		
		Employee employeeTwo = new Employee();
		employeeTwo.setId(DataBaseUntil.generateID());
		employeeTwo.setName("Abelardo Fagundes");
		employeeBD.add(employeeTwo);
		
		Employee employeeThree = new Employee();
		employeeThree.setId(DataBaseUntil.generateID());
		employeeThree.setName("Jacqueline Lima de Castro");
		employeeBD.add(employeeThree);
		
		Employee employeeFour = new Employee();
		employeeFour.setId(DataBaseUntil.generateID());
		employeeFour.setName("João Henrique Castro da Fonseca");
		employeeBD.add(employeeFour);
		
		Employee employeeFive = new Employee();
		employeeFive.setId(DataBaseUntil.generateID());
		employeeFive.setName("Adonildo Júnior");
		employeeBD.add(employeeFive);

		Employee employeeSix = new Employee();
		employeeSix.setId(DataBaseUntil.generateID());
		employeeSix.setName("Maria Madalena");
		employeeBD.add(employeeSix);
		
		Employee employeeSeven = new Employee();
		employeeSeven.setId(DataBaseUntil.generateID());
		employeeSeven.setName("Deisiane Cunha Barreto");
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
}
