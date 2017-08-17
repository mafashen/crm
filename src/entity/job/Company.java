package entity.job;

import java.util.HashSet;
import java.util.Set;

import entity.student.Student;

public class Company {
	private int company_id;
	private String company_name;
	private String company_address;
	private String company_tel;
	private String company_cooperation;
	//private Set<Interview> interviews=new HashSet<Interview>();
	
	public Company(){}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_address() {
		return company_address;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public String getCompany_tel() {
		return company_tel;
	}

	public void setCompany_tel(String company_tel) {
		this.company_tel = company_tel;
	}

	public String getCompany_cooperation() {
		return company_cooperation;
	}

	public void setCompany_cooperation(String company_cooperation) {
		this.company_cooperation = company_cooperation;
	}

	


	
}
