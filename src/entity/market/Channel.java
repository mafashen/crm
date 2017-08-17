package entity.market;
/*渠道*/
public class Channel {
	
	private Integer id;
	private String name;
	private int state;
	public Channel(Integer id, String name, int state) {
		this.id = id;
		this.name = name;
		this.state = state;
	}
	public Channel() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
