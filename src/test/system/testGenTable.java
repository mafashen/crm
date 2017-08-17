package test.system;

import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daoImpl.BaseDaoImpl;
import entity.system.Module;
import entity.system.Notice;
import entity.system.Role;
import entity.system.User;

public class testGenTable {
	
	ApplicationContext context;
	SessionFactory sf = null;
	
	{
		context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		sf = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Test
	public void testGenTable(){
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Module m1 = new Module();
		m1.setM_name("系统管理");
		m1.setUrl("#");
		
		
		Module module1 = new Module();
		module1.setM_name("用户管理");
		module1.setUrl("#");
		module1.setParent(m1);
		
		Module module2 = new Module();
		module2.setM_name("权限管理");
		module2.setUrl("#");
		module2.setParent(m1);
		
		Module module3 = new Module();
		module3.setM_name("公告管理");
		module3.setUrl("#");
		module3.setParent(m1);
		
		m1.getChild().add(module1);
		m1.getChild().add(module2);
		m1.getChild().add(module3);
		System.out.println("子模块个数:"+m1.getChild().size());
		//openSession.save(module);
		
		entity.system.Role c1 = new Role();
		c1.setName("管理员");
		
		entity.system.Role c2 = new Role();
		c2.setName("职业发展顾问");
		
		entity.system.Role c3 = new Role();
		c3.setName("讲师");
		
		entity.system.Role c4 = new Role();
		c4.setName("前台咨询师");
		
		entity.system.Role c5 = new Role();
		c5.setName("咨询师");
		
		c1.getModules().add(m1);
		
		User user = new User("ma","123");
		user.setRole(c1);
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		session.save(c5);
		
		Serializable save = session.save(user);
		System.out.println(save);
		tr.commit();
		session.close();
		
	}
	
	//@Test
	public void testBeans(){
		BaseDaoImpl<User> dao = (BaseDaoImpl<User>) context.getBean("baseDao");
		//dao.run();
		assertNotNull(dao);
	}
	
	@Test
	public void notice(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		for ( int i = 6 ; i < 10 ; i++ ) {
			Notice n1 = new Notice();
			n1.setTitle("测试标题"+i);
			n1.setContent("测试内容"+i);
			n1.setPush_date(format.format(new Date()));

			User user = new User();
			user.setUid(1);
			n1.setUser(user);
			
			session.saveOrUpdate(n1);
		}
		
		tr.commit();
		session.close();
	}
}
