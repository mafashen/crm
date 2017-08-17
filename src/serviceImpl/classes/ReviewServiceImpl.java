package serviceImpl.classes;

import java.util.List;

import dao.classes.ReviewDao;

import entity.classes.Review;
import entity.student.Clazz;

import service.classes.ReviewService;

public class ReviewServiceImpl implements ReviewService{
	private ReviewDao dao;
	public List<Review> findAll(){
		return dao.findAll();	
	}
	public ReviewDao getDao() {
		return dao;
	}
	public void setDao(ReviewDao dao) {
		this.dao = dao;
	}
	public List<Clazz> findName() {
		// TODO Auto-generated method stub
		return dao.findName();
	}
	public void save(Review rev) {
		// TODO Auto-generated method stub
		dao.save(rev);
	}
	public void save(Clazz cla) {
		// TODO Auto-generated method stub
		dao.save(cla);
	}
	
}
