package dao.classes;

import java.util.List;

import entity.classes.Review;
import entity.student.Clazz;

public interface ReviewDao {
	public List<Review> findAll();
	public List<Clazz> findName();
	public void save(Review rev);
	public void save(Clazz cla);
}	
