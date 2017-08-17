package dao.classes;

import java.util.List;

import entity.classes.Review;
import entity.classes.Review_Case;

public interface Review_CaseDao {
	public List<Review_Case> findAll();
	public List<Review_Case> findGrade(/*int sid ,*/ int rid);
	public void save(int id,int grade);
	
	void save(Review_Case rc);
	
	/**更新评审分数*/
	void updateGrade(int id , int grade);
}
