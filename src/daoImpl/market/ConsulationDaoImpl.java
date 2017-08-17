package daoImpl.market;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import dao.market.ConsulationDao;
import daoImpl.BaseDaoImpl;
import entity.market.Consulation;

public class ConsulationDaoImpl extends BaseDaoImpl<Consulation> implements
		ConsulationDao {

	public ConsulationDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		className = "Consulation";
		cls= Consulation.class;
	}

	public Collection<Consulation> findByPage(int page, int size) {
		if(page==0){
			page=1;
		}
		if(size==0){
			size=5;
		}
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from " + className)
			.setFirstResult( ( page - 1 ) * size)
				.setMaxResults(size);
		return query.list();
		
	}

	

	public void changTo1(int id) {
		String hql="update Consulation  set state=1 where id="+id;
		Query query = sessionFactory.getCurrentSession()
		.createQuery(hql);
		query.executeUpdate();
	}

	public void changTo0(int id) {
		String hql="update Consulation set state=0 where id="+id;
		Query query = sessionFactory.getCurrentSession()
		.createQuery(hql);
		query.executeUpdate();
	}

	public String test(String name) {
		//注意字段拼接
		String hql="from Consulation where name='"+name+"'";
		Query query = sessionFactory.getCurrentSession()
		.createQuery(hql);
		if(query.uniqueResult()!=null){
			return "1";
		}else{
			return "0";
		}
	}

	public List<Consulation> findActi() {
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from " + className +" where state=1 ");
		return query.list();
	}

}
