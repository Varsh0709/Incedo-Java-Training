package com.assignment2;

import java.util.Scanner;
import java.util.HashMap;
public class wordModerator {

	public static void main(String[] args) {
		//Create a new hashmap to store censor words and say it is censored
		HashMap<String,String> censoredWords=new HashMap<>();
		
		//ADD WORDS WHICH ARE RECOGNISED AS CENSORED
		censoredWords.put("BAD","****CENSORED****");
		censoredWords.put("RUDE","****CENSORED****");
		censoredWords.put("UGLY","****CENSORED****");
		censoredWords.put("UNKIND","****CENSORED****");
		censoredWords.put("UNPLEASANT","****CENSORED****");
		
		//GET INPUT FROM THE USER FOR THE WORD
		boolean words=true;
		while(words) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the word :");
			String inputWord=scan.nextLine().trim();
			
			if(inputWord.equalsIgnoreCase("end")) {
				System.out.println("You typed \"end\".... \nProgram ended......");
				break;
			}
			
			//Converting the input word to upper case and then checking against the censored words
			String inputWordUpper=inputWord.toUpperCase();
			
			if(censoredWords.containsKey(inputWordUpper)) {
				System.out.println("The word "+inputWordUpper+"is censored");
				System.out.println("Re-enter the word");
				continue;
			}
			else {
				System.out.println("You typed "+inputWordUpper);
				System.out.println(inputWord+" is accepted!");
			}
			
			//Ask the user if the user wants to enter another word
			System.out.println("Do you want to enter another word(yes/no)?");
			String response=scan.nextLine();
			
			if(response.equalsIgnoreCase("yes")) {
				continue;
			}
			else if(response.equalsIgnoreCase("no")){
					System.out.println("The program is exiting......");
					break;
			}
			else {
				System.out.println("Invalid response!\n Re-Enter a valid response (yes/no)");
			}
		
		}	

	}

}
