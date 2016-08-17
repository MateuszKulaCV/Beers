package net.springjava.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springjava.springmvc.dao.BeersDAO;
import net.springjava.springmvc.model.Beers;

@Service
public class BeerServiceImpl implements BeerService {

	@Autowired
	private BeersDAO beersDAO;
	
	public List<Beers> list() {
		System.out.println("service");
		return beersDAO.list();
	}


	public void createBeer(Beers beer) {
		System.out.println("service add");
		beersDAO.createBeer(beer);
		
	}


	public void deleteBeer(int id) {
		beersDAO.deleteBeer(id);
		
	}

}
