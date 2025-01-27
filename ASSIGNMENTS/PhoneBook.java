package com.assignment2;
import java.util.HashMap;
import java.util.Scanner;
public class PhoneBook {
	
	private HashMap<String,Long> contactBook;
	
	public PhoneBook() {
		contactBook=new HashMap<>();
		contactBook.put("Allysa", 9876589076L);
		contactBook.put("John", 8904567892L);
		contactBook.put("Lilly", 6789056743L);
		contactBook.put("Mathew", 8907654321L);
		contactBook.put("Sara", 5678945678L);
	}
	Scanner scan=new Scanner(System.in);
	
	public void addContact() {
		boolean continueAdding=true;
		while(continueAdding) {
			System.out.println("Enter name:");
			String Name=scan.nextLine();
			
			System.out.println("Enter phone number:");
			Long PhoneNum=(long) scan.nextLong();
			scan.nextLine();
			
			contactBook.put(Name, PhoneNum);
			System.out.println("Contact added successfully");
			System.out.println("Do you want to add more contacts(yes/no)?");
			String addMore=scan.nextLine();
			if(addMore.equalsIgnoreCase("no")) {
				continueAdding=false;
			}
			
		}
	}
	
	public void searchContactsByName(String Name) {
		boolean continueSearching=true;
		
		while(continueSearching) {
			if(contactBook.containsKey(Name)) {
				System.out.println("Name:"+Name+"Phone number:"+contactBook.get(Name));
				continueSearching=false;
			}
			else {
				System.out.println(Name+"not in contacts");
				System.out.println("Do you want to continue the search operation (yes/no)?");
				String option=scan.nextLine();
				if(option.equalsIgnoreCase("yes")) {
					System.out.println("Re-enter another name for searching:");
					Name=scan.nextLine();
				}
				else if(option.equalsIgnoreCase("no")) {
					continueSearching=false;
					System.out.println("Exiting the search operation");
				}
			
		}
		
	}
}
	
	public HashMap<String,Long> getContactBook(){
		return contactBook;
		
	}
	

}
