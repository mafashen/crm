package daoImpl.system;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.system.RoleDao;
import daoImpl.BaseDaoImpl;
import entity.system.Role;

@Service
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	@Autowired
	public RoleDaoImpl( SessionFactory sessionFactory ) {
		super(sessionFactory);
		className = "Role";
		cls = Role.class;
	}
	
}
