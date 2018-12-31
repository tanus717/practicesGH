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
@Table(name = "merge_company")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MergeCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String parentcompany_id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String parent_company_name;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String merge_company_id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String merge_company_name;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deleted;
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

	public String getParentcompany_id() {
		return parentcompany_id;
	}

	public void setParentcompany_id(String parentcompany_id) {
		this.parentcompany_id = parentcompany_id;
	}

	public String getParent_company_name() {
		return parent_company_name;
	}

	public void setParent_company_name(String parent_company_name) {
		this.parent_company_name = parent_company_name;
	}

	public String getMerge_company_id() {
		return merge_company_id;
	}

	public void setMerge_company_id(String merge_company_id) {
		this.merge_company_id = merge_company_id;
	}

	public String getMerge_company_name() {
		return merge_company_name;
	}

	public void setMerge_company_name(String merge_company_name) {
		this.merge_company_name = merge_company_name;
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
