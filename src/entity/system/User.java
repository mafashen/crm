package entity.system;

/** 管理用户 */
public class User {
	private int uid;
	private Role role; // 人物对应的角色
	private String username;
	private String password;
	private String addDate;

	public User( ) {
	}
	
	public User(int uid) {
		this.uid = uid;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role character) {
		this.role = character;
	}

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

	public String getAddDate( ) {
		return addDate;
	}

	public void setAddDate( String addDate ) {
		this.addDate = addDate;
	}

}
