package com.es.SpringBootApp.model.path;

public class IndustryNaukri {
	private int id;
	private int industryId;
	private int naukriId;
	private String industryName;
	private String naukriName;

	public IndustryNaukri(int id, int industryId, int naukriId, String industryName, String naukriName) {
		super();
		this.id = id;
		this.industryId = industryId;
		this.naukriId = naukriId;
		this.industryName = industryName;
		this.naukriName = naukriName;
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

	public int getNaukriId() {
		return naukriId;
	}

	public void setNaukriId(int naukriId) {
		this.naukriId = naukriId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getNaukriName() {
		return naukriName;
	}

	public void setNaukriName(String naukriName) {
		this.naukriName = naukriName;
	}

}
