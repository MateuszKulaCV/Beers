package net.springjava.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
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

}
