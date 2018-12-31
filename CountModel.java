package com.es.SpringBootApp.model;

public class CountModel {
private String name;
private long total;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


public long getTotal() {
	return total;
}
public void setTotal(long total) {
	this.total = total;
}




public CountModel(String name, long total) {
	super();

	this.name = name;
	this.total = total;
}
public CountModel() {
}
}
