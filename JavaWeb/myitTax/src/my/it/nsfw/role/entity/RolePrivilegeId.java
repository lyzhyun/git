package my.it.nsfw.role.entity;

import java.io.Serializable;

public class RolePrivilegeId implements Serializable{
	//联合主键类一定要实现Serializable接口
	//重写hashCode  equals方法
	//权限
	private String code;
	//角色id   这里不写string类型是因为   当需要查询角色名称的时候需要再到数据库中查询   
	private Role role;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePrivilegeId other = (RolePrivilegeId) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	public RolePrivilegeId(Role role,String code ) {
		this.code = code;
		this.role = role;
	}
	public RolePrivilegeId() {
	}
	
	
}
