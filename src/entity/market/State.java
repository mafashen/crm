package entity.market;

import java.util.Set;

public class State {
	private Integer id;
	private String name;
	private Set<Customer> customers;
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
	
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	public State() {
		super();
	}
	public State(Integer id, String name, Set<Customer> customers) {
		super();
		this.id = id;
		this.name = name;
		this.customers = customers;
	}
	
	
}
