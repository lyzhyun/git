package my.it.nsfw.role.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import my.it.core.service.impl.BaseServiceImpl;
import my.it.nsfw.role.dao.RoleDao;
import my.it.nsfw.role.entity.Role;
import my.it.nsfw.role.service.RoleService;

import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	private RoleDao roleDaoImpl;
	@Resource
	public void setroleDaoImpl(RoleDao roleDaoImpl) {
		super.setBaseDao(roleDaoImpl);
		this.roleDaoImpl = roleDaoImpl;
	}

	@Override
	public void update(Role role) {
		//1、删除该角色对于的所有权限
		roleDaoImpl.deleteRolePrivilegeByRoleId(role.getRoleId());
		//2、更新角色及其权限
		roleDaoImpl.update(role);
	}

}
