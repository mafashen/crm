package action.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import util.system.Pagable;

import com.opensymphony.xwork2.ModelDriven;

import dao.system.RoleDao;
import dao.system.UserDao;
import entity.system.Role;
import entity.system.User;

@Controller
@Scope("prototype")
public class UserManageAction implements ModelDriven<Pagable> {
	
	@Autowired
	UserDao			userDao;
	@Autowired
	RoleDao			roleDao;
	
	private Pagable	pagable	= new Pagable();
	List<User>		users;
	List<Role>		roles;
	int				uid;
	User			user;
	
	public List<Role> getRoles( ) {
		return roles;
	}
	
	public void setRoles( List<Role> roles ) {
		this.roles = roles;
	}
	
	public User getUser( ) {
		return user;
	}
	
	public void setUser( User user ) {
		this.user = user;
	}
	
	public int getUid( ) {
		return uid;
	}
	
	public void setUid( int uid ) {
		this.uid = uid;
	}
	
	public List<User> getUsers( ) {
		return users;
	}
	
	public void setUsers( List<User> users ) {
		this.users = users;
	}
	
	public Pagable getModel( ) {
		return pagable;
	}
	
	public Pagable getPagable( ) {
		//pagable.setTotal(userDao.count());
		return pagable;
	}
	
	public void setPagable( Pagable pagable ) {
		this.pagable = pagable;
	}
	
	public String find( ) {
		System.out.println("UserManagerAction.find()");
		users = (List<User>) userDao.findAll();
		return "find";
	}
	
	public String execute( ) {
		System.out.println("UserManagerAction.execute()");
		// 设置总页数
		 pagable.setTotal(userDao.count());
		roles = (List<Role>) roleDao.findAll();
		users = (List<User>) userDao.findByPage(pagable.getPage() , pagable.getRows());
		return "list";
	}
	
	public String delete( ) {
		userDao.delete(new User(getUid()));
		return "success";
	}
	
	public String findOne( ) {
		user = userDao.findOne(getUid());
		return "one";
	}
	
	public String update( ) {
		userDao.updateIgnoreNull(getUser());
		return "success";
	}
	
	public String add( ) {
		userDao.save(getUser());
		return "success";
	}
}
