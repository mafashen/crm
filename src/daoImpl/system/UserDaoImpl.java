package daoImpl.system;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.system.UserDao;
import daoImpl.BaseDaoImpl;
import entity.system.Role;
import entity.system.User;

@Service
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory ) {
		super(sessionFactory);
		className = "User";
		cls = User.class;
	}
	
	public User login( String username , String password ) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where username=? and password=? ");
		query.setString(0 , username);
		query.setString(1 , password);
		
		return (User) query.uniqueResult();
	}

	public List<User> findUsersByRoleName( String name ) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from User where role.name=? ");
		query.setString(0,name);
		return query.list();
	}

	public List<User> findUsersByRoleName( int cid ) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from entity.system.User where role.cid=? ");
		query.setInteger(0,cid);
//		System.out.println(query.getQueryString());
		return query.list();
	}
	
	
	
}
