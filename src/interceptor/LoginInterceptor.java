package interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import action.system.LoginAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import entity.system.User;

public class LoginInterceptor implements Interceptor , ServletRequestAware{

	private static final long serialVersionUID = 1L;
	private HttpServletRequest	request;

	
	public void destroy() {
		
	}

	
	public void init() {
		
	}

	
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		User user = (User) session.get("user");
		if ( user != null ) {
			System.out.println("已登录");
			return actionInvocation.invoke();
		}else{
			System.out.println("未登录");
			if ( actionInvocation.getAction() instanceof LoginAction ) {
				System.out.println("登录中");
				return actionInvocation.invoke();
			}
			return "login";
		}
	}


	public void setServletRequest( HttpServletRequest req ) {
		this.request = req;
	}


}
