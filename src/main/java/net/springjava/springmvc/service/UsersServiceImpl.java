package net.springjava.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import net.springjava.springmvc.dao.UsersDAO;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	public UsersDAO usersDAO;
	
	@Override
	public List<String> getFavorite(String username) {
		return usersDAO.getFavorites(username);
	}

}
