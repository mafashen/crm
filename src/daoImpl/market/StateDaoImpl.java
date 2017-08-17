package daoImpl.market;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dao.market.StateDao;
import daoImpl.BaseDaoImpl;
import entity.market.State;

public class StateDaoImpl extends BaseDaoImpl<State> implements StateDao {

	@Autowired
	public StateDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
		className = "State" ;
		cls=State.class;
	}
	@Override
	public List<State> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from " + className).list();
	}
	

	
	
	
	
}
