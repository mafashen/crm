package interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.system.User;
import freemarker.template.utility.StringUtil;

/**
 *		登陆过滤器
 */
public class LoginFilter implements Filter{

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		//获取会话
		HttpSession session = httpRequest.getSession();
		//检查会话中是否存在用户名 username 属性,有代表已经登录,无则重定向至登录页面
		User user =  (User) session.getAttribute("user");
		
		String basePath = httpRequest.getScheme() + "://"
				+ httpRequest.getServerName() + ":" + httpRequest.getServerPort()
				+ httpRequest.getContextPath() + "/";
		//得到访问路径
		String requestURI = httpRequest.getRequestURI();
		String contextPath = httpRequest.getContextPath();
		//System.out.println(requestURI);
		//已经登录  或者 正在访问登录页 ,请求图片资源 可以继续访问
		if(user != null || requestURI.contains("/login") || requestURI.endsWith(".png") || 
				requestURI.endsWith(".jpg")  ||requestURI.endsWith(".css")||requestURI.endsWith(".js")){
			chain.doFilter(request, response);
		}
		//访问主页予以通行
		else if(requestURI.equals(contextPath+"/") ){
			chain.doFilter(request, response);
		}
		
		else{
			httpResponse.sendRedirect(basePath +"login.jsp");
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
