package net.springjava.springmvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import net.springjava.springmvc.model.Beers;

public class BeersDAOImpl implements BeersDAO {

	private SessionFactory sessionFactory;
	public BeersDAOImpl(SessionFactory sessionsFactory)
	{
		this.sessionFactory = sessionsFactory;
	}
	
	@Override
    @Transactional
    public List<Beers> list() {
        @SuppressWarnings("unchecked")
        List<Beers> listBeers = (List<Beers>) sessionFactory.getCurrentSession()
                .createCriteria(Beers.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listBeers;
    }

	@Override
	@Transactional
	public void createBeer(Beers beer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(beer);
		
	}

	@Override
	@Transactional
	public void deleteBeer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(getBeer(id));
	}
	
	@Override
	@Transactional
	public Beers getBeer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Beers) session.get(Beers.class, id);
	}

	/*
	 * @Override
	@Transactional
	public void addmany() {
		ArrayList<String> pubs = new ArrayList<String>();
		pubs.add("Marynka");
		pubs.add("Kontunuacja");
		pubs.add("Szynkarnia");
		ArrayList<String> piwo = new ArrayList<String>();
		piwo.add("zuberek");
		piwo.add("tyskacz");
		piwo.add("okocim");
		
		for(int i=0;i<10;i++)
		{
			Random gen = new Random();
			Beers beer = new Beers();
			beer.setPiwo(piwo.get(gen.nextInt(2)));
			beer.setPub(pubs.get(gen.nextInt(2)));
			beer.setLink("nowe.pl");
			beer.setHalfprice(gen.nextInt(22));
			beer.setThreeprice(gen.nextInt(22));
			beer.setProgress(gen.nextInt(100));
			createBeer(beer);
		}
	}*/

}
