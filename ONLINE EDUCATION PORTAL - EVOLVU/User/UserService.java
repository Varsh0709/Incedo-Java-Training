package com.User;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;



@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	/*@Autowired
    private UserService userService;*/
	

	public List<UserBean> get() {
		return userRepository.findAll();
	}
	
	// Get a user by ID
    public Optional<UserBean> getUserById(Integer userID) {
        return userRepository.findById(userID);
    }	
    
    public void saveUser(UserBean user) {
        userRepository.save(user);
    }
    // Update user details
    public void updateUser(Integer userID, UserBean updatedUser) {
        Optional<UserBean> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            UserBean user = optionalUser.get();
            user.setName(updatedUser.getName());
            user.setEmailId(updatedUser.getEmailId());
            user.setPhoneno(updatedUser.getPhoneno());
            user.setEducation(updatedUser.getEducation());

            if (updatedUser.getPassword() != null && !updatedUser.getPassword().trim().isEmpty()) {
                user.setPassword(updatedUser.getPassword());
            }

            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    
    // Delete user by ID
    public void deleteUser(Integer userID) {
        if (userRepository.existsById(userID)) {
            userRepository.deleteById(userID);
        } else {
            throw new RuntimeException("User not found for deletion");
        }
    }

	/*
	 * public String getAllUsers(Model model) { List<UserBean> users =
	 * userService.getAllUsers(); model.addAttribute("users", users); return
	 * "user-list"; // JSP file name without extension }
	 */
	
}


