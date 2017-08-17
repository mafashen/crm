package serviceImpl.job;

import java.util.List;

import dao.job.ComDao;
import entity.job.Company;
import service.job.ComService;

public class ComServiceImpl implements ComService {
	private ComDao comDao;
	
	public void save(Company com) {
		// TODO Auto-generated method stub
		comDao.save(com);
	}
	public ComDao getComDao() {
		return comDao;
	}
	public void setComDao(ComDao comDao) {
		this.comDao = comDao;
	}
	
	public List<Company> listAll(int currentPage) {
		// TODO Auto-generated method stub
		return comDao.listAll(currentPage);
	}
	
	public Company change(int id) {
		// TODO Auto-generated method stub
		return comDao.change(id);
	}
	
	public List<Company> find(String comname) {
		// TODO Auto-generated method stub
		return comDao.find(comname);
	}
	
	public int total() {
		// TODO Auto-generated method stub
		return comDao.total();
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		comDao.delete(id);
	}
	
	
}
