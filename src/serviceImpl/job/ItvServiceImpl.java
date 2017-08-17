package serviceImpl.job;

import java.util.List;
import java.util.Map;

import dao.job.ItvDao;
import entity.job.Interview;
import entity.job.Visit;
import entity.job.Work;

import service.job.ItvService;

public class ItvServiceImpl implements ItvService {
	private ItvDao itvDao;
	
	public ItvDao getItvDao() {
		return itvDao;
	}

	public void setItvDao(ItvDao itvDao) {
		this.itvDao = itvDao;
	}

	
	public List listAll(String hql,int currentPage) {
		// TODO Auto-generated method stub
		return itvDao.listAll(hql, currentPage);
	}
	
	
	public List listAll(String hql) {
		// TODO Auto-generated method stub
		return itvDao.listAll(hql);
	}

	
	public void save(Object itv) {
		// TODO Auto-generated method stub
		itvDao.save(itv);
	}

	
	public Object findOne(Object obj, int id) {
		// TODO Auto-generated method stub
		return itvDao.findOne(obj, id);
	}

	
	public void delete(Object obj, int id) {
		// TODO Auto-generated method stub
		itvDao.delete(obj, id);
	}

	
	public int total(String table_name) {
		// TODO Auto-generated method stub
		return itvDao.total(table_name);
	}

	
	public Work findWork(int id) {
		// TODO Auto-generated method stub
		return itvDao.findWork(id);
	}

	
	public void deleteWork(int id) {
		// TODO Auto-generated method stub
		itvDao.deleteWork(id);
	}

	
	public Visit findVisit(int id) {
		// TODO Auto-generated method stub
		return itvDao.findVisit(id);
	}

	
	public void deleteVisit(int id) {
		// TODO Auto-generated method stub
		itvDao.deleteVisit(id);
	}

	@Override
	public Map<String , Integer> countQuarterWork( ) {
		return itvDao.countQuarterWork();
	}

}
