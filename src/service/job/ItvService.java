package service.job;

import java.util.List;
import java.util.Map;

import entity.job.Visit;
import entity.job.Work;


public interface ItvService {
	public List listAll(String hql,int currentPage);
	public List listAll(String hql);
	public void save(Object itv);
	public Object findOne(Object obj,int id);
	public void delete(Object obj,int id);
	public void deleteWork(int id);
	public int total(String table_name);
	public Work findWork(int id);
	public Visit findVisit(int id);
	public void deleteVisit(int id);
	
	public Map<String , Integer> countQuarterWork( );
}
