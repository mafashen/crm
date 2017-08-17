package dao.market;

import java.util.List;

import dao.BaseDao;
import entity.market.State;

public interface StateDao extends BaseDao<State> {
	public List<State> findAll();
}
