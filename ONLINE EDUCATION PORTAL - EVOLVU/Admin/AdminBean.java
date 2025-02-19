package com.Admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.Table;




@Entity
@Table(name = "Admin")

public class AdminBean {
	
	@Id
	@Column(name = "AdminId")
	private int adminId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "EmailId")
	private String emailId;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

	
	public int getadminId() {
		return adminId;
	}
	
	public void setadminId(int adminId) {
		this.adminId = adminId;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public String getname() {
		return name;
	}
	
	public String getemailId() {
		return emailId;
	}
	
	public void setemailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getpassword() {
		return password;
	}
	
	
	public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
	
    
}
