package entity.system;

/** 公告 */
public class Notice {
	private int		nid;
	private String	title;
	private String	content;
	private User	user ;
	private String	push_date;
	
	public Notice( ) {
		user = new User();
	}
	
	public Notice( int nid ) {
		this.nid = nid ;
	}

	public int getNid( ) {
		return nid;
	}
	
	public void setNid( int nid ) {
		this.nid = nid;
	}
	
	public String getTitle( ) {
		return title;
	}
	
	public void setTitle( String title ) {
		this.title = title;
	}
	
	public String getContent( ) {
		return content;
	}
	
	public void setContent( String content ) {
		this.content = content;
	}
	
	public User getUser( ) {
		return user;
	}
	
	public void setUser( User user ) {
		this.user = user;
	}
	
	public String getPush_date( ) {
		return push_date;
	}
	
	public void setPush_date( String push_date ) {
		this.push_date = push_date;
	}
	
}
