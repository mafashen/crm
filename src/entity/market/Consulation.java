package entity.market;
/*咨询类别*/
public class Consulation {
	
	@Override
	public String toString() {
		return "Consulation [id=" + id + ", name=" + name + ", state=" + state
				+ "]";
	}
	private Integer id;
	private String name;
	private int state;
	public Consulation(Integer id, String name, int state) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
	}
	public Consulation() {
		super();
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
