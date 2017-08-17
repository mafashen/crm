package serviceImpl.classes;

import java.util.List;

import service.classes.Review_CaseService;

import dao.classes.ReviewDao;
import dao.classes.Review_CaseDao;
import entity.classes.Review;
import entity.classes.Review_Case;

public class Review_CaseServiceImpl  implements Review_CaseService{
	private Review_CaseDao dao;
	public List<Review_Case> findAll(){
		return dao.findAll();	
	}
	public List<Review_Case> findGrade(/*int sid,*/ int rid) {
		// TODO Auto-generated method stub
		return dao.findGrade( rid);
	}
	public Review_CaseDao getDao() {
		return dao;
	}
	public void setDao(Review_CaseDao dao) {
		this.dao = dao;
	}
	public void save(int id,int grade) {
		// TODO Auto-generated method stub
		dao.save(id,grade);
	}
	@Override
	public void save( Review_Case rc ) {
		dao.save(rc);
	}
	@Override
	public void updateGrade( int id , int grade ) {
		dao.updateGrade(id , grade);
	}
	
	
}
