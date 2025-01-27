package com.user;

import java.util.Scanner;
import java.util.regex.Pattern;
public class userValidation {
	public static void NameValidation(Scanner scan,String username) {
		//Input Name
		if(Pattern.matches("^[a-zA-Z0-9]+$", username)) {
			//System.out.println("Valid name");
			System.out.println("Enter Email:");
		}
		else {
			System.out.println("Invalid name");
			System.out.println("Enter valid name");
			username=scan.nextLine();
			NameValidation(scan,username);
		}
	}
	public static void EmailValidation(Scanner scan,String email) {
		if(Pattern.matches("^[\\w.-]+@[\\w.-]+\\.com$", email)) {
			//System.out.println("Valid email");
			System.out.println("Enter DOB:");
		}
		else {
			System.out.println("Invalid email");
			System.out.println("Re-enter email:");
			email=scan.nextLine();
			EmailValidation(scan,email);
		}
	}
	
	public static void DOBValidation(Scanner scan,String dob) {
		if(Pattern.matches("^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", dob)){
			//System.out.println("Valid date of birth");
			askTheUser(scan);
		}
		else {
			System.out.println("Invalid date of birth");
			System.out.println("Re-enter date of birth");
			dob=scan.nextLine();
			DOBValidation(scan,dob);
		}
	}
	
	public static void askTheUser(Scanner scan) {
		System.out.println("Do you want to continue(yes or no)?");
		String response=scan.nextLine();
		if(response.equals("yes")){
			System.out.println("Enter Name:");
            String username = scan.nextLine();
            NameValidation(scan, username);

            System.out.println("Enter Email:");
            String email = scan.nextLine();
            EmailValidation(scan, email);

            System.out.println("Enter DOB:");
            String dob = scan.nextLine();
            DOBValidation(scan, dob);
		}else if(response.equals("no")) {
			System.out.println("Exiting the program");
			System.exit(0);
		}
		else {
			System.out.println("Enter a yes or a no");
			askTheUser(scan);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("FORM VALIDATION:");
		System.out.println("******************");
		System.out.println("Enter Name");
		Scanner scan=new Scanner(System.in);
		String username=scan.nextLine();
		NameValidation(scan,username);
		String email=scan.nextLine();
		EmailValidation(scan,email);
		String dob=scan.nextLine();
		DOBValidation(scan,dob);
		
	}


}
