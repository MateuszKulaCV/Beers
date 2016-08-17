package net.springjava.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springjava.springmvc.dao.PubsDAO;
import net.springjava.springmvc.model.Pubs;

@Service
public class PubServiceImpl implements PubService {

	@Autowired
	private PubsDAO pubsDAO;
	
	
	
	public List<Pubs> list() {
		System.out.println("pubservice");
		return pubsDAO.list();
	}


	public void createPub(Pubs pub) {
		pubsDAO.createPub(pub);
	}

	
	public void deletePub(int id) {
		pubsDAO.deletePub(id);
	}

	
	public Pubs getPub(int id) {
		return (Pubs) pubsDAO.getPub(id);
	}

}
