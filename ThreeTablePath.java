package com.es.SpringBootApp.model.path;

public class ThreeTablePath {

	private String name;
	private String pname;
	private String spname;
	
	
	
	public ThreeTablePath(String name, String pname, String spname) {
		super();
		this.name = name;
		this.pname = pname;
		this.spname = spname;
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
	
	
}
