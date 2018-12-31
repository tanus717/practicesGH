package com.es.SpringBootApp.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "rel_linkedin_indus")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelLinkedinIndus  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int indus_id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int linked_id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deleted;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String modifiedby;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String createdby;
	@Temporal(TemporalType.DATE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public int getIndus_id() {
		return indus_id;
	}
	public void setIndus_id(int indus_id) {
		this.indus_id = indus_id;
	}
	public int getLinked_id() {
		return linked_id;
	}
	public void setLinked_id(int linked_id) {
		this.linked_id = linked_id;
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
