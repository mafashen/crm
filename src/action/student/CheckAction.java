package action.student;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import service.student.CheckService;
import service.student.ClazzService;
import service.student.StudentService;
import util.student.PageBean;
import entity.student.Check;
import entity.student.Clazz;
import entity.student.Student;

public class CheckAction extends ActionSupport implements ModelDriven<Check>{
	private Check check = new Check();
	
	private CheckService checkService;
	private ClazzService clazzService;
	private StudentService studentService;
	
	private List<Check> checks ;
	private Integer checkClassId;
	
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception{
		DetachedCriteria dc = DetachedCriteria.forClass(Check.class);
		DetachedCriteria dc2 = DetachedCriteria.forClass(Clazz.class);
		DetachedCriteria dc3 = DetachedCriteria.forClass(Clazz.class);
		
		
		
		
		List<Clazz> list = clazzService.getList(dc2);
//		for (Clazz clazz : list) {
//			System.out.println("班级id为："+clazz.getZz_id());
//		}
		//判断并封装参数
//		if (check.getS_id()!= null && check.getS_id().getS_clazz()!= null) {
//			dc.add(Restrictions.eq("s_id.s_clazz", check.getS_id().getS_clazz()));
//			System.out.println();
//		}
		if(StringUtils.isNotBlank(check.getC_check_date())){
			dc.add(Restrictions.like("c_check_date", check.getC_check_date()));
		}
		
		if(checkClassId!=null){
			//dc.add(Restrictions.eq("s_id.s_clazz.zz_id", checkClassId));
			//dc.createAlias("s_id","i").createAlias("s_clazz","c").add(Restrictions.eq("c.zz_id",checkClassId));
			DetachedCriteria st = dc.createAlias("s_id" , "s");
			DetachedCriteria cla = st.createAlias("s.s_clazz" , "cla");
			cla.add(Restrictions.eq("cla.zz_id" , checkClassId));
		}
		
		dc.add(Restrictions.gt("c_status",1));
		PageBean<Check> pb = checkService.getPageBean(dc, currentPage, pageSize);
		
		ActionContext.getContext().put("pageBean", pb);
		ActionContext.getContext().put("clazz", list);
		return "list";
	}
	public String updateOrAdd(){
		System.out.println("测试考勤用的班级id"+checkClassId);
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		if(checkClassId!=null){
			dc.add(Restrictions.eq("s_clazz.zz_id", checkClassId));
		}
		List<Student> list = studentService.getList(dc);
		
		
		ActionContext.getContext().put("student", list);
		return "updateOrAdd";
	}
	
	public String toList(){
		
		for (Check check : checks) {
			System.out.println("测试考勤用的"+check.getC_status());
			System.out.println("测试考勤用的"+check.getC_check_date());
			System.out.println("测试考勤用的"+check.getS_id().getS_id());
			checkService.saveOrUpdate(check);
		}
		return "toList";
	}
	
	public String update(){
		System.out.println(check.getC_id());
		//根据id查询对象
		Check c = checkService.getById(check.getC_id());
		//System.out.println("测试考勤查找信息："+check.getC_id()+" "+check.getC_status()+" "+check.getC_check_date());
	    System.out.println("测试考勤查找信息："+c.getC_id()+c.getC_check_date()+c.getC_status()+c.getS_id().getS_clazz().getZz_subject());
		//System.out.println("测试开心信息："+c.getS_id().getS_clazz());
		ActionContext.getContext().put("checked", c);
		return "update";
	}
	public String toupdate(){
		checkService.saveOrUpdate(check);
		return "toupdate";
	}
	
	public String getById(){
		
		return "getById";
	}
	public Check getCheck() {
		return check;
	}
	public void setCheck(Check check) {
		this.check = check;
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
	public CheckService getCheckService() {
		return checkService;
	}
	public void setCheckService(CheckService checkService) {
		this.checkService = checkService;
	}

	public ClazzService getClazzService() {
		return clazzService;
	}

	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
	}

	
	public Check getModel() {
		// TODO Auto-generated method stub
		return check;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public List<Check> getChecks() {
		return checks;
	}
	public void setChecks(List<Check> checks) {
		this.checks = checks;
	}
	public Integer getCheckClassId() {
		return checkClassId;
	}
	public void setCheckClassId(Integer checkClassId) {
		this.checkClassId = checkClassId;
	}
	
	
	
}
