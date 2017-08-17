package serviceImpl.student;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import dao.student.StudentDao;
import entity.student.Student;
import service.student.StudentService;
import util.student.PageBean;

public class StudentServiceImpl implements StudentService {
	private StudentDao	studentDao;
	
	@Override
	public PageBean<Student> getPageBean( DetachedCriteria dc , Integer currentPage , Integer pageSize ) {
		// 1.调用Dao查询总记录数
		Integer totalCount = studentDao.getTotalCount(dc);
		// 2.创建PageBean对象
		PageBean<Student> pb = new PageBean<Student>(currentPage , totalCount , pageSize);
		// 3.调用Dao查询分页列表数据
		List<Student> list = studentDao.getPageList(dc , pb.getStart() , pb.getPageSize());
		for ( Student student : list ) {
			//student.getS_clazz().getZz_subject();
		}
		// 4.列表数据放入pageBean中，并返回
		pb.setList(list);
		return pb;
	}
	
	@Override
	public List<Student> getList( DetachedCriteria dc ) {
		List<Student> list = studentDao.getList(dc);
		for ( Student student : list ) {
			//System.out.println(student.getS_clazz().getZz_name());
		}
		return list;
	}
	
	@Override
	public Student getById( Integer s_id ) {
		return studentDao.getById(s_id);
	}
	
	@Override
	public void saveOrUpdate( Student stu ) {
		studentDao.saveOrUpdate(stu);
	}
	
	public StudentDao getStudentDao( ) {
		return studentDao;
	}
	
	public void setStudentDao( StudentDao studentDao ) {
		this.studentDao = studentDao;
	}
	
	@Override
	public List<Student> findNoClassStudents( ) {
		return this.studentDao.findNoClassStudents();
	}

	@Override
	public List<Student> findAll( ) {
		return studentDao.findAll();
	}

	@Override
	public void updateClass( int sid , int cid ) {
		studentDao.updateClass(sid , cid);
	}
	
}
