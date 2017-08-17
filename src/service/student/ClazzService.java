package service.student;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import dao.student.ClazzDao;

import entity.student.Clazz;

public interface ClazzService {
	//根据班级的id查询班级的信息
	public List<Clazz> getList(DetachedCriteria dc);
	
	int save(Clazz c);
}
