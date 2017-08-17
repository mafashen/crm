package action.student;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import service.student.ClazzService;
import service.student.StudentService;
import service.student.TalkService;
import util.student.PageBean;
import entity.student.Check;
import entity.student.Clazz;
import entity.student.Student;
import entity.student.Talk;

public class TalkAction extends ActionSupport implements ModelDriven<Talk>{
	private Talk talk = new Talk();
	
	private TalkService talkService;
	private ClazzService clazzService;
	private StudentService studentService;
	
	private List<Talk> talks;
	private Integer checkClassId;
	private Integer currentPage;
	private Integer pageSize;
	public String list(){
		DetachedCriteria dc = DetachedCriteria.forClass(Talk.class);
		
		DetachedCriteria dc2 = DetachedCriteria.forClass(Clazz.class);
		List<Clazz> list = clazzService.getList(dc2);
		
		if(StringUtils.isNotBlank(talk.getT_talk_date())){
			dc.add(Restrictions.like("t_talk_date", talk.getT_talk_date()));
		}
		if(checkClassId!=null){
			DetachedCriteria st = dc.createAlias("s_id", "s");
			DetachedCriteria cla = st.createAlias("s.s_clazz", "cla");
			cla.add(Restrictions.eq("cla.zz_id",checkClassId));
		}
		
		PageBean<Talk> pb = talkService.getPageBean(dc, currentPage, pageSize);
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
		for (Talk talk : talks) {
			System.out.println("测试谈话用的"+talk.getT_content());
			System.out.println("测试谈话用的"+talk.getT_talk_date());
			System.out.println("测试谈话用的"+talk.getS_id().getS_id());
			talkService.saveOrUpdate(talk);
		}
			
		return "toList";
	}
	
	public String update(){
		System.out.println(talk.getT_id());
		//根据id查询对象
		Talk t = talkService.getById(talk.getT_id());
		//System.out.println("测试考勤查找信息："+check.getC_id()+" "+check.getC_status()+" "+check.getC_check_date());
	    System.out.println("测试谈话信息："+t.getT_id()+t.getT_talk_date()+t.getT_content()+t.getS_id().getS_clazz().getZz_subject());
		//System.out.println("测试开心信息："+c.getS_id().getS_clazz());
		ActionContext.getContext().put("talked", t);
		return "update";
	}
	public String toupdate(){
		talkService.saveOrUpdate(talk);
		return "toupdate";
	}
	
	public Talk getModel() {
		return talk;
	}
	public TalkService getTalkService() {
		return talkService;
	}
	public void setTalkService(TalkService talkService) {
		this.talkService = talkService;
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
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Integer getCheckClassId() {
		return checkClassId;
	}
	public void setCheckClassId(Integer checkClassId) {
		this.checkClassId = checkClassId;
	}
	public List<Talk> getTalks() {
		return talks;
	}
	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}
	
	
	
	
}
