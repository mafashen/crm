package daoImpl.classes;

import java.util.List;

import dao.classes.ReviewDao;

import entity.classes.Review;
import entity.student.Clazz;

public class ReviewDaoImpl extends BaseDaoImpl implements ReviewDao{
	
	public List<Review> findAll(){
		
		String hql="from Review";
		return getSession().createQuery(hql).list();
	}

	public List<Clazz> findName() {
		// TODO Auto-generated method stub
		String hql="from Clazz";
		return getSession().createQuery(hql).list();
	}

	public void save(Review rev) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(rev);
	}

	public void save(Clazz cla) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(cla);
	}
}	
