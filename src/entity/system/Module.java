package entity.system;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 模块
 * 
 * @author mafashen
 *
 */
public class Module {

	private int mid;

	private String m_name;

	private String url;

	/**
	 * 关联的子模块
	 */
	private Set<Module> child = new HashSet<Module>();

	private Module parent;

	// private Set<Role> roles = new HashSet<>();
	
	public Module() {
	}

	public Module(String m_name, String url) {
		super();
		this.m_name = m_name;
		this.url = url;
	}

	public Module getParent() {
		return parent;
	}

	public void setParent(Module parent) {
		this.parent = parent;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Module> getChild() {
		return child;
	}

	public void setChild(Set<Module> child) {
		this.child = child;
	}

	@Override
	public String toString( ) {
		return "Module [mid=" + mid + ", m_name=" + m_name + ", url=" + url + "]";
	}
	
}
