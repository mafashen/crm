package daoImpl.market;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import dao.market.ChannelDao;
import daoImpl.BaseDaoImpl;
import entity.market.Channel;


public class ChannelDaoImpl extends BaseDaoImpl<Channel> implements ChannelDao {

	public ChannelDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
		className = "Channel";
		cls =Channel.class;
	}
	
	
	public void update(Channel t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(t);
	}
	
	public Channel findOne(Serializable id) {
		// TODO Auto-generated method stub
		return (Channel) sessionFactory.getCurrentSession().get(cls , id);
	}

	public Collection<Channel> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		if(page==0){
			page=1;
		}
		if(size==0){
			size=5;
		}
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from " + className)
			.setFirstResult( ( page - 1 ) * size)
				.setMaxResults(size);
		return query.list();
		
	}

	

	public void changTo1(int id) {
		// TODO Auto-generated method stub
		String hql="update Channel  set state=1 where id="+id;
		Query query = sessionFactory.getCurrentSession()
		.createQuery(hql);
		query.executeUpdate();
	}

	public void changTo0(int id) {
		// TODO Auto-generated method stub
		String hql="update Channel set state=0 where id="+id;
		Query query = sessionFactory.getCurrentSession()
		.createQuery(hql);
		query.executeUpdate();
	}

	public String test(String name) {
		// TODO Auto-generated method stub
		//注意字段拼接
		String hql="from Channel where name='"+name+"'";
		Query query = sessionFactory.getCurrentSession()
		.createQuery(hql);
		if(query.uniqueResult()!=null){
			return "1";
		}else{
			return "0";
		}
	}
	
	public int count() {
		// TODO Auto-generated method stub
		Long count = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from " + className)
		.uniqueResult();
		return count.intValue();
	}

	public List<Channel> findActi() {
		// TODO Auto-generated method stub
		
		Query query = sessionFactory.getCurrentSession()
		.createQuery("from " + className +" where state=1 ");
		return query.list();
	}

	

}
