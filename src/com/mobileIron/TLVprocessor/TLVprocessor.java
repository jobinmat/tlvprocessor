package com.mobileIron.TLVprocessor;

import java.util.Scanner;

import com.mobileIron.Exceptions.Exceptionhandle;

/**
* The TLVprocessor program implements an application that
* take Type Length and value as input and convert value  
* to different text format like uppercase.
*
* @author  Jobin Mathew
* @version 1.0
* @since   2017-06-24 
*/
public class TLVprocessor {

	
    public static String[] typeArray={"UPPRCS","REPLCE"};
    private static Inputvalidation inputValidation;
    private static Exceptionhandle exceptionHandle;
    
    
    /**
     * STDIN of input Type-Length-Value
     * call splitTLV method to validate input and convert to desired format 
     * continue the loop until we exit
     * @param args
     */
    
	public static void main(String[] args) {
		Scanner scan = null;
		inputValidation=new Inputvalidation();
		exceptionHandle= new Exceptionhandle();
		try{
			scan= new Scanner(System.in);
			String loop=null;
			do{
				System.out.println("Enter the Input: ");
				String input=scan.nextLine();
				inputValidation.splitTLV(input);
				System.out.println("Do you want to continue: y or n");
				loop=scan.nextLine();
			}while(loop.equals("y") || loop.equals("Y"));
		}catch(Exception e){
			exceptionHandle.runTimeError("RunTimeError in main : ", e);
			
	}
		finally {
			if(scan!=null)
		        scan.close();
		}
	}

}
