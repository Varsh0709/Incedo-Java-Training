package com.basics;

import java.util.Scanner;

public class SumOfDig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number:");
		int number=scan.nextInt();
		int sum=0;
		int temp=number;
		while(temp!=0) {
			int rem=temp%10;
			sum=sum+rem;
			temp/=10;
		}
		System.out.println(sum);
	}

}
