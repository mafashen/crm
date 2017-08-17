package service.classes;

import java.util.List;

import entity.classes.Activity;
import entity.classes.Review;
import entity.student.Clazz;

public interface ReviewService {
	//查找评审表信息
	public List<Review> findAll();
	public List<Clazz> findName();
	public void save(Review rev);
	public void save(Clazz cla);
	
}
