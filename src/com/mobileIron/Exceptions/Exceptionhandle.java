package com.mobileIron.Exceptions;

public class Exceptionhandle {
	
	/**
	 * Exception handle to handle run time error and null pointer error
	 * @param comment
	 * @param e
	 */
	public void runTimeError(String comment,Exception e){
		System.out.println(comment+e);
	}
	public void nullPointerException(String comment,NullPointerException e){
		System.out.println(comment+e);
		
	}

}
