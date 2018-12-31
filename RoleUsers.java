package com.es.SpringBootApp.model.path;

public class RoleUsers {

	private String roleId;
	private String userId;
	private String name;

	public RoleUsers(String roleId, String userId, String name) {
		super();
		this.roleId = roleId;
		this.userId = userId;
		this.name = name;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
