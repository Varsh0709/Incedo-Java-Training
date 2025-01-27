package com.basics;

import java.util.Scanner;

public class SumOfFirstN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the limit:");
		int number=scan.nextInt();
		for(int i=1;i<=number;i++) {
			sum+=i;
		}
		System.out.println(sum);

	}

}
