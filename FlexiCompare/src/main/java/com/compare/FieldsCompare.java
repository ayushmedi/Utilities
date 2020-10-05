package com.compare;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import com.compare.exception.CounterException;
import com.compare.model.Counter;
import com.compare.model.FieldMapping;
import com.compare.model.RESTClass1;
import com.compare.model.RESTClass2;
import com.compare.model.RESTClass3;
import com.compare.model.XMLClass1;
import com.compare.model.XMLClass2;
import com.compare.service.RESTCompare;

public class FieldsCompare {

	public List<FieldMapping> dummyTestData() {
		List<FieldMapping> fields = new ArrayList<FieldMapping>();
		FieldMapping field = new FieldMapping();

		//field.setJsonField("object2[0].simpleVar1");
		//field.setXmlField("simpleVar");
	
    	field.setJsonField("object2[x].simpleVar1");
		field.setXmlField("simpleVar");
		field.setType("List");
		fields.add(field);
		
		field = new FieldMapping();
		
		field.setJsonField("object2[x].object3[y].str");
		field.setXmlField("obj2[x].find");
		field.setType("List");
		fields.add(field);

		field = new FieldMapping();
		
		field.setJsonField("aaa");
		field.setXmlField("bbb");
		fields.add(field);

		return fields;
	}

	private void compareObjects(Object xmlResponse, Object restResponse, List<FieldMapping> fields) {
		
		for(FieldMapping field: fields) {
			Counter xmlCounter = new Counter();
			while(true) { //iterate xmlResponse and break using exception
				String xmlValue = null;
				try {
					RESTCompare restCompare = new RESTCompare();
					restCompare.setRestResponse(restResponse);
					restCompare.setJsonField(field.getJsonField());
					String xmlField = xmlCounter.incrementAndSetCountersInString(field.getXmlField());
					xmlValue = (String) PropertyUtils.getNestedProperty(xmlResponse, xmlField); //Attempt to fetch XML value
					field.setMatching(false);
					field.setXmlValue(xmlValue);
					boolean result = restCompare.findValueInRestResponse(xmlValue, field); //search xmlValue in the configured REST repsonse
					if(result==true) {
						field.setMatching(true);
						field.setXmlValue(xmlValue);
						System.out.println("seeting");
						break;
					}
					//if not found then let the CounterException break the loop
				} catch (CounterException e) {
					//The end of this comparision
				 	break;
				}
				catch (IllegalAccessException | InvocationTargetException e1) {
					break;  //not expecting
				}
				catch (NoSuchMethodException e3) {
					//Unknown Property in this list - retry after incrementing
					//Not expecting for XML response
				}
				catch (IndexOutOfBoundsException | IllegalArgumentException e3) {
					//We overstepped the boundary - Not expecting for XML response
					xmlCounter.incrementExceptionCount();
				}
			}//end of while 
			
		}
		
	}
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		RESTClass1 restResponse = new RESTClass1();
		RESTClass3 restClass3a = new RESTClass3();
		restClass3a.setStr("1");
		RESTClass3 restClass3b = new RESTClass3();
		restClass3b.setStr("2");
		RESTClass2 restClass2 = new RESTClass2();
		RESTClass2 restClass2a = new RESTClass2();
		
		restClass2.getObject3().add(restClass3a);
		restClass2.getObject3().add(restClass3b);
		restResponse.getObject2().add(restClass2a);
		restResponse.getObject2().add(restClass2);
		XMLClass2 c2= new XMLClass2();
		c2.setFind("3");
		XMLClass2 c3= new XMLClass2();
		c3.setFind("2");
		XMLClass2 c4= new XMLClass2();
		c4.setFind("1");
		XMLClass1 xmlResponse = new XMLClass1();
		xmlResponse.getObj2().add(c2);
		xmlResponse.getObj2().add(c3);
		xmlResponse.getObj2().add(c4);
		
		FieldsCompare f = new FieldsCompare();
		List<FieldMapping> fields = f.dummyTestData();
		f.compareObjects(xmlResponse, restResponse, fields);
		for(FieldMapping field: fields) {
			System.out.println(field.getXmlField()+","+field.getJsonField()+","+field.getXmlValue()+","+field.getJsonValue()+","+field.isMatching());
			//this can be written to a csv file
		}

	}
}

