package action.classes;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import dao.system.UserDao;

import service.classes.ReviewService;
import service.classes.Review_CaseService;
import service.student.StudentService;
import entity.classes.Review;
import entity.classes.Review_Case;
import entity.student.Clazz;
import entity.student.Student;
import entity.system.User;

public class ReviewAction implements RequestAware {
	private Map<String , Object>	request;
	private ReviewService			reviewservice;
	private Review_CaseService		reviewcaseservice;
	
	private StudentService			studentservice;
	private Review					rev;
	private int						sid;
	int								rid;
	private Review_Case				rev_case;
	private Student					stu;
	private int						ids[];
	private int						grades[];
	
	@Autowired
	UserDao							userDao;
	
	List<User>						teachers;
	
	public List<User> getTeachers( ) {
		return teachers;
	}
	
	public void setTeachers( List<User> teachers ) {
		this.teachers = teachers;
	}
	
	public String addreview( ) {
		// 查询所有评审的信息，然后将它们放入到request对象中
		List<Review> revs = reviewservice.findAll();
		request.put("revs" , revs);
		List<Review_Case> revscase = reviewcaseservice.findAll();
		request.put("revscase" , revscase);
		List<Clazz> clas = reviewservice.findName();
		request.put("clas" , clas);
		
		teachers = userDao.findUsersByRoleName(3);
		return "addreview";
	}
	
	// 保存表单提交评审信息
	public String save( ) {
		reviewservice.save(rev);
		
		// 同时将选择的班级中的所有学生添加至评审详情表
		int cid = rev.getPs().getZz_id();
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		dc.add(Restrictions.eq("s_clazz.zz_id" , cid));
		List<Student> list = studentservice.getList(dc);
		
		for ( Student student : list ) {
			Review_Case rc = new Review_Case();
			rc.setRev_id(rev);
			rc.setStu_id(student);
			reviewcaseservice.save(rc);
		}
		
		List<Review> reviews = reviewservice.findAll();
		request.put("reviews" , reviews);
		return "input";
	}
	
	// 查询所有评审信息和评审情况信息，然后将它们放到request对象中
	public String input( ) {
		List<Review> reviews = reviewservice.findAll();
		request.put("reviews" , reviews);
		List<Review_Case> revcases = reviewcaseservice.findAll();
		request.put("revcases" , revcases);
		return "input";
	}
	
	// 查询学生信息，然后将它们放到request对象中
	public String psb( ) {
		List<Student> stus = studentservice.findAll();
		request.put("stus" , stus);
		List<Review_Case> revcases = reviewcaseservice.findGrade(rid);
		System.out.println(revcases == null ? "null" : revcases.size());
		request.put("revcases" , revcases);
		return "psb";
	}
	
	public String savegrade( ) {
		List<Student> stus = studentservice.findAll();
		request.put("stus" , stus);
		List<Review_Case> revcases = reviewcaseservice.findGrade(rid);
		request.put("revcases" , revcases);
		return "savegrade";
	}
	
	public String s_grade( ) {
		for ( int i = 0 ; i < grades.length ; i++ ) {
			int id = ids[i];
			int grade = grades[i];
			reviewcaseservice.updateGrade(id , grade);
			
		}
		return "s_grade";
	}
	
	public void setRequest( Map<String , Object> request ) {
		this.request = request;
	}
	
	public ReviewService getReviewService( ) {
		return reviewservice;
	}
	
	public void setReviewService( ReviewService reviewService ) {
		this.reviewservice = reviewService;
	}
	
	public ReviewService getReviewservice( ) {
		return reviewservice;
	}
	
	public void setReviewservice( ReviewService reviewservice ) {
		this.reviewservice = reviewservice;
	}
	
	public Review getRev( ) {
		return rev;
	}
	
	public void setRev( Review rev ) {
		this.rev = rev;
	}
	
	public Review_CaseService getReviewcaseservice( ) {
		return reviewcaseservice;
	}
	
	public void setReviewcaseservice( Review_CaseService reviewcaseservice ) {
		this.reviewcaseservice = reviewcaseservice;
	}
	
	public Review_Case getRev_case( ) {
		return rev_case;
	}
	
	public void setRev_case( Review_Case rev_case ) {
		this.rev_case = rev_case;
	}
	
	public StudentService getStudentservice( ) {
		return studentservice;
	}
	
	public void setStudentservice( StudentService studentservice ) {
		this.studentservice = studentservice;
	}
	
	public Student getStu( ) {
		return stu;
	}
	
	public void setStu( Student stu ) {
		this.stu = stu;
	}
	
	public int getSid( ) {
		return sid;
	}
	
	public void setSid( int sid ) {
		this.sid = sid;
	}
	
	public int[] getGrades( ) {
		return grades;
	}
	
	public void setGrades( int[] grades ) {
		this.grades = grades;
	}
	
	public int[] getIds( ) {
		return ids;
	}
	
	public void setIds( int[] ids ) {
		this.ids = ids;
	}
	
	public int getRid( ) {
		return rid;
	}
	
	public void setRid( int rid ) {
		this.rid = rid;
	}
	
}
