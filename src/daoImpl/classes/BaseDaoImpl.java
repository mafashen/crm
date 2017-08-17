package daoImpl.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDaoImpl {
	
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
		
	}
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
}
