package action.market;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import service.market.ChannelService;
import service.market.ConsulationService;
import service.market.CustomerService;
import service.market.StateService;
import util.system.Pagable;
import dao.system.UserDao;
import entity.market.Channel;
import entity.market.Consulation;
import entity.market.Customer;
import entity.market.State;
import entity.system.User;

public class CustomerAction implements RequestAware,ModelDriven<Customer>,SessionAware{
	private CustomerService customerservice;
	private ConsulationService consulationservice;
	private ChannelService channelservice;
	private StateService stateservice;
	@Autowired
	private UserDao userdao;
	private Customer customer =new Customer();
	private Map<String,Object> request;
	private Map<String,Object> session;
	private InputStream inputStream;
	private Pagable pagable = new Pagable();
	
	
	public Pagable getPagable() {
		return pagable;
	}
	public void setPagable(Pagable pagable) {
		this.pagable = pagable;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public StateService getStateservice() {
		return stateservice;
	}
	public void setStateservice(StateService stateservice) {
		this.stateservice = stateservice;
	}
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public ConsulationService getConsulationservice() {
		return consulationservice;
	}
	public void setConsulationservice(ConsulationService consulationservice) {
		this.consulationservice = consulationservice;
	}
	public ChannelService getChannelservice() {
		return channelservice;
	}
	public void setChannelservice(ChannelService channelservice) {
		this.channelservice = channelservice;
	}
	public CustomerService getCustomerservice() {
		return customerservice;
	}
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	
	public String input(){
		List<Consulation> csl = consulationservice.findActi();
		List<Channel> cl = channelservice.findActi();
		List<State> st = stateservice.findAll();
		List<User> user1 = userdao.findUsersByRoleName(6);
		List<User> user = userdao.findUsersByRoleName(7);
		
		user.addAll(user1);
		
		request.put("user", user);
		request.put("csl", csl);
		request.put("cl", cl);
		request.put("st", st);
		
		return "success";
	}
	public String add(){
		
		System.out.println(customer);
		customerservice.save(customer);
		return "update";
		
	}
	public String findAll(){
		User user= (User)session.get("user");
		List<Customer> customers= null;
		
		if(user!=null&&user.getRole().getName().equals("咨询师")){
			
			customers = (List<Customer>) customerservice.findByPage(pagable.getPage(), pagable.getRows(), user.getUid());
			pagable.setTotal(customerservice.countBypage(user.getUid()));
		}else{
			
			customers = (List<Customer>) customerservice.findByPage(pagable.getPage(), pagable.getRows(), 0);
			pagable.setTotal(customerservice.countBypage(0));
		}
		
		
		List<State> st = stateservice.findAll();
		request.put("st", st);
		request.put("customers", customers);
		request.put("pagable", pagable);
//		for (State state : st) {
//			System.out.println(state.getId());
//		}
		return "success";
	}
	public String edit(){
	input();
	customer = customerservice.findOne(customer.getId());
	request.put("customer", customer);
		return "success";
	}
	public String update(){
		System.out.println(customer.getConsultant());
		customerservice.update(customer);
		return "update";
	}
	
	public String findBystate(){
		User user= (User)session.get("user");
		List<Customer> customers= null;
		
		if(user!=null&&user.getRole().getName().equals("咨询师")){
			
			customers = (List<Customer>) customerservice.findBystate(customer.getState().getId(), customer.getName(),pagable.getPage(),user.getRole().getCid() , pagable.getRows());
			pagable.setTotal(customerservice.countBystate(customer.getState().getId(), customer.getName(),pagable.getPage(),user.getRole().getCid() , pagable.getRows()));
		}else{
			
			customers = (List<Customer>) customerservice.findBystate(customer.getState().getId(), customer.getName(),pagable.getPage(),0, pagable.getRows());
			pagable.setTotal(customerservice.countBystate(customer.getState().getId(), customer.getName(),pagable.getPage(),0, pagable.getRows()));
		}
		
		
		List<State> st = stateservice.findAll();
		request.put("st", st);
		request.put("customers", customers);
		request.put("pagable", pagable);
//		for (State state : st) {
//			System.out.println(state.getId());
//		}
		
		
		
	
		return "findBystate";
	}
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	public String test(){
		String state="";
		state =customerservice.test(customer.getName());
		System.out.println(state);
		try {
			inputStream=new ByteArrayInputStream(state.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(state);
		return "test";
	}
	
	

}
