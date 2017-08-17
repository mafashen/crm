package dao.market;

import java.util.List;

import dao.BaseDao;
import entity.market.Channel;
import entity.market.Consulation;

public interface ChannelDao extends BaseDao<Channel> {
	public void changTo1(int id);
	public void changTo0(int id);
	public String test(String name);//查询是否已存在
	public List<Channel> findActi();//查询已激活的渠道
}
