package net.springjava.springmvc.dao;

import java.util.List;

import net.springjava.springmvc.model.Beers;

public interface BeersDAO {
 public List<Beers> list();
 public void createBeer(Beers beer);
 public void deleteBeer(int id);
 public Beers getBeer(int id); 
// public void addmany();
}
