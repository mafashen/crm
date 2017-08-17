package action.market;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import service.market.StateService;
import entity.market.State;

public class StateAction implements RequestAware {
	private Map<String,Object> request;
	private StateService stateservice;
	
	public String findAll(){
		
	List<State> states	=stateservice.findAll();
	request.put("states", states);
		return "success";
	}

	public StateService getStateservice() {
		return stateservice;
	}

	public void setStateservice(StateService stateservice) {
		this.stateservice = stateservice;
	}

	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
}
