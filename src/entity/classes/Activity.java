package entity.classes;

import entity.student.Clazz;
import entity.system.User;

public class Activity {
	private int id;
	private String name;
	private String Address;
	private String date;
	private Clazz Teacid=new Clazz();
	private User teacher;
	
	public Activity() {
		super();
	}
	public Activity(int id, String name, String address, String date,
			Clazz teacid) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
		this.date = date;
		Teacid = teacid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Clazz getTeacid() {
		return Teacid;
	}
	public void setTeacid(Clazz teacid) {
		Teacid = teacid;
	}
	public User getTeacher( ) {
		return teacher;
	}
	public void setTeacher( User teacher ) {
		this.teacher = teacher;
	}
	
}
