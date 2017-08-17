package service.market;

import java.util.List;

import dao.BaseDao;

import entity.market.State;

public interface StateService extends BaseDao<State> {
	public List<State> findAll();
}
