package net.springjava.springmvc.dao;

import java.util.List;

import net.springjava.springmvc.model.Pubs;

public interface PubsDAO {
	public List<Pubs> list();
	public List<Pubs> favList(List<String> favlist);
	 public void createPub(Pubs pub);
	 public void deletePub(int id);
	 public Pubs getPub(int id); 
	
}
