package net.springjava.springmvc.dao;

import java.util.List;

import net.springjava.springmvc.model.Pubs;

public interface PubsDAO {
	public List<Pubs> list();
	 public void createPub(Pubs pub);
	 public void deletePub(int id);
	 public Pubs getPub(int id); 
	
}
