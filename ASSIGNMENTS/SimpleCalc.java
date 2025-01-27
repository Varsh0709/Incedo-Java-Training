package com.assignment2;

import java.util.Scanner;
import javax.swing.*;
public class SimpleCalc {
	
	public static int add(int a,int b) {
		return a+b;
	}
	
	public static int sub(int a,int b) {
		return a-b;
	}
	
	public static int mul(int a,int b) {
		return a*b;
	}
	
	public static int div(int a,int b) {
		return a%b;
	}
	
	public static String largest(int a,int b) {
		if(a>b) {
			return a+"is greater";
		}
		else if(a<b) {
			return b+"is greater";
		}
		else {
			return "They are equal";
		}
	}
	
	public static String smallest(int a,int b) {
		if(a<b) {
			return a+"is smallest";
		}
		else if(a>b) {
			return b+"is smallest";
		}
		else {
			return "They are equal";
		}
	}
	
	public static int avg(int a,int b) {
		return a+b/2;
	}
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the first number");
		int num1=scan.nextInt();
		
		System.out.println("Enter second number");
		int num2=scan.nextInt();
		
		
		
		
		

	}

}

