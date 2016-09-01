package net.springjava.springmvc.service;

import java.util.List;

import net.springjava.springmvc.model.Beers;
import net.springjava.springmvc.model.Pubs;

public interface BeerService {

		 public List<Beers> list();
		 public void createBeer(Beers beer);
		 public void updateBeer(Beers beer);
		 public void deleteBeer(int id);
		 public Beers getById(int id);
		 public List<Beers> listFromPub(Pubs pub);
		// public void addmany();
}
