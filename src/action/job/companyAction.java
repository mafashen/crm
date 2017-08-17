package action.job;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import entity.job.Company;
import service.job.ComService;

public class companyAction implements RequestAware{
	
	private int company_id;
	private String company_name;
	private Company com;
	private int currentPage;
	private int totalPage;
	private ComService comservice;
	private Map<String,Object> request;
	
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public ComService getComservice() {
		return comservice;
	}
	public void setComservice(ComService comservice) {
		this.comservice = comservice;
	}
	public Company getCom() {
		return com;
	}
	public void setCom(Company com) {
		this.com = com;
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
	
	
	
	
	public String add(){
		comservice.save(com);
		return "add";
	}
	public String listAll(){
		List<Company> coms=comservice.listAll(currentPage);
		int total = comservice.total();
		totalPage=(total%5==0 ? total/5 : total/5+1);
		request.put("coms", coms);
		return "listAll";
	}
	public String change(){//findOne
		com=comservice.change(company_id);
		request.put("com", com);
		return "change";
	}
	public String find(){
		List<Company> coms=comservice.find(company_name);
		request.put("coms", coms);
		totalPage=1;
		return "find";
	}
	public String delete(){
		comservice.delete(company_id);
		return "add";
	}
}
