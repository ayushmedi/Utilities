package com.compare.model;

import java.util.ArrayList;
import java.util.List;

public class XMLClass1 {
	
	private String simpleVar = "hello";
	
	private String bbb="aaa";
	
	private List<XMLClass2> obj2 = new ArrayList<>();


	public String getSimpleVar() {
		return simpleVar;
	}

	public void setSimpleVar(String simpleVar) {
		this.simpleVar = simpleVar;
	}

	public List<XMLClass2> getObj2() {
		return obj2;
	}

	public void setObj2(List<XMLClass2> obj2) {
		this.obj2 = obj2;
	}

	public String getBbb() {
		return bbb;
	}

	public void setBbb(String bbb) {
		this.bbb = bbb;
	}
}
