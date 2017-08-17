package action.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import util.system.Pagable;

import com.opensymphony.xwork2.ModelDriven;

import dao.system.ModuleDao;
import dao.system.RoleDao;
import entity.system.Module;
import entity.system.Role;

@Controller
@Scope("prototype")
public class RoleManageAction implements ModelDriven<Pagable>{
	
	@Autowired
	RoleDao		roleDao;
	@Autowired
	ModuleDao moduleDao;
	
	List<Role>	roles;
	List<Module> modules;
	Role role;
	int	cid;
	
	Pagable pagable = new Pagable();

	
	public Pagable getModel( ) {
		return pagable;
	}
	
	public Pagable getPagable( ) {
		return pagable;
	}

	public void setPagable( Pagable pagable ) {
		this.pagable = pagable;
	}

	public List<Role> getRoles( ) {
		return roles;
	}
	
	public void setRoles( List<Role> roles ) {
		this.roles = roles;
	}
	
	public List<Module> getModules( ) {
		return modules;
	}

	public void setModules( List<Module> modules ) {
		this.modules = modules;
	}

	public Role getRole( ) {
		return role;
	}

	public void setRole( Role role ) {
		this.role = role;
	}

	public int getCid( ) {
		return cid;
	}

	public void setCid( int cid ) {
		this.cid = cid;
	}

	public String execute( ) {
		pagable.setTotal(roleDao.count());
		modules = (List<Module>) moduleDao.findAll();
		roles = (List<Role>) roleDao.findByPage(pagable.getPage() , pagable.getRows());
		return "list";
	}
	
	public String findOne(){
		setRole(roleDao.findOne(cid));
		return "one";
	}
	
	public String update(){
		roleDao.update(getRole());
		return "success";
	}

}
