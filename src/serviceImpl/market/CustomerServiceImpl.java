package serviceImpl.market;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import service.market.CustomerService;
import util.system.Pagable;
import dao.market.CustomerDao;
import dao.system.UserDao;
import entity.market.Customer;
import entity.system.User;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao	csd;
	@Autowired
	private UserDao		ud;
	
	public UserDao getUd( ) {
		return ud;
	}
	
	public void setUd( UserDao ud ) {
		this.ud = ud;
	}
	
	public CustomerDao getCsd( ) {
		return csd;
	}
	
	public void setCsd( CustomerDao csd ) {
		this.csd = csd;
	}
	
	public Serializable save( Customer t ) {
		return csd.save(t);
	}
	
	public void delete( Customer t ) {
		csd.delete(t);
	}
	
	public void update( Customer t ) {
		csd.update(t);
	}
	
	public Customer findOne( Serializable id ) {
		return csd.findOne(id);
	}
	
	public Collection<Customer> findAll( ) {
		return csd.findAll();
	}
	
	public int count( ) {
		return csd.count();
	}
	
	public Collection<Customer> findByPage( int page , int size ) {
		return csd.findByPage(page , size);
	}
	
	public void saveOrUpdate( Customer t ) {
		csd.saveOrUpdate(t);
	}
	
	public Collection<Customer> findByPageAndSort( int page , int size , String sort , String order ) {
		return csd.findByPageAndSort(page , size , sort , order);
	}
	
	public boolean updateIgnoreNull( Customer t ) {
		return csd.updateIgnoreNull(t);
	}
	
	public List<User> findUsersByRoleName( int id ) {
		return ud.findUsersByRoleName(id);
	}
	
	public int countByid( int id ) {
		return csd.countByid(id);
	}
	
	public int countBystate( long id , String name , int page , int found_id , int size ) {
		return csd.countBystate(id , name , page , found_id , size);
	}
	
	public List<Customer> findBystate( long id , String name , int page , int found_id , int size ) {
		return csd.findBystate(id , name , page , found_id , size);
	}
	
	public Collection<Customer> findByPage( int page , int size , int found_id ) {
		return csd.findByPage(page , size , found_id);
	}
	
	public int countBypage( int found_id ) {
		return csd.countBypage(found_id);
	}

	public String test(String name) {
		// TODO Auto-generated method stub
		return csd.test(name);
	}
	
	public Map<String , Integer> countQuarterlyState( int state ) {
		return csd.countQuarterlyState(0);
	}
	
}
