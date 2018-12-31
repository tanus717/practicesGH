package com.es.SpringBootApp.model;

import java.math.BigDecimal;
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
@Table(name = "accountorgstructure")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountOrgStructure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String accountid;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int level;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String jobgrade;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal ctcfrom;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal ctcto;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ctccurrency;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ctcrange;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal ctcfrominr;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal ctctoinr;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal expfrom;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal expto;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String exprange;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String remarks;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String industrydesignationlevel;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deleted;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String createdby;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String modifiedby;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String createdusername;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String modifiedusername;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String designation;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Temporal(TemporalType.DATE)
	private Date createddate;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Temporal(TemporalType.DATE)
	private Date lastmodifieddate;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Temporal(TemporalType.DATE)
	private Date modifieddate;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int industryorgid;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int industryid;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String indusrtytext;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getJobgrade() {
		return jobgrade;
	}

	public void setJobgrade(String jobgrade) {
		this.jobgrade = jobgrade;
	}

	public BigDecimal getCtcfrom() {
		return ctcfrom;
	}

	public void setCtcfrom(BigDecimal ctcfrom) {
		this.ctcfrom = ctcfrom;
	}

	public BigDecimal getCtcto() {
		return ctcto;
	}

	public void setCtcto(BigDecimal ctcto) {
		this.ctcto = ctcto;
	}

	public String getCtccurrency() {
		return ctccurrency;
	}

	public void setCtccurrency(String ctccurrency) {
		this.ctccurrency = ctccurrency;
	}

	public String getCtcrange() {
		return ctcrange;
	}

	public void setCtcrange(String ctcrange) {
		this.ctcrange = ctcrange;
	}

	public BigDecimal getCtcfrominr() {
		return ctcfrominr;
	}

	public void setCtcfrominr(BigDecimal ctcfrominr) {
		this.ctcfrominr = ctcfrominr;
	}

	public BigDecimal getCtctoinr() {
		return ctctoinr;
	}

	public void setCtctoinr(BigDecimal ctctoinr) {
		this.ctctoinr = ctctoinr;
	}

	public BigDecimal getExpfrom() {
		return expfrom;
	}

	public void setExpfrom(BigDecimal expfrom) {
		this.expfrom = expfrom;
	}

	public BigDecimal getExpto() {
		return expto;
	}

	public void setExpto(BigDecimal expto) {
		this.expto = expto;
	}

	public String getExprange() {
		return exprange;
	}

	public void setExprange(String exprange) {
		this.exprange = exprange;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getIndustrydesignationlevel() {
		return industrydesignationlevel;
	}

	public void setIndustrydesignationlevel(String industrydesignationlevel) {
		this.industrydesignationlevel = industrydesignationlevel;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public int getIndustryorgid() {
		return industryorgid;
	}

	public void setIndustryorgid(int industryorgid) {
		this.industryorgid = industryorgid;
	}

	public int getIndustryid() {
		return industryid;
	}

	public void setIndustryid(int industryid) {
		this.industryid = industryid;
	}

	public String getIndusrtytext() {
		return indusrtytext;
	}

	public void setIndusrtytext(String indusrtytext) {
		this.indusrtytext = indusrtytext;
	}

}
