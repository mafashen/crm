package daoImpl.classes;

import java.util.List;

import org.hibernate.Query;

import dao.classes.ReviewDao;
import dao.classes.Review_CaseDao;

import entity.classes.Review;
import entity.classes.Review_Case;

public class Review_CaseDaoImpl extends BaseDaoImpl implements Review_CaseDao {
	public List<Review_Case> findAll( ) {
		
		String hql = "from Review_Case";
		return getSession().createQuery(hql).list();
	}
	
	public List<Review_Case> findGrade( /* int sid , */int rid ) {
		// TODO Auto-generated method stub
		String hql = "from Review_Case r where  r.rev_id = " + rid;
		
		List<Review_Case> sb = getSession().createQuery(hql).list();
		return sb;
	}
	
	public void save( int id , int grade ) {
		// TODO Auto-generated method stub
		Review_Case rc = (Review_Case) getSession().get(Review_Case.class , id);
		rc.setGrade(grade);
		getSession().saveOrUpdate(rc);
		System.out.println(id + ":" + grade);
	}
	
	@Override
	public void save( Review_Case rc ) {
		getSession().save(rc);
	}
	
	@Override
	public void updateGrade( int id , int grade ) {
		Query query = getSession().createQuery("update Review_Case set grade=? where  id=?");
		query.setInteger(0 , grade);
		query.setInteger(1 , id);
		query.executeUpdate();
	}
}
