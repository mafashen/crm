package entity.student;

import entity.market.Consulation;
import entity.system.User;

public class Clazz {
	private Integer		zz_id;
	private String		zz_subject;
	private String		zz_name;
	private String		zz_open_date;
	private Consulation	zz_con;
	private User teacher;			//关联讲师
	private User advisor;			//关联职业发展顾问
	
	public Clazz( ) {
	}
	
	public Integer getZz_id( ) {
		return zz_id;
	}
	
	public void setZz_id( Integer zz_id ) {
		this.zz_id = zz_id;
	}
	
	public String getZz_subject( ) {
		return zz_subject;
	}
	
	public void setZz_subject( String zz_subject ) {
		this.zz_subject = zz_subject;
	}
	
	public String getZz_name( ) {
		return zz_name;
	}
	
	public void setZz_name( String zz_name ) {
		this.zz_name = zz_name;
	}
	
	public String getZz_open_date( ) {
		return zz_open_date;
	}
	
	public void setZz_open_date( String zz_open_date ) {
		this.zz_open_date = zz_open_date;
	}
	
	public Consulation getZz_con( ) {
		return zz_con;
	}
	
	public void setZz_con( Consulation zz_con ) {
		this.zz_con = zz_con;
	}

	public User getTeacher( ) {
		return teacher;
	}

	public void setTeacher( User teacher ) {
		this.teacher = teacher;
	}

	public User getAdvisor( ) {
		return advisor;
	}

	public void setAdvisor( User advisor ) {
		this.advisor = advisor;
	}
	
}
