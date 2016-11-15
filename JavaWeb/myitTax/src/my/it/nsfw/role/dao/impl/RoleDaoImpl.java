package my.it.nsfw.role.dao.impl;

import org.hibernate.Query;

import my.it.core.dao.impl.BaseDaoImpl;
import my.it.nsfw.role.dao.RoleDao;
import my.it.nsfw.role.entity.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
								// ***********删除的是角色权限的这张表
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE id.role.roleId = ?");
		query.setParameter(0, roleId);
		query.executeUpdate();
		
	}

	
}
