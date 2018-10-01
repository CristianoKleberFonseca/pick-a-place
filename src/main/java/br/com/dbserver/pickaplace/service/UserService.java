package br.com.dbserver.pickaplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbserver.pickaplace.dao.UserDao;
import br.com.dbserver.pickaplace.exception.BusinessException;
import br.com.dbserver.pickaplace.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User login(String userName, String password) throws BusinessException {
		User userReturn = null;
		userReturn = this.userDao.login(userName, password);
		if(userReturn == null) {
			throw new BusinessException("User not found!!!");
		}
		return userReturn;
		
	}

}
