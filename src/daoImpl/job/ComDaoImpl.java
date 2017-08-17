package daoImpl.job;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.job.BaseDao;
import dao.job.ComDao;
import entity.job.Company;

public class ComDaoImpl extends BaseDao implements ComDao {

	
	public void save(Company com) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(com);
	}

	
	public List<Company> listAll(int currentPage) {
		// TODO Auto-generated method stub
		String hql="from Company c ";
		return (List<Company>) getSession().createQuery(hql).setFirstResult((currentPage-1)*5).setMaxResults(5).list();
	}
	
	
	public Company change(int id) {
		// TODO Auto-generated method stub
		return (Company) getSession().get(Company.class, id);
	}

	
	public List<Company> find(String comname) {
		// TODO Auto-generated method stub
		String hql="from Company c where company_name like '%"+comname+"%' ";
		return (List<Company>) getSession().createQuery(hql).list();
	}

	
	public int total() {
		// TODO Auto-generated method stub
		String hql="from Company c ";
		return getSession().createQuery(hql).list().size();
	}

	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Company com=change(id);
		getSession().delete(com);
	}

}
