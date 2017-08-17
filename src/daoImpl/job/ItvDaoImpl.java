package daoImpl.job;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import dao.job.BaseDao;
import dao.job.ItvDao;
import entity.job.Company;
import entity.job.Interview;
import entity.job.Visit;
import entity.job.Work;
import entity.student.Clazz;
import entity.student.Student;

public class ItvDaoImpl extends BaseDao implements ItvDao {

	@Override
	public List listAll(String hql,int currentPage) {
		// TODO Auto-generated method stub
		return getSession().createQuery(hql).setFirstResult((currentPage-1)*5).setMaxResults(5).list();
	}
	
	@Override
	public List listAll(String hql) {
		// TODO Auto-generated method stub
		return getSession().createQuery(hql).list();
	}

	@Override
	public void save(Object itv) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(itv);
	}

	@Override
	public Object findOne(Object obj,int id) {
		// TODO Auto-generated method stub
		return getSession().get(Interview.class, id);
	}

	@Override
	public void delete(Object obj, int id) {
		// TODO Auto-generated method stub
		obj=findOne(obj, id);
		getSession().delete(obj);
	}

	@Override
	public int total(String table_name) {
		// TODO Auto-generated method stub
		String hql="from "+table_name;
		return getSession().createQuery(hql).list().size();
	}

	@Override
	public Work findWork(int id) {
		// TODO Auto-generated method stub
		return (Work) getSession().get(Work.class, id);
	}

	@Override
	public void deleteWork(int id) {
		// TODO Auto-generated method stub
		getSession().delete(findWork(id));
	}

	@Override
	public Visit findVisit(int id) {
		// TODO Auto-generated method stub
		return (Visit) getSession().get(Visit.class, id);
	}

	@Override
	public void deleteVisit(int id) {
		// TODO Auto-generated method stub
		getSession().delete(findVisit(id));
	}

	@Override
	public Map<String , Integer> countQuarterWork( ) {
		String hql = "select * from quarter_work ";
		SQLQuery query = getSession().createSQLQuery(hql);
		
		List list = query.list();
		Map<String , Integer> map = new HashMap<String , Integer>();
		for ( Object object : list ) {
			
			String month = ((String)((Object[])object)[0]);
			Integer count = ((BigInteger)((Object[])object)[1]).intValue();
			map.put(month , count);
		}
		System.out.println(map.keySet());
		System.out.println(map.values());
		return map;
	}

}
