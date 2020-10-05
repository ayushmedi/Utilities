package com.compare.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import com.compare.exception.CounterException;
import com.compare.model.Counter;
import com.compare.model.FieldMapping;

public class RESTCompare {

	private Counter restCounter = new Counter();
	private String jsonField;
	private Object restResponse;

	public boolean findValueInRestResponse(String xmlValue, FieldMapping field) {

		while(true) { //break using exception
			try {
				String restField = restCounter.incrementAndSetCountersInString(getJsonField());
				System.out.println("restField= " + restField);
				String restValue = (String) PropertyUtils.getNestedProperty(getRestResponse(), restField);
				if(xmlValue.equalsIgnoreCase(restValue)) {
					System.out.println("xmlValue = " + xmlValue + " found in REST repsonse");
					field.setJsonValue(restValue);
					return true;
				}
			} catch (CounterException e) {
				//The end of this comparision
				System.out.println("xmlValue = " + xmlValue + " NOT found in REST repsonse");
				return false;
			}
			catch (IllegalAccessException | InvocationTargetException e1) {
				e1.printStackTrace();
				break;
			}
			catch (NoSuchMethodException e3) {
				//Unknown Property in this list - retry after incrementing
			}
			catch (IndexOutOfBoundsException | IllegalArgumentException e3) {
				//We overstepped the boundry
				restCounter.incrementExceptionCount();
			}
		}//end of while
		
		return false;

	}

	public String getJsonField() {
		return jsonField;
	}

	public void setJsonField(String jsonField) {
		this.jsonField = jsonField;
	}

	public Object getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(Object restResponse) {
		this.restResponse = restResponse;
	}

}
