package dao;

import java.io.Serializable;
import java.util.Collection;

/**
 * 通用dao操作
 * @author mafashen
 *
 * @param <T>	所关联的实体类
 */
public interface BaseDao<T> {
	
	/**
	 * 持久化对象到数据库
	 * @param t	要持久化的对象
	 * @return	保存结果
	 */
	void saveOrUpdate(T t);
	Serializable save(T t);
	
	/**
	 * 从数据库中删除指定主键id的记录
	 * @param id	要删除的记录的主键
	 * @return		删除结果
	 */
	//boolean delete(Serializable id);
	
	/**
	 * 从数据库中删除对象所对应的记录
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * 更新数据库与对象相关联的记录
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 只更新对象中的非空字段
	 * @param t
	 * @return	更新结果
	 */
	boolean updateIgnoreNull(T t);
	
	/**
	 * 根据指定主键id , 从数据库中取得对应的记录封装为对象
	 * @param id		主键id
	 * @return
	 */
	T findOne(Serializable id);
	
	/**
	 * 从数据库中某表中获取所有的数据
	 * @return
	 */
	Collection<T> findAll();
	
	/**
	 * 获取实体类所关联表的总记录数
	 * @return
	 */
	int count();
	
	/**
	 * 通过分页方式获取指定的数据
	 * @param page	开始页
	 * @param size	获取条数
	 * @return
	 */
	Collection<T> findByPage(int page , int size);
	
	/**
	 * 分页并排序
	 * @param page
	 * @param size
	 * @param sort
	 * @param order
	 * @return
	 */
	Collection<T> findByPageAndSort(int page , int size , String sort , String order);
}
