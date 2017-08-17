package daoImpl.classes;

import java.util.List;

import org.hibernate.SQLQuery;

import dao.classes.StudentDao;

import entity.student.Student;

public class StudentDaoImpl extends BaseDaoImpl implements StudentDao{
	public List<Student> findAll(){
		String hql="from Student";
		return getSession().createQuery(hql).list();
	}

}
