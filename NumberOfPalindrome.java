package com.example;

import java.util.Scanner;

public class NumberOfPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the limit:");
		int limit=scan.nextInt();
		for(int i=10;i<=limit;i++) {
			int temp=i;
			int reversedNum=0;
			while(temp!=0) {
				int rem=temp%10;
				reversedNum=reversedNum*10+rem;
				temp=temp/10;
			}
			if(i==reversedNum) {
				System.out.println(i);
			}
		}
	}

}
