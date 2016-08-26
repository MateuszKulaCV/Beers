package net.springjava.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import net.springjava.springmvc.model.Pubs;


public class PubsDAOImpl implements PubsDAO {

	private SessionFactory sessionFactory;
	
	public PubsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	@Transactional
	public List<Pubs> list() {
		 @SuppressWarnings("unchecked")
	        List<Pubs> listPubs = (List<Pubs>) sessionFactory.getCurrentSession()
	                .createCriteria(Pubs.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			System.out.println("pubdao");
	 return listPubs;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ArrayList<Pubs> favList(List<String> favlist)
	{
		List<Pubs> listPubs = new ArrayList<Pubs>();
		
		for(String fav:favlist){
			
		listPubs.addAll(sessionFactory.getCurrentSession()
                .createQuery("from Pubs p where p.pub =:fav")
                .setString("fav", fav)
                .list()); 
			}
		System.out.println(listPubs.size()+"dupaDAO");
		return (ArrayList<Pubs>) listPubs;
		
	}
	
	@Override
	@Transactional
	public void createPub(Pubs pub) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(pub);
	}

	@Override
	@Transactional
	public void deletePub(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getPub(id));
		
	}

	@Override
	@Transactional
	public Pubs getPub(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Pubs) session.get(Pubs.class, id);
	}

}
