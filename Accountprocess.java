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
@Table(name = "accountprocess")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Accountprocess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String accountid;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int processid;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String processname;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Date createddate;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Date lastmodifieddate;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String createdby;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String modifiedby;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String createdusername;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String modifiedusername;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deleted;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Date modifieddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public int getProcessid() {
		return processid;
	}

	public void setProcessid(int processid) {
		this.processid = processid;
	}

	public String getProcessname() {
		return processname;
	}

	public void setProcessname(String processname) {
		this.processname = processname;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getLastmodifieddate() {
		return lastmodifieddate;
	}

	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getCreatedusername() {
		return createdusername;
	}

	public void setCreatedusername(String createdusername) {
		this.createdusername = createdusername;
	}

	public String getModifiedusername() {
		return modifiedusername;
	}

	public void setModifiedusername(String modifiedusername) {
		this.modifiedusername = modifiedusername;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

}
