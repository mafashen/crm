package entity.student;

public class Student {
	private Integer s_id;
	private String s_name;
	private String s_sex;
	private Clazz s_clazz;
	private String s_graduate;
	private String s_education;
	private String s_major;
	private String s_place;
	private String s_tel;
	private String s_qq;
	private String s_sign_date;
	public Student() {
	}
	
	public Student(String s_name, String s_sex) {
		this.s_name = s_name;
		this.s_sex = s_sex;
	}

	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}



	public Clazz getS_clazz() {
		return s_clazz;
	}

	public void setS_clazz(Clazz s_clazz) {
		this.s_clazz = s_clazz;
	}

	public String getS_graduate() {
		return s_graduate;
	}
	public void setS_graduate(String s_graduate) {
		this.s_graduate = s_graduate;
	}
	public String getS_education() {
		return s_education;
	}
	public void setS_education(String s_education) {
		this.s_education = s_education;
	}
	public String getS_major() {
		return s_major;
	}
	public void setS_major(String s_major) {
		this.s_major = s_major;
	}
	public String getS_place() {
		return s_place;
	}
	public void setS_place(String s_place) {
		this.s_place = s_place;
	}
	public String getS_tel() {
		return s_tel;
	}
	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}
	public String getS_qq() {
		return s_qq;
	}
	public void setS_qq(String s_qq) {
		this.s_qq = s_qq;
	}
	public String getS_sign_date() {
		return s_sign_date;
	}
	public void setS_sign_date(String s_sign_date) {
		this.s_sign_date = s_sign_date;
	}
	
	
	
}
