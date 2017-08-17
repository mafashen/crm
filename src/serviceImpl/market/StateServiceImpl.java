package serviceImpl.market;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import service.market.StateService;
import dao.market.StateDao;
import entity.market.State;

public class StateServiceImpl implements StateService {
	private StateDao statedao;

	public StateDao getStatedao() {
		return statedao;
	}

	public void setStatedao(StateDao statedao) {
		this.statedao = statedao;
	}

	public List<State> findAll() {
		// TODO Auto-generated method stub
		return (List<State>) statedao.findAll();
	}

	public Serializable save(State t) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(State t) {
		// TODO Auto-generated method stub
		
	}

	public void update(State t) {
		// TODO Auto-generated method stub
		
	}

	public State findOne(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<State> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(State t) {
		// TODO Auto-generated method stub
		
	}

	public Collection<State> findByPageAndSort(int page, int size, String sort,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateIgnoreNull( State t ) {
		// TODO Auto-generated method stub
		return false;
	}

}
