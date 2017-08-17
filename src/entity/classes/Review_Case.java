package entity.classes;

import entity.student.Student;

public class Review_Case {
	private int id;
	private int grade;
	private Review rev_id=new Review();
	private Student stu_id=new Student();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Review getRev_id() {
		return rev_id;
	}
	public void setRev_id(Review rev_id) {
		this.rev_id = rev_id;
	}
	public Student getStu_id() {
		return stu_id;
	}
	public void setStu_id(Student stu_id) {
		this.stu_id = stu_id;
	}
	
}
