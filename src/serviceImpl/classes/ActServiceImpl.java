package serviceImpl.classes;

import java.util.List;

import dao.classes.ActDao;

import entity.classes.Activity;
import entity.student.Clazz;
import service.classes.ActService;

public class ActServiceImpl implements ActService{
	private ActDao dao; 
	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	public ActDao getDao() {
		return dao;
	}
	public void setDao(ActDao dao) {
		this.dao = dao;
	}
	public void save(Activity act) {
		// TODO Auto-generated method stub
		dao.save(act);
	}
	public List<Clazz> findName() {
		// TODO Auto-generated method stub
		return dao.finName();
	}
	public void save(Clazz cla) {
		// TODO Auto-generated method stub
		dao.save(cla);
	}
	public Activity findActivityByid(int id) {
		// TODO Auto-generated method stub
		return dao.findActivityByid(id);
	}	

}
