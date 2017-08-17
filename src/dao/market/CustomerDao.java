package dao.market;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import dao.BaseDao;
import entity.market.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	public List<Customer> findBystate(long id,String name,int page,int found_id,int size);
	//根据登录人角色查询
	//public List<Customer> findByuser(long id,String name,String found,int page,int size);
	public int countByid(int id);//查询状态不同的客户总数
	public int countBystate(long id,String name,int page,int found_id,int size);
	public Collection<Customer> findByPage(int page, int size,int found_id);
	public int countBypage(int found_id);
	public String test(String name);
	
	/**
	 * 统计季度性的状态信息
	 * @param state	状态  如 已报名 待跟进...
	 * @return
	 */
	Map<String , Integer> countQuarterlyState(int state);

}
