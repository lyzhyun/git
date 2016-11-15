package my.it.nsfw.role.dao;


import my.it.core.dao.BaseDao;
import my.it.nsfw.role.entity.Role;


public interface RoleDao extends BaseDao<Role> {

	public void deleteRolePrivilegeByRoleId(String roleId);

}
