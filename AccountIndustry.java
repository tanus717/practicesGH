package com.es.SpringBootApp.model.path;

public class AccountIndustry {

	
	private String accountId;
	private int industryId;
	private String accountName;
	private String industryName;
	public AccountIndustry(String accountId, int industryId, String accountName, String industryName) {
		super();
		this.accountId = accountId;
		this.industryId = industryId;
		this.accountName = accountName;
		this.industryName = industryName;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	
	
}
