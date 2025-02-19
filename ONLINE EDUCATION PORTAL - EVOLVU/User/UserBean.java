package com.User;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Learners")

public class UserBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private int user_id;
	
	@Column(name = "Name", nullable = false)
    private String name;
	
	@Column(name = "email_id", nullable = false)
    private String emailid;
	
	@Column(name = "Password", nullable = false)
    private String password;
	
	@Column(name = "PhoneNumber", nullable = false)
    private String phoneno;
	
	@Column(name = "School", nullable = false)
    private String education;

    // Default constructor
    public UserBean() {}
    
    public UserBean(String name, String emailId, String password, String phoneno, String education) {
        this.name = name;
        this.emailid = emailId;
        this.password = password;
        this.phoneno = phoneno;
        this.education = education;
    }


   //Getter and setter method
 
    public int getUserID() {
       return user_id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    
    public void setEmailId(String emailId) {
        this.emailid = emailId;
    }
    
    public String getEmailId() {
        return emailid;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    
    public String getPhoneno() {
        return phoneno;
    }
    
    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

	
}
