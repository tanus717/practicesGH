package com.es.SpringBootApp.model.path;

public class FourTablePath {

	private String name;
	private String pname;
	private String spname;
	private String tpname;
	
	
	public FourTablePath(String name, String pname, String spname, String tpname) {
		super();
		this.name = name;
		this.pname = pname;
		this.spname = spname;
		this.tpname = tpname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getTpname() {
		return tpname;
	}
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}
	
	
}
