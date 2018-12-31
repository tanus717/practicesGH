package com.es.SpringBootApp.model.path;

public class ToolTechAccount {

	private String accountId;
	private int toolTechId;
	private String accountName;
	private String toolTechName;
	private int id;
	public ToolTechAccount(String accountId, int toolTechId, String accountName, String toolTechName,int id) {
		super();
		this.accountId = accountId;
		this.toolTechId = toolTechId;
		this.accountName = accountName;
		this.toolTechName = toolTechName;
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getToolTechId() {
		return toolTechId;
	}
	public void setToolTechId(int toolTechId) {
		this.toolTechId = toolTechId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getToolTechName() {
		return toolTechName;
	}
	public void setToolTechName(String toolTechName) {
		this.toolTechName = toolTechName;
	}
	
	
}
