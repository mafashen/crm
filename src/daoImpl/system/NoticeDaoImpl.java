package daoImpl.system;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.system.NoticeDao;
import daoImpl.BaseDaoImpl;
import entity.system.Notice;

@Service
public class NoticeDaoImpl extends BaseDaoImpl<Notice> implements NoticeDao{

	@Autowired
	public NoticeDaoImpl( SessionFactory sessionFactory ) {
		super(sessionFactory);
		className = "Notice";
		cls = Notice.class;
	}

	
	public List<Notice> findByPageAndCondition( int page , int rows , String username , String from , String to ) {
		StringBuilder hql = new StringBuilder(" from Notice where 1=1 ");
		hql.append(notNull(username) ? (" and user.username = '" + username + "'") : "");
		hql.append(notNull(from) ? (" and push_date >= '" + from + "'") : "");
		hql.append(notNull(to) ? (" and push_date <= '" + to + "'") : "");
		Query query = sessionFactory.getCurrentSession()
					.createQuery(hql.toString()).setFirstResult((page-1)*rows)
						.setMaxResults(rows);
		return query.list();
	}

	public int count(String username , String from , String to ) {
		StringBuilder hql = new StringBuilder("select count(*) from Notice where 1=1 ");
		hql.append(notNull(username) ? (" and user.username = '" + username + "'") : "");
		hql.append(notNull(from) ? (" and push_date >= '" + from + "'") : "");
		hql.append(notNull(to) ? (" and push_date <= '" + to + "'") : "");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		Long count = (Long) query.uniqueResult();
		return count.intValue();
	}
	
	private boolean notNull(String str){
		return (str != null) && (!"".equals(str.trim()));
	}
}
