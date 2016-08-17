package net.springjava.springmvc.service;

import java.util.List;

import net.springjava.springmvc.model.Beers;

public interface BeerService {

		 public List<Beers> list();
		 public void createBeer(Beers beer);
		 public void deleteBeer(int id);
		// public void addmany();
}
