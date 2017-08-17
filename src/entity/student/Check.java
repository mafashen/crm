package entity.student;

public class Check {
	private Integer c_id;
	private Student s_id;
	private String c_check_date;
	private Integer c_status;
	public Check() {
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getC_check_date() {
		return c_check_date;
	}
	public void setC_check_date(String c_check_date) {
		this.c_check_date = c_check_date;
	}
	
	public Integer getC_status() {
		return c_status;
	}
	public void setC_status(Integer c_status) {
		this.c_status = c_status;
	}
	public Student getS_id() {
		return s_id;
	}
	public void setS_id(Student s_id) {
		this.s_id = s_id;
	}
	
	
	
	
}
