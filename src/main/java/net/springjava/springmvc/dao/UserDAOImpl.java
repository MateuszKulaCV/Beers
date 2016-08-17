package net.springjava.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import net.springjava.springmvc.model.User;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionsFactory)
	{
		this.sessionFactory = sessionsFactory;
	}
	
	@Override
    @Transactional
    public List<User> list() {
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }

}
