package action.job;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import entity.job.Company;
import entity.job.Interview;
import entity.student.Clazz;
import entity.student.Student;
import service.job.ItvService;

public class interviewAction implements RequestAware{
	
	private ItvService itvService;
	private Map<String,Object> request;
	private Interview itv;
	private int zz_id;
	private int s_id;
	private int interview_id;
	private int currentPage;
	private int totalPage;
	private List<Student> result=new ArrayList<Student>();
	
	public ItvService getItvService() {
		return itvService;
	}
	public void setItvService(ItvService itvService) {
		this.itvService = itvService;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Interview getItv() {
		return itv;
	}
	public void setItv(Interview itv) {
		this.itv = itv;
	}
	public int getZz_id() {
		return zz_id;
	}
	public void setZz_id(int zz_id) {
		this.zz_id = zz_id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getInterview_id() {
		return interview_id;
	}
	public void setInterview_id(int interview_id) {
		this.interview_id = interview_id;
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
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}

	
	
	public String information(){
		String hql="from Clazz c ";
		List<Clazz> clazzs=itvService.listAll(hql);
		request.put("clazzs", clazzs);
		hql="from Company c";
		List<Company> coms=itvService.listAll(hql);
		request.put("coms", coms);
		return "information";
	}
	public String listStudent(){
		String hql="from Student s where s.s_clazz.zz_id='"+zz_id+"'";
		result=itvService.listAll(hql);
		return "listStudent";
	}
	public String save(){
		itvService.save(itv);
		return "save";
	}
	public String listAll(){
		String hql="from Clazz c ";
		List<Clazz> clazzs=itvService.listAll(hql);
		request.put("clazzs", clazzs);
		hql="from Company c";
		List<Company> coms=itvService.listAll(hql);
		request.put("coms", coms);
		hql="from Interview i";
		List<Interview> itvs=itvService.listAll(hql, currentPage);
		request.put("itvs", itvs);
		int total = itvService.total("Interview ");
		totalPage=(total%5==0 ? total/5 : total/5+1);
		return "listAll";
	}
	public String change(){
		String hql="from Company c";
		List<Company> coms=itvService.listAll(hql);
		request.put("coms", coms);
		itv=(Interview) itvService.findOne(itv, interview_id);
		return "change";
	}
	public String delete(){
		itvService.delete(itv, interview_id);
		return "save";
	}
	public String find(){
		String hql="from Interview i where 1=1 ";
		String hql2="and i.student.s_clazz.zz_id="+itv.getStudent().getS_clazz().getZz_id();
		String hql3=" and i.com.company_id="+itv.getCom().getCompany_id();
		String hql4=" and i.itvResult="+itv.getItvResult();
		if(itv.getStudent().getS_clazz().getZz_id()!=0){
			hql=hql+hql2;
		}else if(itv.getCom().getCompany_id()!=0){
			hql=hql+hql3;
		}else if(itv.getItvResult()!=0){
			hql=hql+hql4;
		}
		List<Interview> itvs=itvService.listAll(hql);
		request.put("itvs", itvs);
		hql="from Clazz c ";
		List<Clazz> clazzs=itvService.listAll(hql);
		request.put("clazzs", clazzs);
		hql="from Company c";
		List<Company> coms=itvService.listAll(hql);
		request.put("coms", coms);
		int total = itvService.listAll(hql).size();
		totalPage=(total%5==0 ? total/5 : total/5+1);
		return "find";
	}
	public String listInterview(){
		String hql="from Interview i where i.student.s_id="+s_id;
		result=itvService.listAll(hql);
		return "listInterview";
	}
}
