package daoImpl.student;

import junit.framework.Assert;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import dao.student.CheckDao;
import entity.student.Check;

public class CheckDaoImpl extends BaseDaoImpl_Stu<Check> implements CheckDao{

	@Test
	public void testCheck(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml","classpath:student/application-studentBeans.xml");
		DetachedCriteria ck = DetachedCriteria.forClass(Check.class , "c");
		DetachedCriteria st = ck.createAlias("s_id" , "s");
		DetachedCriteria cla = st.createAlias("s_clazz" , "cla");
		cla.add(Restrictions.eq("zz_id" , 1));
		
		HibernateTemplate hibernateTemplate =new CheckDaoImpl().getHibernateTemplate();
		Assert.assertNotNull(hibernateTemplate);
		
		
//		List<Check> list = (List<Check>)hibernateTemplate.findByCriteria(ck);
//		System.out.println(list);
	}
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml","classpath:student/application-studentBeans.xml");
		SessionFactory sf = (SessionFactory) context.getBean("sessionFactory");
		CheckDaoImpl imp = (CheckDaoImpl) context.getBean("checkDao");
		
		DetachedCriteria ck = DetachedCriteria.forClass(Check.class , "c");
		DetachedCriteria st = ck.createAlias("s_id" , "s");
		DetachedCriteria cla = st.createAlias("s_clazz" , "cla");
		cla.add(Restrictions.eq("zz_id" , 1));
		
		//HibernateTemplate hibernateTemplate =imp.getHibernateTemplate();
		Assert.assertNotNull(imp);
	}
}
