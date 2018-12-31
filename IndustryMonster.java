package com.es.SpringBootApp.model.path;

public class IndustryMonster {
	private int id;
	private int industryId;
	private int monsterId;
	private String industryName;
	private String monsterName;

	public IndustryMonster(int id, int industryId, int monsterId, String industryName, String monsterName) {
		super();
		this.id = id;
		this.industryId = industryId;
		this.monsterId = monsterId;
		this.industryName = industryName;
		this.monsterName = monsterName;
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

	public int getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

}
