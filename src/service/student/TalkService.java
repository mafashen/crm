package service.student;

import org.hibernate.criterion.DetachedCriteria;

import util.student.PageBean;
import entity.student.Talk;

public interface TalkService {
	//分页查询谈话情况
	PageBean<Talk> getPageBean(DetachedCriteria dc,Integer currentPage,Integer pageSize);
	//存储信息
	void saveOrUpdate(Talk talk);
	//根据Id查询谈话表信息
	Talk getById(Integer t_id);
}
