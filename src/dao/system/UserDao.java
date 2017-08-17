package dao.system;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.BaseDao;
import entity.system.User;

@Service
public interface UserDao extends BaseDao<User>{
	
	/**
	 * 用户登陆验证
	 * @param username	用户名
	 * @param password	密码
	 * @return			登陆结果
	 */
	User login(String username , String password);
	
	/**
	 * 通过用户对应的角色 查找所有对应的用户列表
	 * @param name
	 * @return
	 */
	List<User> findUsersByRoleName(String name);
	
	/**
	 * 通过用户角色id查找所有用户
	 * @param cid
	 * @return
	 */
	List<User> findUsersByRoleName(int cid);
}
