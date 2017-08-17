package daoImpl.system;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.system.ModuleDao;
import daoImpl.BaseDaoImpl;
import entity.system.Module;

@Service
public class ModuleDaoImpl extends BaseDaoImpl<Module> implements ModuleDao{

	@Autowired
	public ModuleDaoImpl( SessionFactory sessionFactory ) {
		super(sessionFactory);
		cls = Module.class;
		className = "Module";
	}
	
	@Override
	public Collection<Module> findAll( ) {
		Query query = sessionFactory.getCurrentSession().createQuery(" from Module where parent=null");
		return query.list();
	}
}
