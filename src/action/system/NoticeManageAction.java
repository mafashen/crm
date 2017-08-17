package action.system;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import util.system.Pagable;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import dao.system.NoticeDao;

import entity.system.Notice;
import entity.system.User;

@Controller
@Scope("prototype")
public class NoticeManageAction {
	
	@Autowired
	NoticeDao noticeDao;
	
	List<Notice> notices ;
	Notice notice;
	int nid;
	String username;	//条件查找 -- 按用户名
	String from ;		//条件查找 -- 起始日期
	String to;			//条件查找 -- 截止日期
	
	Pagable pagable = new Pagable();
	
	public Pagable getPagable( ) {
//		pagable.setTotal(noticeDao.count());
		return pagable;
	}

	public void setPagable( Pagable pagable ) {
		this.pagable = pagable;
	}

	public Notice getNotice( ) {
		return notice;
	}

	public void setNotice( Notice notice ) {
		this.notice = notice;
	}

	public int getNid( ) {
		return nid;
	}

	public void setNid( int nid ) {
		this.nid = nid;
	}

	public String getUsername( ) {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getFrom( ) {
		return from;
	}

	public void setFrom( String from ) {
		this.from = from;
	}

	public String getTo( ) {
		return to;
	}

	public void setTo( String to ) {
		this.to = to;
	}

	InputStream inputStream;

	public InputStream getInputStream( ) {
		return inputStream;
	}

	public void setInputStream( InputStream inputStream ) {
		this.inputStream = inputStream;
	}

	public List<Notice> getNotices( ) {
		return notices;
	}

	public void setNotices( List<Notice> notices ) {
		this.notices = notices;
	}
	
	public String find(){
		//System.out.println(ActionContext.getContext().getParameters().keySet());
		System.out.println("action.system.NoticeManagerAction.find()"+pagable.getPage());
		notices = (List<Notice>)noticeDao.findByPageAndSort(
				pagable.getPage() , pagable.getRows() , pagable.getSort() , pagable.getOrder());
		StringBuilder builder = new StringBuilder();
		try {
			String noticesString = JSONUtil.serialize(notices);
			builder.append("{\"total\":"+pagable.getTotal()+",\"rows\":");
			builder.append(noticesString);
			builder.append("}");
			inputStream = new ByteArrayInputStream(builder.toString().getBytes("utf-8"));
			System.out.println(builder.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "find";
	}

	public String execute(){
		pagable.setTotal(noticeDao.count(getUsername() , getFrom() , getTo()));
		System.out.println(getUsername() + "  " + getFrom() + "  " + getTo());
		notices = (List<Notice>)noticeDao.findByPageAndCondition(
				pagable.getPage() , pagable.getRows() ,getUsername(), getFrom() ,getTo());
		return "list";
	}
	
	public String delete( ) {
		noticeDao.delete(new Notice(getNid()));
		return "success";
	}
	
	public String findOne( ) {
		notice = noticeDao.findOne(getNid());
		return "one";
	}
	
	public String update( ) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		getNotice().setPush_date(format.format(new Date()));
		noticeDao.updateIgnoreNull(getNotice());
		return "success";
	}
	
	public String add( ) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		getNotice().setPush_date(format.format(new Date()));
//		getNotice().setUser(user)
		noticeDao.save(getNotice());
		return "success";
	}
}
