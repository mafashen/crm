package daoImpl.classes;

import java.util.List;

import dao.classes.ActDao;
import entity.classes.Activity;
import entity.student.Clazz;

public class ActDaoImpl extends BaseDaoImpl implements ActDao{

	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		String hql="from Activity";
		return getSession().createQuery(hql).list();
	}

	public void save(Activity act) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(act);
	}
	public List<Clazz> finName() {
		// TODO Auto-generated method stub
		String hql="from Clazz";
		return getSession().createQuery(hql).list();
	}

	public void save(Clazz cla) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(cla);
	}

	public Activity findActivityByid(int id) {
		// TODO Auto-generated method stub
		String hql=" from Activity a where a.id="+id;
		return (Activity) getSession().createQuery(hql).uniqueResult();
	}
}
