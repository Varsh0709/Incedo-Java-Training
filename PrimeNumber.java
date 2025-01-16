package com.example;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the limit:");
		int limitPrime=scan.nextInt();
		int sum = 0,count=0;
		for(int i=2;i<=limitPrime;i++) {
			boolean prime=true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					prime=false;
					break;
				}
			}
			if(prime) {
				System.out.println(i);
				sum+=i;
				count+=1;
			}
		}
		System.out.println("Sum of prime numbers:"+sum);
		if(count>0) {
			System.out.println("Average of prime numbers:"+sum/count);
		}
		else {
			System.out.println("No prime numbers");
		}
	}

}
