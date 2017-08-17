package dao.market;

import java.util.List;

import dao.BaseDao;
import entity.market.Consulation;

public interface ConsulationDao extends BaseDao<Consulation> {
	
	public void changTo1(int id);
	public void changTo0(int id);
	public String test(String name);
	public List<Consulation> findActi();//查询已激活的咨询类别
}
