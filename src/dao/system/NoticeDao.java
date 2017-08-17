package dao.system;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.BaseDao;
import entity.system.Notice;


@Service
public interface NoticeDao extends BaseDao<Notice>{
	
	/**
	 * 获取条件查询时的总数
	 * @param username
	 * @param from
	 * @param to
	 * @return
	 */
	public int count(String username , String from , String to );
	
	/**
	 * 通过条件分页查找
	 * @param page	页码
	 * @param rows	每页条数
	 * @param username	查找对应的用户名发布的通告
	 * @param from	查询起始日期
	 * @param to	查询截止日期
	 * @return
	 */
	List<Notice> findByPageAndCondition(int page, int rows, String username , String from , String to);
}
