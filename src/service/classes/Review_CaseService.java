package service.classes;

import java.util.List;

import entity.classes.Review_Case;

public interface Review_CaseService {
	//查询所有的评审信息
	public List<Review_Case> findAll();

	public List<Review_Case> findGrade(/*int sid,*/ int rid);
	public void save(int id,int grade);
	
	void save( Review_Case rc );
	
	void updateGrade(int id , int grade);
}
