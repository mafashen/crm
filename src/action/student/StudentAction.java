package action.student;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import service.student.ClazzService;
import service.student.StudentService;
import util.student.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.student.Clazz;
import entity.student.Student;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private Student student = new Student();
	private StudentService studentService;
	private ClazzService clazzService;
	
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception{
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		
		DetachedCriteria dc2 = DetachedCriteria.forClass(Clazz.class);
		List<Clazz> list = clazzService.getList(dc2);
		//判断并封装参数
		if(StringUtils.isNotBlank(student.getS_name())){
			dc.add(Restrictions.like("s_name", "%"+student.getS_name()+"%"));
		}

		if(student.getS_clazz()!=null&&student.getS_clazz().getZz_id()!=null){
			dc.add(Restrictions.eq("s_clazz.zz_id", student.getS_clazz().getZz_id()));
		}
		
		//dc.add(Restrictions)
		PageBean<Student> pb = (PageBean<Student>)studentService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pb);
		ActionContext.getContext().put("clazz", list);
		return "list";
	}
	
	public String updateOrAdd() throws Exception {
		studentService.saveOrUpdate(student);
		return "toList";
	}

	public String toList() throws Exception {
		
		//根据id查询对象
		Student su = studentService.getById(student.getS_id());
		//将查询的对象放入request域，转发到修改页面
		ActionContext.getContext().put("student", su);
		
		return "updateOrAdd";
	}


	
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public ClazzService getClazzService() {
		return clazzService;
	}

	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
	}
	
	
}
