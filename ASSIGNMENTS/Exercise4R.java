package com.assignment2;

import java.util.Scanner;
public class Exercise4R {
	 private static int matrix[][] = {
			 {1, 7, 3, 9, 5, 3},
			{6, 2, 3},
			 {7, 5, 1, 4, 0},
			 {1, 0, 2, 9, 6, 3, 7, 8, 4}
			};
	 
	 //Find the first occurence of the target number in the matrix
	 public static String findPosition(int targetpos) {
		 for(int rows=1;rows<matrix.length;rows++) {
			 for(int cols=1;cols<matrix[rows].length;cols++) {
				 if(matrix[rows][cols]==targetpos) {
					 return "Number :"+targetpos+"found at "+rows+"'th row and"+cols+"'th column";	 
				 }
				 else {
					 return "Number :"+targetpos+"not found";
				 }
				 
			 }
		 }
		return null; 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=-1;
		
		//Case 1 : No command line argument is provided
		if(args.length<1) {
			//Ask for the user input interactively
			System.out.println("No command line argument provided");
			System.out.println("Please enter a valid number between 0 to 9");
			
			Scanner scan=new Scanner(System.in);
			while(true) {
				if(scan.hasNextInt()) {
					num=scan.nextInt();
					if(num>=0 && num<=9) {
						System.out.println("Valid input");
						break;
					}
					else {
						System.out.println("Not valid! \n Please provide an integer between 0 and 9");
					}
				}
				else {
					System.out.println("Not an integer! \n Please provide an integer");
					scan.next(); //Consume the invalid input
				}
			}
		}
		else {
			try {
				//Case 2 : The argument is not within the specified range
				num=Integer.parseInt(args[0]);
				if(num<0 && num>9) {
					System.out.println("Error.The number must be within 0 and 9");
					System.out.println("Usage: java Exercise4R <number between 0 and 9>");
					return;
				}
		
			}catch(NumberFormatException e){
				//Case 3 : The argument is not an integer
				System.out.println("Invalid input. Please provide an integer");
				
			}
			String result = findPosition(num);
	        System.out.println(result);
			
		}
		

	}

}
