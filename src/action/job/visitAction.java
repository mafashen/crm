package action.job;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import service.job.ItvService;

import entity.job.Visit;
import entity.job.Work;
import entity.student.Student;

public class visitAction {
	private Visit visit;
	private File visit_img;
	private String visit_imgFileName;
	private ItvService itvService;
	private Map<String,Object> request;
	private int currentPage;
	private int totalPage;
	private List<Visit> visits;
	private int visit_id;
	private int s_id;
	private String s_name;
	private List<Student> students;
	

	public Visit getVisit() {
		return visit;
	}
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	public File getVisit_img() {
		return visit_img;
	}
	public void setVisit_img(File visit_img) {
		this.visit_img = visit_img;
	}
	public String getVisit_imgFileName() {
		return visit_imgFileName;
	}
	public void setVisit_imgFileName(String visit_imgFileName) {
		this.visit_imgFileName = visit_imgFileName;
	}
	public ItvService getItvService() {
		return itvService;
	}
	public void setItvService(ItvService itvService) {
		this.itvService = itvService;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public List<Visit> getVisits() {
		return visits;
	}
	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
	public int getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	//public
	
	
	
	public String save(){
		String path=ServletActionContext.getServletContext().getRealPath("/uploads");
		String filePath=path+"/"+visit_imgFileName;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
			try {
				fis = new FileInputStream(visit_img);
				fos = new FileOutputStream(filePath);
				int len=0;
				byte[] buffer=new byte[1024];
				while((len=fis.read(buffer))!=-1){
					fos.write(buffer,0,len);}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		visit.setVisit_img(visit_imgFileName);
		String hql="from Student s where s_id='"+s_id+"' ";
		Student stu=(Student) itvService.listAll(hql).get(0);
		visit.setStudent(stu);
		itvService.save(visit);
		currentPage=1;
		return "save";
	}
	public String listAll(){
		String hql="from Visit v";
		visits=itvService.listAll(hql, currentPage);
		int total = itvService.total("Visit ");
		totalPage=(total%5==0 ? total/5 : total/5+1);
		return "listAll";
	}
	public String change(){
		visit=itvService.findVisit(visit_id);
		String hql="from Student s";
		students=itvService.listAll(hql);
		return "change";
	}
	public String delete(){
		currentPage=1;
		itvService.deleteVisit(visit_id);
		return "save";
	}
	public String find(){
		String hql="from Visit v where v.student.s_name like '%"+s_name+"%' ";
		visits=itvService.listAll(hql, currentPage);
		int total = itvService.listAll(hql).size();
		totalPage=(total%5==0 ? total/5 : total/5+1);
		return "find";
	}
	public String listStudents(){
		String hql="from Student s";
		students=itvService.listAll(hql);
		return "listStudents";
	}
	
	
	
	
	
	
	
	
}
