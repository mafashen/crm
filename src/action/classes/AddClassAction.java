package action.classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import service.market.ConsulationService;
import service.student.ClazzService;
import service.student.StudentService;
import dao.system.UserDao;
import entity.market.Consulation;
import entity.student.Clazz;
import entity.student.Student;
import entity.system.User;


@Controller
@Scope("prototype")
public class AddClassAction implements ModelDriven<Clazz>{
	
	@Autowired
	StudentService studentService;
	@Autowired
	ClazzService clazzService;
	@Autowired
	UserDao userDao;
	@Autowired
	ConsulationService conService;
	
	Clazz clazz = new Clazz();
	int[] sid;						//接收学生学号列表
	
	List<Student> students;
	List<User> teachers;
	List<User> advisors;
	List<Consulation> consulations;
	
	public Clazz getClazz( ) {
		return clazz;
	}

	public void setClazz( Clazz clazz ) {
		this.clazz = clazz;
	}

	public List<Student> getStudents( ) {
		return students;
	}

	public void setStudents( List<Student> students ) {
		this.students = students;
	}

	public List<User> getTeachers( ) {
		return teachers;
	}

	public void setTeachers( List<User> teachers ) {
		this.teachers = teachers;
	}

	public List<User> getAdvisors( ) {
		return advisors;
	}

	public void setAdvisors( List<User> advisors ) {
		this.advisors = advisors;
	}

	public List<Consulation> getConsulations( ) {
		return consulations;
	}

	public void setConsulations( List<Consulation> consulations ) {
		this.consulations = consulations;
	}

	public int[] getSid( ) {
		return sid;
	}

	public void setSid( int[] sid ) {
		this.sid = sid;
	}

	public String execute( ) {
		//查找所有未分班的学生, 查找所有的讲师 和 职业发展顾问
		students = studentService.findNoClassStudents();
		teachers = userDao.findUsersByRoleName(3);
		advisors = userDao.findUsersByRoleName(2);
		consulations = (List<Consulation>) conService.findAll();
		return "success";
	}
	
	public String add(){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
		clazz.setZz_open_date(format.format(new Date()));
		//添加一个班级,得到生成的主键
		int cid = clazzService.save(clazz);
		//批量更改学生班级
		for ( int id : sid ) {
			studentService.updateClass(id , cid);
		}
		return "addSuccess";
	}

	public Clazz getModel( ) {
		return clazz;
	}
	
}
