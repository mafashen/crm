package daoImpl.student;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.student.BaseDao_Stu;
import entity.student.Check;

public class BaseDaoImpl_Stu<T> extends HibernateDaoSupport implements BaseDao_Stu<T> {
	private Class cla;//用于接收运行期泛型类型
	
	public BaseDaoImpl_Stu() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		cla = (Class) ptClass.getActualTypeArguments()[0];
	}
	
	
	
	public int save(T t) {
		return (Integer) getHibernateTemplate().save(t);
	}

	
	public void delete(T t) {
		
		getHibernateTemplate().delete(t);
		
	}

	
	public void delete(Serializable id) {
		T t = this.getById(id);//先取,再删
		getHibernateTemplate().delete(t);
	}

	
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(cla, id);
	}
	
	
	public List<T> getPageList(DetachedCriteria dc, Integer start,
			Integer pageSize) {
		List<T> list = (List<T>)getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

	
	public Integer getTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Integer> list = (List<Integer>)getHibernateTemplate().findByCriteria(dc);
		//清空之前设置的聚合函数
		dc.setProjection(null);
		
		if(list!=null && list.size()>0){
			Integer count = list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}
	
	
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}


	@Override
	public List<T> getList(DetachedCriteria dc) {
		List<T> list =  (List<T>)getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	

}
