package serviceImpl.student;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;

import service.student.CheckService;
import util.student.PageBean;
import dao.student.CheckDao;
import entity.student.Check;

public class CheckServiceImpl implements CheckService {
	private CheckDao checkDao;
	@Override
	public PageBean<Check> getPageBean(DetachedCriteria dc,
			Integer currentPage, Integer pageSize) {
				//1.调用Dao查询总记录数
				Integer totalCount = checkDao.getTotalCount(dc);
				//2.创建PageBean对象
				PageBean<Check> pb = new PageBean<Check>(currentPage, totalCount, pageSize);
				
				dc.setProjection(null); 
				dc.setResultTransformer(CriteriaSpecification.ROOT_ENTITY); 
				
				//3.调用Dao查询分页列表数据
				List list =checkDao.getPageList(dc,pb.getStart(),pb.getPageSize());
				System.out.println("@@@@@@@@@@@@@@@@@@@@@2222"+list);
//				for (Check check : list) {
//					System.out.println("--------------------"+check.getS_id().getS_clazz().getZz_name());
//				}
				for (int i = 0; i < list.size(); i++) {
					System.out.println("--------------------"+((Check)list.get(i)).getS_id().getS_clazz().getZz_name());
				}
				//4.列表数据放入pageBean中，并返回
				pb.setList(list);
				return pb;
	}
	@Override
	public void saveOrUpdate(Check check) {
		// TODO Auto-generated method stub
		checkDao.saveOrUpdate(check);
	}
	@Override
	public Check getById(Integer c_id) {
		// TODO Auto-generated method stub
		return checkDao.getById(c_id);
	}
	public CheckDao getCheckDao() {
		return checkDao;
	}
	public void setCheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}
	

	
}
