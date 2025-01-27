package com.assignment2;

import com.assignment2.PhoneBook;
import java.util.Scanner;
public class SearchAddContacts {

	public static void main(String[] args) {
		
		
		PhoneBook phonebook=new PhoneBook();
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("-----PHONEBOOK-----");
			System.out.println("1. ADD CONTACT");
			System.out.println("2. SEARCH CONTACT");
			System.out.println("3. EXIT");
			System.out.println("Enter a valid option:");
			int choice=scan.nextInt();
			scan.nextLine();
			
			if(choice==1) {
				
				phonebook.addContact();
				
			}
			else if(choice==2) {
				System.out.println("Enter the name you want to search:");
				String searchName=scan.nextLine();
				phonebook.searchContactsByName(searchName);
			}
			else if(choice==3) {
					System.out.println("Exiting the program");
					break;
			}
			else {
				System.out.println("Invalid choice! Please try again!");
			}
			
			
		}
		scan.close();

	}

}
