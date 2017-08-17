package service.market;

import java.util.List;

import util.system.Pagable;

import dao.market.CustomerDao;
import entity.system.User;

public interface CustomerService extends CustomerDao{
	public List<User> findUsersByRoleName(int id);
//	public Pagable countsBystate(long id, String name, int page,int found_id, int size);
}
