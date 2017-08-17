package action.system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.system.UserDao;
import entity.system.User;

//@Result(name="error" , value="/login.jsp")
@Controller
@Scope("prototype")
public class LoginAction implements SessionAware{
	
	private Map<String , Object>	session;
	
	String username;
	String password;
	
	@Autowired
	UserDao userDao;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		System.out.println(getUsername() + getPassword());
		if (getUsername() != null && getPassword() != null) {
			User user = userDao.login(username , password);
			if ( user != null ) {
				session.put("user" , user);
				System.out.println("登陆成功");
				return "success";
			}
		}
		System.out.println("登陆失败");
		return "error";
	}
	
	/**清空会话信息,退出登录*/
	public String logout(){
		session.remove("user");
		System.out.println("清空会话退出");
		return "logout";
	}

	public void setSession( Map<String , Object> session ) {
		this.session = session;
	}
}
