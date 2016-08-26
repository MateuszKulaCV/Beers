package net.springjava.springmvc.dao;

import java.util.List;

public interface UsersDAO {

	public List<String> getFavorites(String username);
	
}
