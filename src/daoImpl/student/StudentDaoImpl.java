package daoImpl.student;

import java.util.List;

import org.hibernate.SQLQuery;

import dao.student.StudentDao;
import entity.student.Student;

public class StudentDaoImpl extends BaseDaoImpl_Stu<Student> implements StudentDao{

	@Override
	public List<Student> findNoClassStudents( ) {
		List list = getHibernateTemplate().find("from Student where s_clazz=null");
		return list;
	}

	@Override
	public List<Student> findAll( ) {
		List list = getHibernateTemplate().find("from Student ");
		return list;
	}

	@Override
	public void updateClass( int sid , int cid ) {
		SQLQuery query = getSession().createSQLQuery("update student set s_clazz=? where s_id=?");
		query.setInteger(0 , cid);
		query.setInteger(1 , sid);
		
		query.executeUpdate();
	}
}
