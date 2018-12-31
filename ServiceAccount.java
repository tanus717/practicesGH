package com.es.SpringBootApp.model.path;

public class ServiceAccount {

	private String accountId;
	private int serviceId;
	private String accountName;
	private String serviceName;
	private int id;

	public ServiceAccount(String accountId, int serviceId, String accountName, String serviceName, int id) {
		super();
		this.accountId = accountId;
		this.serviceId = serviceId;
		this.accountName = accountName;
		this.serviceName = serviceName;
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

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
