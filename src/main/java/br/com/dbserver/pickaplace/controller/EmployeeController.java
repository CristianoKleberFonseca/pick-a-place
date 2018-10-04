package br.com.dbserver.pickaplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.Employee;
import br.com.dbserver.pickaplace.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Employee>> listAllEmployee() throws BusinessException {
		List<Employee> listReturn = null;

		listReturn = this.employeeService.listAllEmployee();

		return ResponseEntity.ok().body(listReturn);
	}

}
