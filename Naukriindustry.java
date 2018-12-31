package com.es.SpringBootApp.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "naukriindustry")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Naukriindustry  {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@GeneratedValue(strategy = IDENTITY)
	private String naukri;
	@GeneratedValue(strategy = IDENTITY)
	private int deleted;
	@GeneratedValue(strategy = IDENTITY)
	private String modifiedby;
	@GeneratedValue(strategy = IDENTITY)
	private String createdby;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = IDENTITY)
	private Date createddate;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = IDENTITY)
	private Date modifieddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaukri() {
		return naukri;
	}

	public void setNaukri(String naukri) {
		this.naukri = naukri;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
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
