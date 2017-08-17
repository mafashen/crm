package service.student;

import org.hibernate.criterion.DetachedCriteria;

import util.student.PageBean;
import entity.student.Check;

public interface CheckService {
	//分页查询学院考勤情况
	PageBean<Check> getPageBean(DetachedCriteria dc,Integer currentPage,Integer pageSize);
	//存储信息
	void saveOrUpdate(Check check);
	//根据Id查询考勤表信息
	Check getById(Integer c_id);
}
