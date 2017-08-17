package action.student;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import service.student.ClazzService;
import service.student.StudentService;
import util.student.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.student.Clazz;
import entity.student.Student;

public class ClazzAction extends ActionSupport implements ModelDriven<Clazz>{
	private ClazzService clazzService;
	
	Clazz clazz = new Clazz();
	
	
	
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Clazz.class);
		//判断并封装参数
		if(clazz.getZz_id()!=null){
			dc.add(Restrictions.eq("clazz.getZz_id", clazz.getZz_id()));
		}
		List<Clazz> list = clazzService.getList(dc);
		
		return "list";
	}

	
	public Clazz getModel() {
		return clazz;
	}

	public ClazzService getClazzService() {
		return clazzService;
	}

	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
	}


	

}
