package test.market;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.market.ConsulationService;
import service.market.CustomerService;
import dao.BaseDao;
import dao.system.UserDao;
import entity.market.State;
import entity.system.User;

public class Testconnection {
	
	ApplicationContext		context;
	{
		context = new ClassPathXmlApplicationContext("classpath:market/market-beans.xml" , "classpath:applicationContext.xml");
	}
	@Autowired
	private UserDao			userdao;
	private BaseDao<State>	baseDao;
	
	public UserDao getUserdao( ) {
		return userdao;
	}
	
	public void setUserdao( UserDao userdao ) {
		this.userdao = userdao;
	}
	
	public BaseDao<State> getBaseDao( ) {
		return baseDao;
	}
	
	public void setBaseDao( BaseDao<State> baseDao ) {
		this.baseDao = baseDao;
	}
	
	@Test
	public void test1( ) {
		// System.out.println(baseDao.findAll());
		ConsulationService service = (ConsulationService) context.getBean("consulationservice");
		// System.out.println(service.findOne(1));
		// System.out.println(service.test("1"));
		// System.out.println(service.findActi(1, 3));
	}
	
	@Test
	public void test2( ) {
		CustomerService service = (CustomerService) context.getBean("customerservice");
		// System.out.println(service.findBystate(-1,"陌" , 1, 3));
	}
	
}
