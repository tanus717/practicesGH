package com.es.SpringBootApp.model.path;

public class ServiceIndustry {
	private int id;
	private int industryId;
	private int serviceId;
	private String industryName;
	private String serviceName;

	public ServiceIndustry(int id, int industryId, int serviceId, String industryName, String serviceName) {
		this.id = id;
		this.industryId = industryId;
		this.serviceId = serviceId;
		this.industryName = industryName;
		this.serviceName = serviceName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
