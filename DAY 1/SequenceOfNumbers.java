package com.basics;

import java.util.Scanner;

public class SequenceOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the limit:");
		int limit=scan.nextInt();
		for(int i=0;i<=limit;i++) {
			System.out.print(i+" ");
		}

	}

}