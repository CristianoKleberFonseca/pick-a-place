package br.com.dbserver.pickaplace.dao;

import java.util.List;

import br.com.dbserver.pickaplace.model.Employee;
import br.com.dbserver.pickaplace.model.Restaurant;

public interface EmployeeDao {
	
	public List<Employee> listAllEmployee();
	public Employee findEmployeeByName(String name);
	public Employee findEmployeeById(Long id);
}
