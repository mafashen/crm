package entity.job;

import org.apache.struts2.json.annotations.JSON;

import entity.student.Clazz;
import entity.student.Student;

public class Interview {
	private int interview_id;
	private Student student;
	private String itvTime;
	private Company com;
	private String itvContent;
	private String itvAddress;
	private int itvResult;//1成功   2失败
	
	public Interview(){}
	public int getInterview_id() {
		return interview_id;
	}
	public void setInterview_id(int interview_id) {
		this.interview_id = interview_id;
	}
	
	
	@JSON(serialize=false)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getItvTime() {
		return itvTime;
	}
	public void setItvTime(String itvTime) {
		this.itvTime = itvTime;
	}
	public Company getCom() {
		return com;
	}
	public void setCom(Company com) {
		this.com = com;
	}
	public String getItvContent() {
		return itvContent;
	}
	public void setItvContent(String itvContent) {
		this.itvContent = itvContent;
	}
	public String getItvAddress() {
		return itvAddress;
	}
	public void setItvAddress(String itvAddress) {
		this.itvAddress = itvAddress;
	}
	public int getItvResult() {
		return itvResult;
	}
	public void setItvResult(int itvResult) {
		this.itvResult = itvResult;
	}
	
	
}
