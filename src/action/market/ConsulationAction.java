package action.market;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import service.market.ConsulationService;
import util.system.Pagable;

import com.opensymphony.xwork2.ModelDriven;

import entity.market.Consulation;

public class ConsulationAction implements RequestAware,ModelDriven<Consulation>{
	private Map<String,Object> request;
	private ConsulationService consulationservice;
	private Consulation consulation = new Consulation();
	private InputStream inputStream;
	private Pagable pagable = new Pagable();
	


	public Pagable getPagable() {
		return pagable;
	}

	public void setPagable(Pagable pagable) {
		this.pagable = pagable;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Consulation getConsulation() {
		return consulation;
	}

	public void setConsulation(Consulation consulation) {
		this.consulation = consulation;
	}


	public ConsulationService getConsulationservice() {
		return consulationservice;
	}

	public void setConsulationservice(ConsulationService consulationservice) {
		this.consulationservice = consulationservice;
	}

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

	public Consulation getModel() {
		// TODO Auto-generated method stub
		return consulation;
	}
	public String update(){
		consulationservice.update(consulation);
		return "change";
	}
	public String findAll(){
		List<Consulation> clts =  (List<Consulation>) consulationservice.findByPage(pagable.getPage(), pagable.getRows());
		pagable.setTotal(consulationservice.count());
		request.put("clts", clts);
		request.put("pagable", pagable);
		return "success";
	}
	public String edit(){
		Consulation cs = consulationservice.findOne(consulation.getId());
		request.put("cs", cs);
		return "success";
	}
	public String change(){
		int id=consulation.getId();
		int state = consulationservice.findOne(consulation.getId()).getState();
		consulationservice.change(state, id);
		return "change";
	}
	public String add(){
		consulationservice.save(consulation);
		return "add";
	}
	public String test(){
		String state="";
		state =consulationservice.test(consulation.getName());
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
