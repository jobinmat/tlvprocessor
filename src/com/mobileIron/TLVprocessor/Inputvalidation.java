package com.mobileIron.TLVprocessor;

import com.mobileIron.Display.Display;
import com.mobileIron.Exceptions.Exceptionhandle;

public class Inputvalidation {
	String[] type=TLVprocessor.typeArray;
	Display display = new Display();
	Exceptionhandle exceptionHandle = new Exceptionhandle();
	
	/**
	 * receive input from main method and check the validity 
	 * of the input based on the validity it converts the 
	 * input to desired format
	 * @param input
	 */
	
	public void splitTLV(String input){
		try{
			String[] data= input.trim().split("-",3);
			if(data.length<3){
				System.out.println("Invalid Input !!!! please reconsider the input");
			}
			else{
				if(checkLength(data[1])){
					int lengthofValue=Integer.valueOf(data[1]);
					if(data[2].length()== lengthofValue){
						if(CheckTLV(data[0],data[1],data[2])){
							display.valueModification(data[0],data[2]);
						}
						else{
							System.out.println("Invalid Input !!!! please reconsider the input");
						}
					}
					else if(data[2].length() < lengthofValue){
						System.out.println("Invalid Input !!!! please reconsider the input came in between");
					}
					else{
						if(CheckTLV(data[0],data[1],data[2])){
							display.valueModification(data[0], data[2].substring(0, lengthofValue));
						}
						else{
							System.out.println("Invalid Input !!!! please reconsider the input");
						}
						splitTLV(data[2].substring(lengthofValue, data[2].length()));
					}
				}
				else{
					System.out.println("Invalid Input !!!! please reconsider the input");
				}
			}
		}catch(Exception e){
			exceptionHandle.runTimeError("RunTimeError in splitTLV :", e);
		}
	}
	public boolean CheckTLV(String T,String L,String v){
		if(T.length()== 6  && L.length()== 4){
			if(!L.contains("[a-zA-Z]+") && checkValue(v,Integer.valueOf(L))){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkType(String T){
		for( String ty:type){
			if( ty.equals(T)){
				return true;	
			}
		}
		return false;
	}
	
	public boolean checkLength(String L){
		if(L.length()== 4 && !L.contains("[a-zA-Z]+")){
			return true;
		}
		return false;
	}
	
	public boolean checkValue(String v, int lengthofValue){
		if(v!= null && v.length() >= lengthofValue){
			return true;
		}
		return false;
	}
	
}
