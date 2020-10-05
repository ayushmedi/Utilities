package com.compare.model;

import java.util.ArrayList;
import java.util.List;

public class RESTClass2 {

	private String simpleVar1 = "hello";
	
	private List<RESTClass3> object3 = new ArrayList<RESTClass3>();

	public String getSimpleVar1() {
		return simpleVar1;
	}

	public void setSimpleVar1(String simpleVar1) {
		this.simpleVar1 = simpleVar1;
	}

	public List<RESTClass3> getObject3() {
		return object3;
	}

	public void setObject3(List<RESTClass3> object3) {
		this.object3 = object3;
	}
	
	
}
