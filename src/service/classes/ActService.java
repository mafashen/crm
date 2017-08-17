package service.classes;

import java.util.List;

import entity.classes.Activity;
import entity.student.Clazz;

public interface ActService {
	//查询所有活动信息
	public List<Activity> findAll();
	public List<Clazz> findName();
	public void save(Activity act);
	public void save(Clazz cla);
	//根据id查活动
	public Activity findActivityByid(int id);
}
