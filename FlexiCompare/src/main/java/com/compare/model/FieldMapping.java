package com.compare.model;

public class FieldMapping {
	
	private String xmlField;
	private String jsonField;
	private String type; //List a.b.c[x]  a.d.b[x].c[x]
	//followed by a.b.c[x].tradeID  a.d.b[x].c[x].tradingID
	//a.b.c[x].amount  a.d.b[x].c[x].dollars
	
	private int sequnceNo;
	
	private String jsonValue;
	private String xmlValue;
	private boolean isMatching;
	
	public String getXmlField() {
		return xmlField;
	}
	public void setXmlField(String xmlField) {
		this.xmlField = xmlField;
	}
	public String getJsonField() {
		return jsonField;
	}
	public void setJsonField(String jsonField) {
		this.jsonField = jsonField;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSequnceNo() {
		return sequnceNo;
	}
	public void setSequnceNo(int sequnceNo) {
		this.sequnceNo = sequnceNo;
	}
	public boolean isMatching() {
		return isMatching;
	}
	public void setMatching(boolean isMatching) {
		this.isMatching = isMatching;
	}
	public String getXmlValue() {
		return xmlValue;
	}
	public void setXmlValue(String xmlValue) {
		this.xmlValue = xmlValue;
	}
	public String getJsonValue() {
		return jsonValue;
	}
	public void setJsonValue(String jsonValue) {
		this.jsonValue = jsonValue;
	} 

}
