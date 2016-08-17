package net.springjava.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

}
