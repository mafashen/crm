package serviceImpl.student;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import dao.student.ClazzDao;
import entity.student.Clazz;
import service.student.ClazzService;

public class ClazzServiceImpl implements ClazzService {
	private ClazzDao clazzDao;
	@Override
	public List<Clazz> getList(DetachedCriteria dc) {
		
		return clazzDao.getList(dc);
	}
	public ClazzDao getClazzDao() {
		return clazzDao;
	}
	public void setClazzDao(ClazzDao clazzDao) {
		this.clazzDao = clazzDao;
	}
	@Override
	public int save( Clazz c ) {
		return clazzDao.save(c);
	}
	
}
