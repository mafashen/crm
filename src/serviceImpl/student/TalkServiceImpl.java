package serviceImpl.student;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;

import dao.student.TalkDao;
import entity.student.Talk;
import service.student.TalkService;
import util.student.PageBean;

public class TalkServiceImpl implements TalkService {
	private TalkDao talkDao;
	@Override
	public PageBean<Talk> getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		//1.调用Dao查询总记录数
		Integer totalCount = talkDao.getTotalCount(dc);
		//2.创建PageBean对象
		PageBean<Talk> pb = new PageBean<Talk>(currentPage, totalCount, pageSize);
		
		dc.setProjection(null); 
		dc.setResultTransformer(CriteriaSpecification.ROOT_ENTITY); 
		
		//3.调用Dao查询分页列表数据
		List<Talk> list = talkDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		for (Talk talk : list) {
			System.out.println("谈话测试："+talk.getT_id()+" "+talk.getT_talk_date()+" "+talk.getT_content()+" "+talk.getS_id().getS_clazz().getZz_subject());
		}
		//4.列表数据放入pageBean中，并返回
		pb.setList(list);
		return pb;
	}

	@Override
	public void saveOrUpdate(Talk talk) {
		// TODO Auto-generated method stub
		talkDao.saveOrUpdate(talk);
	}

	@Override
	public Talk getById(Integer t_id) {
		// TODO Auto-generated method stub
		return talkDao.getById(t_id);
	}

	public TalkDao getTalkDao() {
		return talkDao;
	}

	public void setTalkDao(TalkDao talkDao) {
		this.talkDao = talkDao;
	}
	

}
