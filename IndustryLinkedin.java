package com.es.SpringBootApp.model.path;

public class IndustryLinkedin {
	private int id;
	private int industryId;
	private int linkedinId;
	private String industryName;
	private String linkedinName;

	public IndustryLinkedin(int id,int industryId, int linkedinId, String industryName, String linkedinName) {
		super();
		this.industryId = industryId;
		this.linkedinId = linkedinId;
		this.industryName = industryName;
		this.linkedinName = linkedinName;
		this.id = id;
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

	public int getLinkedinId() {
		return linkedinId;
	}

	public void setLinkedinId(int linkedinId) {
		this.linkedinId = linkedinId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getLinkedinName() {
		return linkedinName;
	}

	public void setLinkedinName(String linkedinName) {
		this.linkedinName = linkedinName;
	}

}
