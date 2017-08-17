package service.job;

import java.util.List;

import entity.job.Company;

public interface ComService {
	public void save(Company com);
	public List<Company> listAll(int currentPage);
	public int total();
	public Company change(int id);
	public List<Company> find(String comname);
	public void delete(int id);
}
