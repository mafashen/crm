package service.market;

import dao.BaseDao;
import dao.market.ChannelDao;
import entity.market.Channel;

public interface ChannelService extends ChannelDao {
	public void change(int state,int id);
}
