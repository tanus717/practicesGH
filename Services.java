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
@Table(name = "services")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deleted;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Temporal(TemporalType.DATE)
	private Date createddate;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Temporal(TemporalType.DATE)
	private Date modifieddate;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String modifiedusername;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String createdusername;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
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

	public String getModifiedusername() {
		return modifiedusername;
	}

	public void setModifiedusername(String modifiedusername) {
		this.modifiedusername = modifiedusername;
	}

	public String getCreatedusername() {
		return createdusername;
	}

	public void setCreatedusername(String createdusername) {
		this.createdusername = createdusername;
	}

}
