package service.market;

import dao.BaseDao;
import dao.market.ConsulationDao;
import entity.market.Consulation;

public interface ConsulationService extends ConsulationDao {
	public void change(int state,int id);
	
}
