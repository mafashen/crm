package dao.student;


import java.util.List;

import entity.student.Student;

public interface StudentDao extends BaseDao_Stu<Student>{

	/**
	 * 查找还没有分班级的所有学生
	 * @return
	 */
	List<Student> findNoClassStudents();
	
	List<Student> findAll();
	
	/**
	 * 更改学员班级
	 * @param sid	学员id
	 * @param cid	班级id
	 */
	void updateClass(int sid , int cid);
}
