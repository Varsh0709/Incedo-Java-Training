package com.example;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Floyds triangle
		/*Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int rows=scan.nextInt();
		int number=1;
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(number+" ");
				number++;
				}
			System.out.println();
		}
				
				
		//right angled triangle pattern
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int rows=scan.nextInt();
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
				
		//triangle pattern
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int rows=scan.nextInt();
		for(int i=1;i<=rows;i++) {
			for(int j=i;j<rows;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=(2*i-1);k++) {
				System.out.print("*");
			}
			System.out.println();
		}*/
		
		//Inverted triangle pattern
		/*Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int rows=scan.nextInt();
		for(int i=rows;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}*/
		
		//Number pattern
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of rows:");
		int rows=scan.nextInt();
		int number=1;
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(number+" ");
			}
			System.out.println();
		}
		
		
	}

}
