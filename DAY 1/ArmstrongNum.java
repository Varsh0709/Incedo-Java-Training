package com.basics;

import java.util.Scanner;

public class ArmstrongNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a number:");
		int num=scan.nextInt();
		int length=String.valueOf(num).length();
		int sum=0;
		int temp=num;
		while(temp!=0) {
			int rem=temp%10;
			sum=sum+(int)Math.pow(rem, length);
			temp=temp/10;
		}
		if(num==sum) {
			System.out.println(num+" "+"is an armstrong number");
		}
		else {
			System.out.println(num+" "+"is not an armstrong number");
		}
	}

}
