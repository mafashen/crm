package entity.job;

public class Work {
	private int work_id;
	private Interview itv;
	private String workTime;//入职时间
	private int salary;
	private String message;//入职反馈
	
	public Work(){}
	
	public int getWork_id() {
		return work_id;
	}

	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}

	public Interview getItv() {
		return itv;
	}

	public void setItv(Interview itv) {
		this.itv = itv;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
