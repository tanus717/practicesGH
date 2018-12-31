package com.es.SpringBootApp.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "accounttooltech")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Accounttooltech  {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@GeneratedValue(strategy = IDENTITY)
	private String accountid;
	@GeneratedValue(strategy = IDENTITY)
	private int tooltechid;
	@GeneratedValue(strategy = IDENTITY)
	private String tooltechname;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = IDENTITY)
	private Date createddate;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = IDENTITY)
	private Date lastmodifieddate;
	@GeneratedValue(strategy = IDENTITY)
	private String createdby;
	@GeneratedValue(strategy = IDENTITY)
	private String modifiedby;
	@GeneratedValue(strategy = IDENTITY)
	private String createdusername;
	@GeneratedValue(strategy = IDENTITY)
	private String modifiedusername;
	@GeneratedValue(strategy = IDENTITY)
	private Byte deleted;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = IDENTITY)
	private Date modifieddate;

	public Accounttooltech() {
	}

	public Accounttooltech(String accountid, Integer tooltechid, String tooltechname, Date createddate,
			Date lastmodifieddate, String createdby, String modifiedby, String createdusername, String modifiedusername,
			Byte deleted, Date modifieddate) {
		this.accountid = accountid;
		this.tooltechid = tooltechid;
		this.tooltechname = tooltechname;
		this.createddate = createddate;
		this.lastmodifieddate = lastmodifieddate;
		this.createdby = createdby;
		this.modifiedby = modifiedby;
		this.createdusername = createdusername;
		this.modifiedusername = modifiedusername;
		this.deleted = deleted;
		this.modifieddate = modifieddate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "accountid", length = 36)
	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	@Column(name = "tooltechid")
	public Integer getTooltechid() {
		return this.tooltechid;
	}

	public void setTooltechid(Integer tooltechid) {
		this.tooltechid = tooltechid;
	}

	@Column(name = "tooltechname")
	public String getTooltechname() {
		return this.tooltechname;
	}

	public void setTooltechname(String tooltechname) {
		this.tooltechname = tooltechname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate", length = 23)
	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodifieddate", length = 23)
	public Date getLastmodifieddate() {
		return this.lastmodifieddate;
	}

	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}

	@Column(name = "createdby", length = 36)
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name = "modifiedby", length = 36)
	public String getModifiedby() {
		return this.modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	@Column(name = "createdusername", length = 100)
	public String getCreatedusername() {
		return this.createdusername;
	}

	public void setCreatedusername(String createdusername) {
		this.createdusername = createdusername;
	}

	@Column(name = "modifiedusername", length = 100)
	public String getModifiedusername() {
		return this.modifiedusername;
	}

	public void setModifiedusername(String modifiedusername) {
		this.modifiedusername = modifiedusername;
	}

	@Column(name = "deleted")
	public Byte getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifieddate", length = 23)
	public Date getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

}
