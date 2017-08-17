package test.system;

import java.util.List;

import junit.framework.Assert;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import service.classes.Review_CaseService;
import service.market.ConsulationService;
import service.student.StudentService;

import dao.BaseDao;
import dao.market.CustomerDao;
import dao.student.CheckDao;
import dao.system.NoticeDao;
import dao.system.UserDao;
import daoImpl.student.BaseDaoImpl_Stu;
import daoImpl.student.CheckDaoImpl;
import entity.student.Check;
import entity.student.Student;
import entity.system.Role;
import entity.system.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml",
								"classpath:applicationBeans.xml"})
public class TestBaseDao {
	
	//@Autowired
	private UserDao userDao;
	//@Autowired
	private BaseDao<User> baseDao;
	//@Autowired
	//RoleDao roleDao;
	//@Autowired
	NoticeDao noticeDao;
	//@Autowired
	StudentService studentService;
	
	//@Autowired
	Review_CaseService reService;
	
	//@Autowired
	SessionFactory sessionFactory;
	
	//@Autowired
	ConsulationService conService;
	
	@Autowired
	@Qualifier("csd")
	CustomerDao customerDao;
	
	@Test
	public void testFindAll(){
		//System.out.println(roleDao);
		//Assert.assertNotNull(userDao);
		List<User> all = (List<User>) userDao.findAll();
		//List<Role> all = (List<Role>) roleDao.findAll();
		System.out.println(all.get(0).getRole().getCid());
	}
	
	@Test
	public void testCount(){
		System.out.println(userDao.count());
	}
	
	@Test
	public void testLogin(){
		System.out.println(userDao.login("ma" , "123"));
	}
	
	@Test
	public void testPaging(){
		System.out.println(userDao.findByPage(1 , 5));
	}
	
	@Test
	public void testSort(){
		List<User> findByPageAndSort = 
				(List<User>) userDao.findByPageAndSort(1 , 5 , "uid" , "asc");
		System.out.println(findByPageAndSort.get(0).getUid());
	}
	
	@Test
	public void testUpdate(){
		User user = new User();
		user.setUid(5);
		user.setUsername("余南星");
		Role role = new Role();
		role.setCid(1);
		user.setRole(role);
		userDao.updateIgnoreNull(user);
	}
	
	@Test
	public void testDelete(){
		userDao.delete(new User(5));
	}
	
	@Test
	public void testGetOne(){
		userDao.findOne(1);
	}
	
	@Test
	public void testFindByCondition(){
		System.out.println(noticeDao.findByPageAndCondition(1 , 5 , null , null , "2017-08-09").size());
	}
	
	@Test
	public void testFindByRole(){
		System.out.println(userDao.findUsersByRoleName("前台咨询师").size());
	}
	
	@Test
	@Transactional
	public void testCheck(){
		Session session = sessionFactory.getCurrentSession();
		
		//Query query = session.createQuery("from Check where s_id.s_clazz.zz_id = 1");
		
//		session.createCriteria(arg0)
		DetachedCriteria ck = DetachedCriteria.forClass(Check.class , "c");
		DetachedCriteria st = ck.createAlias("s_id" , "s");
		DetachedCriteria cla = st.createAlias("s_clazz" , "cla");
		cla.add(Restrictions.eq("zz_id" , 1));
		
		HibernateTemplate hibernateTemplate = new BaseDaoImpl_Stu<Check>().getHibernateTemplate();
		Assert.assertNotNull(hibernateTemplate);
		
		
//		List<Check> list = (List<Check>)hibernateTemplate.findByCriteria(ck);
//		System.out.println(list);
	}
	
	@Test
	public void testStudent(){
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		dc.add(Restrictions.eq("s_clazz.zz_id" , 1));
		System.out.println(studentService.getList(dc ));
	}
	
	@Test
	public void testReview(){
		System.out.println(reService.findGrade(5));
	}
	
	@Test
	public void testCon(){
		System.out.println(conService.findAll());
	}
	
	@Test
	public void testCustomerDao(){
		customerDao.countQuarterlyState(0);
	}
	
	@Test
	public void test(){
		int i = 1;
		int j = Integer.MAX_VALUE;
		j+=2L;
		System.out.println(j);
		long m = Integer.MAX_VALUE;
	}
}
