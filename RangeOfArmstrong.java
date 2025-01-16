package com.example;

public class RangeOfArmstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int num=10;num<=1000;num++) {
			int length=String.valueOf(num).length();
			int sum=0;
			int temp=num;
			while(temp!=0) {
				int rem=temp%10;
				sum=sum+(int)Math.pow(rem, length);
				temp=temp/10;
			}
			if(num==sum) {
				System.out.println(num);
			}
			
		}
	}

}
