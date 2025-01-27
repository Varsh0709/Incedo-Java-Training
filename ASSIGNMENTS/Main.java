package com.assignment2;

import com.assignment2.Student;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		boolean continueEnteringStudents=true;
		//Create an array list to store multiple student objects
		ArrayList<Student> studentsList=new ArrayList<>();
		//Get student details
		
				while(continueEnteringStudents) {
					System.out.println("Kindly enter the student details to generate a report");
					System.out.println("*****************************************************");
					
					System.out.println("Enter the name of the student:");
					String studentName=scan.nextLine();
					
					System.out.println("Enter the surname of the student:");
					String studentSurname=scan.nextLine();
					
					System.out.println("Enter student class:");
					String studentClass=scan.nextLine();
					
					//Subjects map
					Map<String,Subject>subjects=new HashMap<>();
					
					//Add student details
					System.out.println("The student has the following subjects\n1.Science\n2.English\n3.German\n4.Maths\n5.Comp");
					System.out.println("*******************************************************************************************************************");
					System.out.println("Grade details are:\n");
					System.out.println("A - Excellent");
					System.out.println("B - Good");
					System.out.println("C - Needs Improvement");
					System.out.println("D - Poor");
					boolean addSubjects=true;
					while(addSubjects) {
						System.out.println("Enter subject name:");
						String subjectName=scan.nextLine();
						
						System.out.println("Enter the vote for "+subjectName+":");
						String vote=scan.nextLine();
						
						System.out.println("Enter the judgement for "+subjectName+":");
						String judgement=scan.nextLine();
						
						subjects.put(subjectName,new Subject(vote,judgement));
						
						//Ask if the user wants to enter another subject
						System.out.println("Do you want to enter another subject?(yes/no)");
						String response=scan.nextLine();
						if(response.equalsIgnoreCase("yes")) {
							addSubjects=true;
						}
						else if(response.equalsIgnoreCase("no")) {
							addSubjects=false;
							System.out.println("Exiting the subject entry.");
						}
						else {
							System.out.println("Please enter a yes or a no");
						}
						
				}
				
				// Create a Student object and add it to the list
		        Student student = new Student(studentName, studentSurname, studentClass, subjects);
				studentsList.add(student);
				
				System.out.println("Do you want to enter details of another student(yes/no)?");
				String res=scan.nextLine();
				if(res.equalsIgnoreCase("yes")) {
					continueEnteringStudents=true;
				}
				else if(res.equalsIgnoreCase("no")) {
					continueEnteringStudents=false;
					System.out.println("Exiting the program");
				}
				else {
					System.out.println("Please enter a yes or a no");
				}
					
				}
				
				System.out.println("\n----FINAL CONSOLIDATED REPORT----");
				for(Student student:studentsList) {
					student.displayReport();
				}
				
				scan.close();

			}

		}


