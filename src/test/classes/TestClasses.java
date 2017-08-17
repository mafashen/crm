package test.classes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entity.classes.Activity;
import entity.student.Clazz;

import service.classes.ActService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml",
								"classpath:applicationBeans.xml",
								"classpath:classes/classes-beans.xml"})
public class TestClasses {
	
	@Autowired
	ActService actService;
	
	@Test
	public void testSaveActivity(){
		Activity act = new Activity();
		act.setAddress("艾溪湖");
		act.setDate("2017-04-20");
		act.setName("一阶段集体活动");
		Clazz clz = new Clazz();
		clz.setZz_id(1);
		act.setTeacid(clz );
		actService.save(act );
	}
}
