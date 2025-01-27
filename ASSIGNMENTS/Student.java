package com.assignment2;
import com.assignment2.Subject;
import java.util.HashMap;
import com.assignment2.*;
import java.util.Map;
import java.util.HashMap;
public class Student {
	
	//Individual's report card
	private String studentName;
	private String studentSurname;
	private String studentClass;
	private Map<String,Subject>subjects; //Subject holds votes and judgements
	
	public Student(String studentName,String studentSurname,String studentClass,Map<String, com.assignment2.Subject> subjects2) {
		this.studentName=studentName;
		this.studentSurname=studentSurname;
		this.studentClass=studentClass;
		this.subjects=subjects2;
	}
	
	//Readable report of the student's performance
	public String readableReport() {
		StringBuilder report=new StringBuilder();
		report.append("REPORT CARD DETAILS FOR ").append(studentName).append(" ").append(studentSurname).append("\n");
		report.append("GRADE:").append(studentClass).append("\n");
		report.append("----------------------------------------------------\n");
		report.append("SUBJECTS ALONG WITH THEIR VOTES AND JUDGEMENTS\n");
		report.append("\n");
		
		report.append("----------------------------------------------------");
		report.append(String.format("| %-15s | %-12s | %-15s |\n", "SUBJECT", "GRADE", "JUDGEMENT"));
        report.append("----------------------------------------------------\n");
		//Iterate through subject and append their details
		for(Map.Entry<String, Subject>entry:subjects.entrySet()) {
			String subjectName=entry.getKey();
			Subject subjectDetails=entry.getValue();
			report.append(String.format("| %-15s | %-12s | %-15s |\n",subjectName, subjectDetails.getVote(), subjectDetails.getJudgement()));	
		}
		report.append("----------------------------------------------------");
		return report.toString();	
	}
	
	public void displayReport() {
		System.out.println(readableReport());
		
	}

}