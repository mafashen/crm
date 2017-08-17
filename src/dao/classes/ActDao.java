package dao.classes;

import java.util.List;

import entity.classes.Activity;
import entity.student.Clazz;

public interface ActDao {
	public List<Activity> findAll();
	public List<Clazz> finName();
	public void save(Activity act);
	public void save(Clazz cla);
	public Activity findActivityByid(int id);
}
