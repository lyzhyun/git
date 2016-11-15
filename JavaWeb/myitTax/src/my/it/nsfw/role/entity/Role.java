package my.it.nsfw.role.entity;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable{
	
	private String roleId;
	private String name;
	private String state;
	private Set<RolePrivilege> rolePrivileges;
	
	//角色状态值
	public static String ROLE_STATE_VALID = "1"; //有效
	public static String ROLE_STATE_INVALID = "0"; //无效
	
	
	
	public static String getROLE_STATE_VALID() {
		return ROLE_STATE_VALID;
	}
	public static void setROLE_STATE_VALID(String rOLE_STATE_VALID) {
		ROLE_STATE_VALID = rOLE_STATE_VALID;
	}
	public static String getROLE_STATE_INVALID() {
		return ROLE_STATE_INVALID;
	}
	public static void setROLE_STATE_INVALID(String rOLE_STATE_INVALID) {
		ROLE_STATE_INVALID = rOLE_STATE_INVALID;
	}
	public Role() {
	}
	
	public Role(String roleId) {
		this.roleId = roleId;
	}
	public Role(String roleId, String name, String state,
			Set<RolePrivilege> rolePrivileges) {
		this.roleId = roleId;
		this.name = name;
		this.state = state;
		this.rolePrivileges = rolePrivileges;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<RolePrivilege> getRolePrivileges() {
		return rolePrivileges;
	}
	public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}
	
}
