package br.com.dbserver.pickaplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbserver.pickaplace.dao.EmployeeDao;
import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee findEmployeeByName(String name) throws BusinessException {
		Employee employeeReturn = null;

		employeeReturn = this.employeeDao.findEmployeeByName(name);
		if (employeeReturn == null) {
			throw new BusinessException(String.format("No have register of employee with name equals %s.", name));
		}
		
		return employeeReturn;
	}
	
	public Employee findEmployeeById(Long id) throws BusinessException {
		Employee employeeReturn = null;

		employeeReturn = this.employeeDao.findEmployeeById(id);
		if (employeeReturn == null) {
			throw new BusinessException(String.format("No have register of employee with id equals %s.", id));
		}
		
		return employeeReturn;
	}
	
	public List<Employee> listAllEmployee() throws BusinessException {
		List<Employee> listReturn = null;

		listReturn = this.employeeDao.listAllEmployee();
		if (listReturn == null) {
			throw new BusinessException("No have register of employee!!!");
		}
		return listReturn;
	}

}
