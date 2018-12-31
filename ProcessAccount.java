package com.es.SpringBootApp.model.path;

public class ProcessAccount {

	private String accountId;
	private int processId;
	private String accountName;
	private String processName;
	private int id;

	public ProcessAccount(String accountId, int processId, String accountName, String processName, int id) {
		super();
		this.accountId = accountId;
		this.processId = processId;
		this.accountName = accountName;
		this.processName = processName;
		this.id = id;
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

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}
