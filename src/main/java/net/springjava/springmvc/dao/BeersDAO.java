package net.springjava.springmvc.dao;

import java.util.List;

import net.springjava.springmvc.model.Beers;
import net.springjava.springmvc.model.Pubs;

public interface BeersDAO {
 public List<Beers> list();
 public void createBeer(Beers beer);
 public void deleteBeer(int id);
 public Beers getBeer(int id); 
 public List<Beers> listFromPub(Pubs pub);
// public void addmany();
}
