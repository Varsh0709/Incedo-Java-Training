package com.assignment2;

import java.util.Random;
import java.util.Scanner;

public class HeadsOrTails{
	
	public static String getHeadsOrTails(String userGuess) {
		
		//Use switch case to get input and display whether a heads or a tails
		switch(userGuess.toLowerCase()) {
		case "heads":
			return "Entered heads!";
		
		case "tails":
			return "Entered tails!";
			
		default:
			return "Invalid! Enter either a heads or a tails!";
		}
		
	}
	
class TestClass{
	
	public static void displayResult(String input) {
		String EnteredResult=HeadsOrTails.getHeadsOrTails(input);
	}
}

static class HeadsOrTailsGame{
	public static String TossCoin() {
		Random random=new Random();
		
		//nextInt(2) - 0 for heads and 1 for tails
		int cointoss=random.nextInt(2);
		if(cointoss==0) {
			return "heads";
		}
		else {
			return "tails";
		}	
	}
	
	public static void userChoice(String userGuess) {
		String Result=TossCoin();
		System.out.println("The result is:"+Result);
		
		if(Result.equals(userGuess)) {
			System.out.println("Yay! Your guess is right!");
			System.out.println("You won!");
			System.exit(0);
		}
		else {
			System.out.println("Nah! Try again!");
			
		}
	}
}

public static void main(String[] args) {
		//Ask the input from the user for guessing
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your guess:");
		String userGuess=scan.nextLine().trim();
		HeadsOrTailsGame.userChoice(userGuess);
		System.out.println("Do you want to re-enter your guess(yes/no)?");
		String choice=scan.nextLine().trim();
		if(choice.equalsIgnoreCase("No")) {
			System.out.println("Thankyou for playing!");
		}
		else if(choice.equalsIgnoreCase("Yes")) {
			System.out.println("Re-enter your guess:");
			String reGuess=scan.nextLine().trim();
			HeadsOrTailsGame.userChoice(reGuess);
		}
		scan.close();
		
	}

}
