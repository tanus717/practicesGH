package com.es.SpringBootApp.model.path;

public class TwoTablePath {

	private String name;
	private String pname;
	
	
	public TwoTablePath(String name, String pname) {
		super();
		this.name = name;
		this.pname = pname;
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
	
	
}
