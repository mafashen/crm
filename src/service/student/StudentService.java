package service.student;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import entity.student.Student;
import util.student.PageBean;

public interface StudentService {
	//分页查询学员的信息
	PageBean<Student> getPageBean(DetachedCriteria dc,Integer currentPage,Integer pageSize);
	//保存信息
	void saveOrUpdate(Student stu);
	
	//根据id查询学生信息
	Student getById(Integer s_id);
	
	//根据班级id不分页查询所有信息
	public List<Student> getList(DetachedCriteria dc);
	
	List<Student> findNoClassStudents( );
	
	List<Student> findAll();
	
	/**
	 * 更改学员班级
	 * @param sid	学员id
	 * @param cid	班级id
	 */
	void updateClass(int sid , int cid);
	
}
