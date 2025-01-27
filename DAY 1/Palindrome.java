package com.basics;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a number:");
		int num=scan.nextInt();
		int temp=num;
		int reversedNum=0;
		while(temp!=0) {
			int rem=temp%10;
			reversedNum=reversedNum*10+rem;
			temp=temp/10;
		}
		if(num==reversedNum) {
			System.out.println(num+" "+"is a pallindrome number");
		}
		else {
			System.out.println(num+" "+"is not pallindrome");
		}
	}

}