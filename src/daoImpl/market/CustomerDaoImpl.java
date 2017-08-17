package daoImpl.market;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import dao.market.CustomerDao;
import daoImpl.BaseDaoImpl;
import entity.market.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
	
	public CustomerDaoImpl( SessionFactory sessionFactory ) {
		super(sessionFactory);
		className = "Customer";
		cls = Customer.class;
	}
	
	public void saveOrUpdate( Customer t ) {
		
	}
	
	public Serializable save( Customer t ) {
		
		return sessionFactory.getCurrentSession().save(t);
	}
	
	public void delete( Customer t ) {
		
	}
	
	public void update( Customer t ) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}
	
	public boolean updateIgnoreNull( Customer t ) {
		
		return false;
	}
	
	public Customer findOne( Serializable id ) {
		
		return (Customer) sessionFactory.getCurrentSession().get(cls , id);
	}
	
	public Collection<Customer> findAll( ) {
		
		return null;
	}
	
	public int count( ) {
		
		Long count = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from " + className).uniqueResult();
		return count.intValue();
		
	}
	
	public Collection<Customer> findByPage( int page , int size ) {
		
		if ( page == 0 ) {
			page = 1;
		}
		if ( size == 0 ) {
			size = 5;
		}
		Query query = sessionFactory.getCurrentSession().createQuery("from " + className).setFirstResult( ( page - 1 ) * size).setMaxResults(size);
		
		return query.list();
		
	}
	
	public Collection<Customer> findByPage( int page , int size , int found_id ) {
		
		String hql = "";
		if ( page == 0 ) {
			page = 1;
		}
		if ( size == 0 ) {
			size = 5;
		}
		if ( found_id != 0 ) {
			hql = "where found = " + found_id;
		}
		Query query = sessionFactory.getCurrentSession().createQuery("from " + className + hql).setFirstResult( ( page - 1 ) * size)
				.setMaxResults(size);
		
		return query.list();
	}
	
	public int countBystate( long id , String name , int page , int found_id , int size ) {
		
		if ( page == 0 ) {
			page = 1;
		}
		if ( size == 0 ) {
			size = 5;
		}
		String hql = "select count(*) from Customer where 1 = 1 ";
		if ( id != -1 ) {
			hql = hql + " and state = " + id;
		}
		if ( name != null && !"".equals(name) ) {
			hql = hql + " and name like '%" + name + "%'";
		}
		if ( found_id != 0 ) {
			hql = hql + " and founder =" + found_id;
		}
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long count = (Long) query.uniqueResult();
		System.out.println(count.intValue());
		return count.intValue();
		
	}
	
	public List<Customer> findBystate( long id , String name , int page , int found_id , int size ) {
		
		if ( page == 0 ) {
			page = 1;
		}
		if ( size == 0 ) {
			size = 5;
		}
		String hql = "from Customer where 1 = 1 ";
		if ( id != -1 ) {
			hql = hql + " and state = " + id;
		}
		if ( name != null && !"".equals(name) ) {
			hql = hql + " and name like '%" + name + "%'";
		}
		if ( found_id != 0 ) {
			hql = hql + " and founder =" + found_id;
		}
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setFirstResult( ( page - 1 ) * size).setMaxResults(size);
		List<Customer> customers = query.list();
		System.out.println(query.getQueryString());
		
		return customers;
	}
	
	public int countBypage( int found_id ) {
		
		String hql = "";
		if ( found_id != 0 ) {
			hql = "where found = " + found_id;
		}
		Long count = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from " + className + hql).uniqueResult();
		return count.intValue();
	}
	public String test(String name) {
		// TODO Auto-generated method stub
		String hql="from Customer where name='"+name+"'";
		Query query = sessionFactory.getCurrentSession()
		.createQuery(hql);
		System.out.println(query.toString());
		System.out.println(query.uniqueResult());
		if(query.uniqueResult()!=null){
			return "1";
		}else{
			return "0";
		}
	}

	
	public List<Customer> findBystate( long id , String name , int page , int size ) {
		if ( page == 0 ) {
			page = 1;
		}
		if ( size == 0 ) {
			size = 5;
		}
		String hql = "from Customer where 1 = 1 ";
		if ( id != -1 ) {
			hql = hql + " and state = " + id;
		}
		if ( name != null && !"".equals(name) ) {
			hql = hql + " and name like '%" + name + "%'";
		}
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setFirstResult( ( page - 1 ) * size).setMaxResults(size);
		List<Customer> customers = query.list();
		System.out.println(query.toString());
		
		return customers;
	}
	
	public int countBystate( long id , String name , int page , int size ) {
		if ( page == 0 ) {
			page = 1;
		}
		if ( size == 0 ) {
			size = 5;
		}
		String hql = "select count(*) from Customer where 1 = 1 ";
		if ( id != -1 ) {
			hql = hql + " and state = " + id;
		}
		if ( name != null && !"".equals(name) ) {
			hql = hql + " and name like '%" + name + "%'";
		}
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long count = (Long) query.uniqueResult();
		System.out.println(count.intValue());
		return count.intValue();
		
	}
	
	public int countByid( int id ) {
		String hql = "select count(*) from Customer where state = " + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long count = (Long) query.uniqueResult();
		return count.intValue();
	}
	
	public Map<String , Integer> countQuarterlyState( int state ) {
		String hql = "select * from quarter_signup ";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(hql);
		
		List list = query.list();
		Map<String , Integer> map = new HashMap<String , Integer>();
		for ( Object object : list ) {
			
			String month = ( (String) ( (Object[]) object )[0] );
			Integer count = ( (BigInteger) ( (Object[]) object )[1] ).intValue();
			map.put(month , count);
		}
		System.out.println(map.keySet());
		System.out.println(map.values());
		return map;
	}
}
