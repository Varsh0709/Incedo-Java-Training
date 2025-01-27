package com.basics;

import java.util.Scanner;
public class numberToWords {
	public static final String lessthanten[]= {" ","one","two","three","four","five","six","seven","eight","nine"};
	public static final String lessthantwenty[]= {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	public static final String lessthanhundred[]= {" "," ","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
	
	public static String convertToWords(int number) {
		
		if(number==0) {
			return "zero";
		}
		else if(number==10) {
			return "ten";
		}
		else if(number<10) {
			return lessthanten[number];
		}
		else if(number<20) {
			return lessthantwenty[number-10];
		}
		else if(number<100) {
			return lessthanhundred[number/10]+" "+(number%10!=0?" "+lessthanten[number%10]:" ");
		}
		else if(number<1000) {
			return lessthanten[number/100]+"Hundred"+(number%100!=0?" "+convertToWords(number%100):" ");
		}
		else if (number < 1000000) {
            return convertToWords(number / 1000) + " thousand" + (number % 1000 != 0 ? " " + convertToWords(number % 1000) : "");
        }
		else {
            return convertToWords(number / 1000000) + " million" + (number % 1000000 != 0 ? " " + convertToWords(number % 1000000) : "");
        }
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a number:");
		int num=scan.nextInt();
		String result=convertToWords(num);
		System.out.println(result);

	}

}