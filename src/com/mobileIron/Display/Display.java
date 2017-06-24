package com.mobileIron.Display;

import com.mobileIron.Exceptions.Exceptionhandle;

public class Display {
	Exceptionhandle exceptionHandle = new Exceptionhandle();
	/**
	 * based on type convert the value to different format
	 * @param type
	 * @param value
	 */
	public void valueModification(String type, String value){	
		try{
			switch (type){
				case "UPPRCS" : 
					value=value.toUpperCase();
					printResult(value,type); 
					break;
				case "REPLCE" : 
					value="THIS STRING";
					printResult(value,type);
					break;
				default: 
					value="Type not valid"; 
					printResult(value,type); 
					break;
		
			}
		}catch(NullPointerException e){
			exceptionHandle.nullPointerException("NullPointerException in valueModification :",e);
		}catch(Exception e){
			exceptionHandle.runTimeError("RunTimeError in valueModification :",e);
		}
	}
	/**
	 * Print output in desired format for each format
	 * @param value
	 * @param type
	 */
	public void printResult(String value,String type){
		try{
			if(type.contains("UPPRCS"))
				System.out.println(type+"-"+value);
			else if(type.contains("REPLCE"))
				System.out.println(type+"-"+value);
			else
				System.out.println("Type not valid");
		}catch(NullPointerException e){
			exceptionHandle.nullPointerException("NullPointerException in printResult : :",e);
		}catch(Exception e){
			exceptionHandle.runTimeError("RunTimeError in printResult :",e);
     	 }
	}
}
