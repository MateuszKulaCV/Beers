package net.springjava.springmvc.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import net.springjava.springmvc.model.Users;


public class UsersDAOImpl implements UsersDAO {

private SessionFactory sessionFactory;
	
	public UsersDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<String> getFavorites(String username) {
		 @SuppressWarnings("unchecked")
	        List<Users> listUser = (List<Users>) sessionFactory.getCurrentSession()
	                .createQuery("from Users u where u.username = :username")
	                .setString("username", username)
	                .list();
		 	String fav = listUser.get(0).getFavorite();
		 	ArrayList<String> favlist = new ArrayList<>(Arrays.asList(fav.split("/")));
		 	
		 	
			System.out.println(fav);
			System.out.println("Usersdao");
	 return favlist;
	}

}
