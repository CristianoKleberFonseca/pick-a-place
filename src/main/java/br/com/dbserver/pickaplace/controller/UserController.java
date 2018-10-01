package br.com.dbserver.pickaplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.User;
import br.com.dbserver.pickaplace.service.UserService;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login/{userName}/{password}", method = RequestMethod.GET)
	public ResponseEntity<User> login(@PathVariable("userName") String userName, @PathVariable("password") String password) throws BusinessException {
		User userReturn = null;
		
		userReturn = this.userService.login(userName, password);
		
		
		return ResponseEntity.ok(userReturn);
	}
}
