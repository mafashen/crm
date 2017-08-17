package serviceImpl.market;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import dao.market.ChannelDao;

import entity.market.Channel;
import service.market.ChannelService;

public class ChannelServiceImpl implements ChannelService {
	private ChannelDao cld;
	
	public ChannelDao getCld() {
		return cld;
	}

	public void setCld(ChannelDao cld) {
		this.cld = cld;
	}

	public Serializable save(Channel t) {
		// TODO Auto-generated method stub
		return cld.save(t);
	}

	public void delete(Channel t) {
		// TODO Auto-generated method stub

	}

	public void update(Channel t) {
		// TODO Auto-generated method stub
		cld.update(t);
	}

	public Channel findOne(Serializable id) {
		// TODO Auto-generated method stub
		return cld.findOne(id);
	}

	public Collection<Channel> findAll() {
		// TODO Auto-generated method stub
		return cld.findAll();
	}

	public int count() {
		// TODO Auto-generated method stub
		return cld.count();
	}

	public Collection<Channel> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		return cld.findByPage(page, size);
	}

	public void saveOrUpdate(Channel t) {
		// TODO Auto-generated method stub
		
	}

	public Collection<Channel> findByPageAndSort( int page , int size , String sort , String order ) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateIgnoreNull( Channel t ) {
		// TODO Auto-generated method stub
		return false;
	}

	public void change(int state, int id) {
		// TODO Auto-generated method stub
		if(state==1){
			cld.changTo0(id);
		}else{cld.changTo1(id);}
	}

	public void changTo1(int id) {
		// TODO Auto-generated method stub
		
	}

	public void changTo0(int id) {
		// TODO Auto-generated method stub
		
	}

	public String test(String name) {
		// TODO Auto-generated method stub
		return cld.test(name);
	}

	public List<Channel> findActi() {
		// TODO Auto-generated method stub
		return cld.findActi();
	}

}
