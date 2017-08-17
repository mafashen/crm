package dao.student;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao_Stu<T> {
	// 增或修改
	void saveOrUpdate(T t);

	// 增
	int save(T t);
	
	// 删
	void delete(T t);

	// 删
	void delete(Serializable id);

	// 改
	void update(T t);

	// 查 根据id查询
	T getById(Serializable id);
	
	//查询符合条件的总记录数
	Integer getTotalCount(DetachedCriteria dc);
	
	//查 查询分页列表数据
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	
	//不通过分页查询所有列表的数据
	List<T> getList(DetachedCriteria dc);
	
}
