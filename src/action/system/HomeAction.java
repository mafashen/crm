package action.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.job.ItvService;
import service.market.CustomerService;
import dao.system.NoticeDao;
import entity.system.Notice;

/**
 * 通过首页的处理action
 * 
 * @author mafashen 获取公告,获取待办事项,获取
 */
@Controller
@Scope("prototype")
public class HomeAction {
	
	@Autowired
	NoticeDao		noticeDao;
	@Autowired
	CustomerService customerService;
	@Autowired
	ItvService itvService;
	
	
	int toFollow;			//待跟进总数
	int toVisit;			//待上门总数
	int yetVisit;			//已上门总数
	int signup;				//已报名总数
	
	List<Notice>	notices;
	Map<String, Integer> map;
	Map<String , Integer> work;
	
	public List<Notice> getNotices( ) {
		return notices;
	}
	
	public void setNotices( List<Notice> notices ) {
		this.notices = notices;
	}
	
	public int getToFollow( ) {
		return toFollow;
	}

	public void setToFollow( int toFollow ) {
		this.toFollow = toFollow;
	}

	public int getToVisit( ) {
		return toVisit;
	}

	public void setToVisit( int toVisit ) {
		this.toVisit = toVisit;
	}

	public int getYetVisit( ) {
		return yetVisit;
	}

	public void setYetVisit( int yetVisit ) {
		this.yetVisit = yetVisit;
	}

	public int getSignup( ) {
		return signup;
	}

	public void setSignup( int signup ) {
		this.signup = signup;
	}

	public Map<String , Integer> getMap( ) {
		return map;
	}

	public void setMap( Map<String , Integer> map ) {
		this.map = map;
	}

	public Map<String , Integer> getWork( ) {
		return work;
	}

	public void setWork( Map<String , Integer> work ) {
		this.work = work;
	}

	public String execute( ) {
		notices = (List<Notice>) noticeDao.findByPage(1 , 5);
		//System.out.println(notices);
		
		toFollow = customerService.countByid(1);
		toVisit  = customerService.countByid(2);
		yetVisit = customerService.countByid(3);
		signup   = customerService.countByid(4);
		
		//统计近六个月的报名量
		map = customerService.countQuarterlyState(0);
		//统计近六个月的就业量
		work = itvService.countQuarterWork();
		return "success";
	}
}
