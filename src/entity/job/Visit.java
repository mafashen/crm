package entity.job;

import entity.student.Student;


public class Visit {
	private int visit_id;
	private String visit_time;
	private String visit_content;
	private Student student;//回访学员
	private String visit_img;
	
	public Visit(){}

	public int getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}

	public String getVisit_time() {
		return visit_time;
	}

	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}

	public String getVisit_content() {
		return visit_content;
	}

	public void setVisit_content(String visit_content) {
		this.visit_content = visit_content;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getVisit_img() {
		return visit_img;
	}

	public void setVisit_img(String visit_img) {
		this.visit_img = visit_img;
	}
	
}
