package action.job;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import service.job.ItvService;
import entity.job.Company;
import entity.job.Interview;
import entity.job.Work;
import entity.student.Clazz;
import entity.student.Student;

public class workAction implements RequestAware{
	private int work_id;
	private Work work;
	private Interview itv;
	private int currentPage;
	private int totalPage;
	private ItvService itvService;
	private Map<String,Object> request;
	private int s_id;
	private String a;
	
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}
	public Work getWork() {
		return work;
	}
	public void setWork(Work work) {
		this.work = work;
	}
	public Interview getItv() {
		return itv;
	}
	public void setItv(Interview itv) {
		this.itv = itv;
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
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	
	
	
	public String save(){
		//根据学员，企业找到对应的面试记录
		String hql="from Interview i where i.com.company_id="+work.getItv().getCom().getCompany_id();
		String hql2=" and i.student.s_id="+work.getItv().getStudent().getS_id();
		hql=hql+hql2;
		itv=(Interview) itvService.listAll(hql).get(0);//1条记录
		work.setItv(itv);
		itvService.save(work);
		return "save";
	}
	public String listAll(){
		String hql="from Clazz c ";
		List<Clazz> clazzs=itvService.listAll(hql);
		request.put("clazzs", clazzs);
		hql="from Company c";
		List<Company> coms=itvService.listAll(hql);
		request.put("coms", coms);
		hql="from Work w";
		List<Work> works=itvService.listAll(hql, currentPage);
		request.put("works", works);
		int total = itvService.total("Work ");
		totalPage=(total%5==0 ? total/5 : total/5+1);
		return "listAll";
	}
	public String change(){
		work=itvService.findWork(work_id);
		return "change";
	}
	public String delete(){
		itvService.deleteWork(work_id);
		currentPage=1;
		return "save";
	}
	public String find(){
		String hql="from Work w where 1=1 ";
		String hql2="and w.itv.student.s_clazz.zz_id="+work.getItv().getStudent().getS_clazz().getZz_id();
		String hql3=" and w.itv.com.company_id="+work.getItv().getCom().getCompany_id();
		if(work.getItv().getStudent().getS_clazz().getZz_id()!=0){
			hql=hql+hql2;
		}else if(work.getItv().getCom().getCompany_id()!=0){
			hql=hql+hql3;
		}
		List<Work> works=itvService.listAll(hql);
		request.put("works", works);
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
	public String info(){//通过s_id查找最新的一条work记录
		String hql="from Work w where w.itv.student.s_id="+s_id+" order by w.workTime desc";
		work=(Work) itvService.listAll(hql).get(0);
		return "info";
	}
}
