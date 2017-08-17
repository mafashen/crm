package serviceImpl.classes;

import java.util.List;

import dao.classes.ReviewDao;
import dao.classes.StudentDao;

import entity.student.Student;
import service.classes.StudentService;

public class StudentServiceImpl implements StudentService{
	private StudentDao dao;
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	public StudentDao getDao() {
		return dao;
	}
	public void setDao(StudentDao dao) {
		this.dao = dao;
	}
	
	
}
