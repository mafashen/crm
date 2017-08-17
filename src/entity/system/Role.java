package entity.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色 development("职业发展顾问"),teacher("讲师");
 * admin("管理员"),counselor("咨询师"),frontCounselor("前台咨询师"),
 * @author mafashen
 * 
 */
public class Role {

	private int cid;
	private String name;
	private Collection<Module> modules = new ArrayList<Module>(); // 角色所拥有的模块权限

	public Role() {
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Module> getModules() {
		return modules;
	}

	public void setModules(Collection<Module> modules) {
		this.modules = modules;
	}

}
