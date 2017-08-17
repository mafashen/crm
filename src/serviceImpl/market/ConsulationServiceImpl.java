package serviceImpl.market;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import dao.market.ConsulationDao;

import entity.market.Consulation;
import service.market.ConsulationService;

public class ConsulationServiceImpl implements ConsulationService {
	
	private ConsulationDao cd;
		
	public ConsulationDao getCd() {
		return cd;
	}

	public void setCd(ConsulationDao cd) {
		this.cd = cd;
	}

	public Serializable save(Consulation t) {
		return cd.save(t);
	}

	public void delete(Consulation t) {
		cd.delete(t);
	}

	public void update(Consulation t) {
		cd.update(t);
	}

	public Consulation findOne(Serializable id) {
		return cd.findOne(id);
	}

	public Collection<Consulation> findAll() {
		return cd.findAll();
	}

	public int count() {
		return cd.count();
	}

	public Collection<Consulation> findByPage(int page, int size) {
		return cd.findByPage(page, size);
	}

	public void saveOrUpdate(Consulation t) {
		cd.saveOrUpdate(t);
	}

	public Collection<Consulation> findByPageAndSort( int page , int size , String sort , String order ) {
		return cd.findByPageAndSort(page , size , sort , order);
	}

	public boolean updateIgnoreNull( Consulation t ) {
		return cd.updateIgnoreNull(t);
	}

	public void change(int state,int id) {
		if(state==1){
			cd.changTo0(id);
		}else{cd.changTo1(id);}
	}

	public void changTo1(int id) {
	}

	public void changTo0(int id) {
		
	}

	public String test(String name) {
		return cd.test(name);
	}

	public List<Consulation> findActi() {
		return cd.findActi();
	}

}
