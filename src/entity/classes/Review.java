package entity.classes;

import entity.student.Clazz;
import entity.system.User;

public class Review {
	private int		id;
	private String	name;
	private String	review_time;
	private Clazz	Ps	= new Clazz();
	private User    teacher;
	
	public int getId( ) {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getName( ) {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public String getReview_time( ) {
		return review_time;
	}
	
	public void setReview_time( String review_time ) {
		this.review_time = review_time;
	}
	
	public Clazz getPs( ) {
		return Ps;
	}
	
	public void setPs( Clazz ps ) {
		Ps = ps;
	}

	public User getTeacher( ) {
		return teacher;
	}

	public void setTeacher( User teacher ) {
		this.teacher = teacher;
	}
	
}
