package com.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instructor.InsRepository;
import com.Instructor.InstructorBean;
import com.example.demo.*;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	

    @Autowired
    private UserRepository userRepository;
    
    @Autowired

    private InsRepository instructorRepository;
	
	
	public List<UserBean> get() {
		return userRepository.findAll();
	}
	
	
	 public Optional<UserBean> getUserById(Integer userId) {
	        return userRepository.findById(userId);
	    }	
	 
	 
	 
	// Update user details
	    public void updateUser(Integer userId, UserBean updatedUser) {
	        Optional<UserBean> optionalUser = userRepository.findById(userId);
	        if (optionalUser.isPresent()) {
	            UserBean user = optionalUser.get();
	            user.setname(updatedUser.getname());
	            user.setemailId(updatedUser.getemailId());
	            user.setphoneNumber(updatedUser.getphoneNumber());
	            user.setschool(updatedUser.getschool());
	 
	            if (updatedUser.getpassword() != null && !updatedUser.getpassword().trim().isEmpty()) {
	                user.setpassword(updatedUser.getpassword());
	            }
	 
	            userRepository.save(user);
	        } else {
	            throw new RuntimeException("User not found.");
	        }
	    } 
	 
	    
	    
	 // Delete user by ID
	    public void deleteUser(Integer userId) {
	        if (userRepository.existsById(userId)) {
	            userRepository.deleteById(userId);
	        } else {
	            throw new RuntimeException("User not found for deletion");
	        }
	    }
	public String loginAdmin(int adminId, String password) {
    	AdminBean admin = adminRepository.findByAdminIdAndPassword(adminId,password);
        
        if (admin != null) {
            return "Login successful";
        } else {
            return "Login Failed! Check your User ID and Password.";
        }
    }
	
	// Get all instructors
    public List<InstructorBean> getAllInstructors() {
        return instructorRepository.findAll();
    }
    
 // Find instructor by ID
    public Optional<InstructorBean> getInstructorById(Integer instructorId) {
        return instructorRepository.findById(instructorId);

    }
    
 // Update instructor details (fixed password update logic)
    public void updateInstructor(Integer instructorId, InstructorBean updatedInstructor) {
        Optional<InstructorBean> optionalInstructor = instructorRepository.findById(instructorId);
        if (optionalInstructor.isPresent()) {
            InstructorBean instructor = optionalInstructor.get();
            instructor.setName(updatedInstructor.getName());
            instructor.setEmailId(updatedInstructor.getEmailId());
            instructor.setPhoneNumber(updatedInstructor.getPhoneNumber());
            instructor.setQualification(updatedInstructor.getQualification());
            instructor.setWorkExperience(updatedInstructor.getWorkExperience());
            instructor.setAchievement(updatedInstructor.getAchievement());

            if (updatedInstructor.getPassword() != null && !updatedInstructor.getPassword().trim().isEmpty()) {
                instructor.setPassword(updatedInstructor.getPassword());
            }
            instructorRepository.save(instructor);
        } else {
            throw new RuntimeException("Instructor not found.");
        }
    }
 
    // Delete instructor
    public void deleteInstructor(Integer instructorId) {
        if (instructorRepository.existsById(instructorId)) {
            instructorRepository.deleteById(instructorId);
        } else {
            throw new RuntimeException("Instructor not found for deletion.");
        }

    }

	

}
