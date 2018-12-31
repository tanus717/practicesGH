package com.es.SpringBootApp.model.path;

public class RoleAccess {

	private String roleId;
	private String roleName;
	private int create;
	private int delete;
	private int view;
	private int access;
	private int edit;
	private int approve;
	private int reject;
	private String category;
	private String accessActionId;

	public RoleAccess(String roleId, String roleName, int create, int delete, int view, int access, int edit,
			int approve, int reject, String category, String accessActionId) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.create = create;
		this.delete = delete;
		this.view = view;
		this.access = access;
		this.edit = edit;
		this.approve = approve;
		this.reject = reject;
		this.category = category;
		this.accessActionId = accessActionId;
	}

	public String getAccessActionId() {
		return accessActionId;
	}

	public void setAccessActionId(String accessActionId) {
		this.accessActionId = accessActionId;
	}

	public String getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCreate() {
		return create;
	}

	public int getDelete() {
		return delete;
	}

	public int getView() {
		return view;
	}

	public int getAccess() {
		return access;
	}

	public int getEdit() {
		return edit;
	}

	public int getApprove() {
		return approve;
	}

	public int getReject() {
		return reject;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setCreate(int create) {
		this.create = create;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public void setView(int view) {
		this.view = view;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public void setEdit(int edit) {
		this.edit = edit;
	}

	public void setApprove(int approve) {
		this.approve = approve;
	}

	public void setReject(int reject) {
		this.reject = reject;
	}

}
