package com.es.SpringBootApp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "current_company")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String present_employer;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String company_id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deleted;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notification;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String modifiedby;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String createdby;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Temporal(TemporalType.DATE)
	private Date createddate;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Date modifieddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPresentEmployer() {
		return present_employer;
	}

	public void setPresentEmployer(String present_employer) {
		this.present_employer = present_employer;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getNotification() {
		return notification;
	}

	public void setNotification(int notification) {
		this.notification = notification;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
}
