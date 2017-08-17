package daoImpl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Test;

import dao.BaseDao;
import entity.system.Role;
import entity.system.User;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	protected SessionFactory	sessionFactory;
	// protected Session session;
	protected  Class 			cls;
	protected  String			className;
	
	public BaseDaoImpl( SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
		//className = cls.getSimpleName();
	}
	
	public Serializable save( T t ) {
		return sessionFactory.getCurrentSession().save(t);
	}
	
	
	public void delete( T t ) {
		sessionFactory.getCurrentSession().delete(t);
	}
	
	public void update( T t ) {
		sessionFactory.getCurrentSession().update(t);
	}
	
	public void saveOrUpdate(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}
	
	public T findOne( Serializable id ) {
		return (T) sessionFactory.getCurrentSession().get(cls , id);
	}
	
	public Collection<T> findAll( ) {
		return sessionFactory.getCurrentSession().createQuery("from " + className).list();
	}
	
	public int count( ) {
		Long count = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from " + className)
				.uniqueResult();
		return count.intValue();
	}
	
	public Collection<T> findByPage( int page , int size ) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from " + className)
					.setFirstResult( ( page - 1 ) * size)
						.setMaxResults(size);
		return query.list();
	}
	
	public Collection<T> findByPageAndSort( int page , int size , String sort , String order ) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from " + className + " order by " + sort + " "+ order)
					.setFirstResult( ( page - 1 ) * size)
						.setMaxResults(size);
		return query.list();
	}
	
	public boolean updateIgnoreNull(T t){
		String id = null;
		
		Field[] declaredFields = cls.getDeclaredFields();
		String[] fields = new String[declaredFields.length];
		for ( int i = 0 ; i < declaredFields.length ; i++ ) {
			String name = declaredFields[i].getName();
			if ( name.endsWith("id") ) {
				id = name;
				continue;
			}
			fields[i] = name;
		}
		
		StringBuilder sb = new StringBuilder("update "+cls.getSimpleName()+" set ");
		
		List<Object> objs = new ArrayList<Object>();
		
		for ( int i = 0 ; i < fields.length ; i++ ) {
			try {
				String f = fields[i];
				if ( f != null ) {
					String method = f.substring(0 , 1).toUpperCase()+f.substring(1);
					Method get = cls.getDeclaredMethod("get"+method , null);
					Object invoke = get.invoke(t , null);
					if ( invoke != null ) {
						sb.append(f + " = ? ,");
						objs.add(invoke);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		
		String method = id.substring(0 , 1).toUpperCase()+id.substring(1);
		Object idValue ;
		try {
			Method get = cls.getDeclaredMethod("get"+method , null);
			idValue = get.invoke(t , null);
			objs.add(idValue);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		sb.replace(sb.length()-1 , sb.length() , "")
			.append(" where " + id + " = ?");
		System.out.println(sb.toString());
		
		Query query = sessionFactory.getCurrentSession().createQuery(sb.toString());
		for ( int i = 0 ; i < objs.size() ; i++ ) {
			query.setParameter(i , objs.get(i));
		}
		return query.executeUpdate() > 0;
	}
	
}
