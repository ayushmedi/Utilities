package com.compare.model;

import java.util.ArrayList;
import java.util.List;

public class RESTClass1 {
	
	private String simpleVar = "hello";
	
	private String aaa="aaa";
	
	private List<RESTClass2> object2 = new ArrayList<>();

	public String getSimpleVar() {
		return simpleVar;
	}

	public void setSimpleVar(String simpleVar) {
		this.simpleVar = simpleVar;
	}

	public List<RESTClass2> getObject2() {
		return object2;
	}

	public void setObject2(List<RESTClass2> object2) {
		this.object2 = object2;
	}

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

}
