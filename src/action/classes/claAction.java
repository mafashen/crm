package action.classes;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.classes.ActService;
import dao.system.UserDao;
import entity.classes.Activity;
import entity.student.Clazz;
import entity.system.User;

public class claAction implements RequestAware {
	private Map<String , Object>	request;
	private ActService				actservice;
	private Activity				act;
	
	@Autowired
	UserDao							userDao;
	
	List<User>						teachers;
	
	public List<User> getTeachers( ) {
		return teachers;
	}
	
	public void setTeachers( List<User> teachers ) {
		this.teachers = teachers;
	}
	
	public String add( ) {
		// 查询所有活动的信息，然后将它们放入到request对象中
		// List<Activity> acts=actservice.findAll();
		List<Clazz> clas = actservice.findName();
		// request.put("acts", acts);
		request.put("clas" , clas);
		
		teachers = userDao.findUsersByRoleName(3);
		return "add";
	}
	
	// 编辑方法
	public String edit( ) {
		// 查询所有班级的信息，然后将它们放入到request对象中
		List<Clazz> clas = actservice.findName();
		request.put("clas" , clas);
		// 根据id查对应的活动
		act = actservice.findActivityByid(act.getId());
		return "edit";
	}
	
	// 保存表单提交的活动信息
	public String save( ) {
		actservice.save(act);
		List<Activity> acts = actservice.findAll();
		//List<Clazz> clas = actservice.findName();
		request.put("acts" , acts);
		//request.put("clas" , clas);
		return "save";
	}
	
	// 列举所有的活动信息
	public String list( ) {
		
		List<Activity> acts = actservice.findAll();
		request.put("acts" , acts);
		return "list";
	}
	
	// 更新活动信息的方法
	public String update( ) {
		actservice.save(act);
		return "success";
	}
	
	public void setRequest( Map<String , Object> request ) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public ActService getActservice( ) {
		return actservice;
	}
	
	public void setActservice( ActService actservice ) {
		this.actservice = actservice;
	}
	
	public Activity getAct( ) {
		return act;
	}
	
	public void setAct( Activity act ) {
		this.act = act;
	}
	
	@Test
	public void test( ) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml" , "classpath:classes/classes-beans.xml");
		ActService service = (ActService) context.getBean("ActService");
		Assert.assertNotNull(service);
	}
}
