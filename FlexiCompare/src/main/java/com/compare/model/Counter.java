package com.compare.model;

import com.compare.exception.CounterException;

public class Counter {

	private int x=-1, y=-1, z=-1;

	private boolean isFirstTimeInvoked=true;

	private int externalExceptionCount=0, shift=0;

	public String incrementAndSetCountersInString(String fieldString) throws CounterException {

		if(fieldString.contains("[z]")) {  //contains [x][y][z]
			return incrementAndReplaceXYZ(fieldString);
		}
		else if(fieldString.contains("[y]")) {  //contains [x][y]
			return incrementAndReplaceXY(fieldString);
		}
		else if(fieldString.contains("[x]")) {  //contains [x]
			return incrementAndReplaceX(fieldString);
		}
		else {
			if(isFirstTimeInvoked) {
				isFirstTimeInvoked=false;
				return fieldString;
			}
			else {
				throw new CounterException("Not a List");
			}
		}


	}

	private String incrementAndReplaceX(String fieldString) throws CounterException {

		if(externalExceptionCount==0) {
			x++;
		}
		else {
			throw new CounterException("No more counter for you");
		}

		fieldString = fieldString.replaceFirst("\\[x\\]", "[" + x + "]");

		return fieldString;
	}

	private String incrementAndReplaceXY(String fieldString) throws CounterException {

		if(externalExceptionCount==0) {
			y++;
			if(x==-1) x=0;
		}
		else if(externalExceptionCount==1) {
			if(y==0) {  //y was not incremented i.e exception occured at some value of x and y=0
				shift++;  // y series exhausted once and now shifted to incerementing x
			}
			y=0;   //reset y to 0 while incrementing x  
			x++;
			if(shift==1) {  //if we didn't attempt to switch to x more than once then iteration is still valid - we switched to x once so we need to make sure y series is incremented next time
				externalExceptionCount=0; //next time pls increment and visit full y series, making its condition true
			}
			else {
				throw new CounterException("No more counter for you"); //if we shifted to 2nd series (x) more than once (y being 0) that means our counter can stop now.
			}
		}
		else {
			throw new CounterException("No more counter for you");  //more than 1 external exception automatically means we should stop the counter
		}


		fieldString = fieldString.replaceFirst("\\[x\\]", "[" + x + "]");
		fieldString = fieldString.replaceFirst("\\[y\\]", "[" + y + "]");

		return fieldString;
	}

	private String incrementAndReplaceXYZ(String fieldString) throws CounterException {

		if(externalExceptionCount==0) {
			z++;
			if(x==-1) x=0;
			if(y==-1) y=0;
		}
		else if(externalExceptionCount==1) {
			if(z==0) {
				shift++;
			}
			z=0;
			y++;
			if(shift==1) {
				externalExceptionCount=0;
			}
			else {
				y--; //return the same z,y pair and let it fail in exception. Next time it will be caugth in exception=2 condition
			}
		}
		else if(externalExceptionCount==2) {
			if(z==0) {
				shift++;
			}
			z=0;
			y=0;
			x++;
			if(shift==3) {
				externalExceptionCount=0;
			}
			else {
				throw new CounterException("No more counter for you");
			}
		}
		else {
			throw new CounterException("No more counter for you");
		}

		fieldString = fieldString.replaceFirst("\\[x\\]", "[" + x + "]");
		fieldString = fieldString.replaceFirst("\\[y\\]", "[" + y + "]");
		fieldString = fieldString.replaceFirst("\\[z\\]", "[" + z + "]");

		return fieldString;
	}

	public void incrementExceptionCount() {
		externalExceptionCount++;
	}
}
