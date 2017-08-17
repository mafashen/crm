package entity.student;

public class Talk {
	private Integer t_id;
	private Student s_id;
	private String t_talk_date;
	private String t_content;
	
	public Talk() {
	}

	public Integer getT_id() {
		return t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}

	public String getT_talk_date() {
		return t_talk_date;
	}

	public void setT_talk_date(String t_talk_date) {
		this.t_talk_date = t_talk_date;
	}

	public String getT_content() {
		return t_content;
	}

	public void setT_content(String t_content) {
		this.t_content = t_content;
	}

	public Student getS_id() {
		return s_id;
	}

	public void setS_id(Student s_id) {
		this.s_id = s_id;
	}
	
	
	
	
}
