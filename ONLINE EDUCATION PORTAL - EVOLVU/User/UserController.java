package com.User;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger =LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private UserService userService;
	
	
	
	
	 @GetMapping("/user-list")
	 public String getAllusers(Model model) { 
		 List<UserBean> users = userService.get();
		 model.addAttribute("users", users);
		 return "user-list";// JSP file name (user-list.jsp)
	 }
	 /*@GetMapping 
	 public String redirectToUserList() {
	     return "redirect:/users/user-list";
	 }*/

	
	// Method to handle form submission
    @PostMapping("/submitUser")
    public String submitUser(@RequestParam String name, 
    						 @RequestParam String email, 
    						 @RequestParam String password,
    						 @RequestParam String phoneNumber,
    						 @RequestParam String education,
    						 Model model){
    	
    	// Debugging - log incoming parameters
        System.out.println("Received parameters: ");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Education: " + education);
        System.out.println("Password: " + password);

        // Validate parameters if needed
        if (password == null || password.trim().isEmpty()) {
            model.addAttribute("message", "Password is required!");
            return "user-list";  // Return the user-list view
        }
        
        // Create a UserBean object with the received data
    	UserBean newUser = new UserBean(name, email, password, phoneNumber, education);
    	
    	// Save the new user to the database
    	userService.saveUser(newUser);
    	
    	//Add a success message to display in the JSP
		model.addAttribute("message", "User added successfully!");
 
 
        // Fetch the updated list of users and pass it to the model
     	List<UserBean> users = userService.get();
     	model.addAttribute("users", users);
     	
     	// Return the same page to reflect changes
     	return "user-list";
    }
    
    //Show the Update form for a specific user
    @GetMapping("/update/{userID}")
    public String showUpdateForm(@PathVariable("userID") Integer userID, Model model) {
    	
    	logger.info("Fetching user with ID: {}", userID);
    	
		Optional<UserBean> optionalUser = userService.getUserById(userID);
        
        if (optionalUser.isPresent()) {
        	logger.info("User found: {}", optionalUser.get());
            model.addAttribute("user", optionalUser.get()); // Add the actual UserBean object
            return "update-user";
        } else {
        	logger.error("User with ID {} not found!", userID);
            model.addAttribute("errorMessage", "User not found.");
            return "error-page"; // Redirect to an error page
        }
    }
    
    // Handle the form submission for updating a user
    @PostMapping("/update/{userID}")
    public String updateUser(@PathVariable("userID") Integer userID, 
                             @RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String phoneNumber,
                             @RequestParam String education,
                             @RequestParam(required = false) String password, 
                             Model model) {
            Optional<UserBean> optionalUser = userService.getUserById(userID);
            if (!optionalUser.isPresent()) {
                model.addAttribute("errorMessage", "User not found.");
                return "error-page";
            }

            UserBean user = optionalUser.get();
            user.setName(name);
            user.setEmailId(email);
            user.setPhoneno(phoneNumber);
            user.setEducation(education);
            
            if (password != null && !password.trim().isEmpty()) {
                user.setPassword(password);
            }

            userService.updateUser(userID, user);
            return "redirect:/users/user-list";
    }


    
    // Handle the delete request
    @GetMapping("/delete/{userID}")
    public String deleteUser(@PathVariable("userID") Integer userID, Model model) {
        try {
            userService.deleteUser(userID);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error-page";
        }
        return "redirect:/users/user-list";
    }
    
}


