package com.Admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import com.example.demo.*;
import com.GuestUser.*;
import com.GuestUser.GuestUserBean.RoleName;
import com.Instructor.InsController;
import com.Instructor.InstructorBean;
import com.Instructor.InstructorService;
import com.example.demo.UserBean;
import com.example.demo.UserController;
import com.example.demo.UserService;



@Controller

public class AdminController {
	
	private static final Logger logger =LoggerFactory.getLogger(UserController.class);
	
	private static final Logger logger1 = LoggerFactory.getLogger(InsController.class);
	 
    @Autowired

    private InstructorService instructorService;
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private GuestUserService guestUserService;
	
	@Autowired
    private AdminService adminService;
	
	UserBean user = new UserBean();
	GuestUserBean guest = new GuestUserBean();
	
	
	@GetMapping("/login/admin")
	public String showForm() {
		return "admin-login";
	}
	
	@PostMapping("/submitAdmin")
    public String login(@RequestParam("adminId") int adminId,
                        @RequestParam("password") String password,
                        Model model,HttpSession session) {

        String result = adminService.loginAdmin(adminId, password);

        if (result.startsWith("Login successful")) {
        	session.setAttribute("adminId", adminId);
            model.addAttribute("message", result);
            return "redirect:/dashboard"; 
        } else {
            model.addAttribute("error", result); 
            return "admin-login"; 
        }
    }

    @GetMapping("/dashboard")
    public String showAdminDashboard() {
        return "admin-dashboard"; 
    }

    @GetMapping("/user-list")
	 public String getAllusers(Model model) { 
		 List<UserBean> users = adminService.get();
		 model.addAttribute("users", users);


		 return "user-list";// JSP file name (user-list.jsp)
	 }
    
	// Method to handle form submission
    @PostMapping("/submitUser")
    public String submitUser(@RequestParam int userId,
    		                 @RequestParam String name, 
    						 @RequestParam String emailId, 
    						 @RequestParam String password,
    						 @RequestParam String phoneNumber,
    						 @RequestParam String school,
    						 Model model){
    	 user.setuserId(userId);
         user.setname(name);
         user.setemailId(emailId);
         user.setpassword(password);
         user.setphoneNumber(phoneNumber);
         user.setschool(school);
         user.setCreatedAt(LocalDateTime.now());
 
        // Validate parameters if needed
        if (password == null || password.trim().isEmpty()) {
            model.addAttribute("message", "Password is required!");
            return "user-list";  // Return the user-list view
        }
        
        // Call service to register the user
        String result1 = userService.registerUser(user);
        guest.setUserId(user.getuserId());
        guest.setRole(RoleName.valueOf("Learner"));
        guest.setCreatedAt(LocalDateTime.now());
        String result2 = guestUserService.registerUser(guest);
        
    	//Add a success message to display in the JSP
		model.addAttribute("message", "User added successfully!");

        // Fetch the updated list of users and pass it to the model
     	List<UserBean> users = adminService.get();
     	model.addAttribute("users", users);
     	// Return the same page to reflect changes
     	return "user-list";
    }
    
  //Show the Update form for a specific user
    @GetMapping("/update/{userId}")
    public String showUpdateForm(@PathVariable("userId") Integer userId, Model model,HttpSession session) {
    	Integer sessionUserId = (Integer) session.getAttribute("userId");
    	Integer sessionAdminId = (Integer) session.getAttribute("adminId");
	    	if ((sessionUserId != null && sessionUserId.equals(userId))|| (sessionAdminId==101 )) {
		    	logger.info("Fetching user with ID: {}", userId);
				Optional<UserBean> optionalUser = adminService.getUserById(userId);
		        if (optionalUser.isPresent()) {
		        	logger.info("User found: {}", optionalUser.get());
		            model.addAttribute("user", optionalUser.get()); // Add the actual UserBean object
		            return "update-user";
		        } else {
		        	logger.error("User with ID {} not found!", userId);
		            model.addAttribute("errorMessage", "User not found.");
		            return "error-page"; // Redirect to an error page
		        }
	    	}
	    	else {
	            // If user is not logged in or session userId doesn't match
	            model.addAttribute("error", "You are not authorized to update this profile.");
	            return "login"; // Redirect to login page
	        }
    
    }
    
 // Handle the form submission for updating a user
    @PostMapping("/update/{userId}")
    public String updateUser(@PathVariable("userId") Integer userId, 
                             @RequestParam String name,
                             @RequestParam String emailId,
                             @RequestParam String phoneNumber,
                             @RequestParam String school,
                             @RequestParam(required = false) String password, 
                             Model model,HttpSession session) {
    	Integer sessionUserId = (Integer) session.getAttribute("userId");
    	Integer sessionAdminId = (Integer) session.getAttribute("adminId");
            Optional<UserBean> optionalUser = adminService.getUserById(userId);
            if (!optionalUser.isPresent()) {
                model.addAttribute("errorMessage", "User not found.");
                return "error-page";
            }
 
            UserBean user = optionalUser.get();
            user.setname(name);
            user.setemailId(emailId);
            user.setphoneNumber(phoneNumber);
            user.setschool(school);
            if (password != null && !password.trim().isEmpty()) {
                user.setpassword(password);
            }
 
            adminService.updateUser(userId, user);
            if(sessionUserId==userId) {
                 return "user-page";
            }
            return "admin-dashboard";
    }
    
 // Handle the delete request
    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId, Model model) {
        try {
            adminService.deleteUser(userId);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error-page";
        }
        return "redirect:/user-list";
    }
    
 // Fetching all instructors and mapping it to the admin dashboard (same as users)

   @GetMapping("/instructor-list")

    public String getAllInstructors(Model model) {
        List<InstructorBean> instructors = adminService.getAllInstructors();
        model.addAttribute("instructors", instructors);
        return "instructor-list"; // JSP file name (instructor-list.jsp)

    }
   
   @PostMapping("/submitInstructor")

   public String submitInstructor(@RequestParam int instructorId,
		                          @RequestParam String name,
                                  @RequestParam String emailId,
                                  @RequestParam String password,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String qualification,
                                  @RequestParam int workExperience,
                                  @RequestParam String achievement,
                                  Model model) {

	   
	// Create a new user bean and set the values
       InstructorBean instructor = new InstructorBean();
       instructor.setInstructorId(instructorId);
       instructor.setName(name);
       instructor.setEmailId(emailId);
       instructor.setPassword(password);
       instructor.setPhoneNumber(phoneNumber);
       instructor.setQualification(qualification);
       instructor.setAchievement(achievement);
       instructor.setWorkExperience(workExperience);
       instructor.setCreatedAt(LocalDateTime.now());
       
       logger1.info("Received parameters - Name: {}, EmailId: {}, PhoneNumber: {}, Qualification: {}, WorkExperience: {}, Achievement: {}",
               name, emailId, phoneNumber, qualification, workExperience, achievement);
       
       if (password == null || password.trim().isEmpty()) {
           model.addAttribute("message", "Password is required!");
           return "instructor-list";
       }

       // Call service to register the user
       String result = instructorService.registerIns(instructor);
       
       guest.setInstructorId(instructor.getInstructorId());
       guest.setRole(RoleName.valueOf("Instructor"));
       guest.setCreatedAt(LocalDateTime.now());
       String result2 = guestUserService.registerInst(guest);

       model.addAttribute("message", "Instructor added successfully!");
       List<InstructorBean> instructors = adminService.getAllInstructors();
       model.addAttribute("instructors", instructors);
       return "instructor-list";

   }
   
   @GetMapping("/updateIns/{instructorId}")

   public String showInsUpdateForms(@PathVariable("instructorId") Integer instructorId, Model model,HttpSession session) {
	   Integer sessionInstructorId = (Integer) session.getAttribute("instructorId");
       logger.info("Fetching instructor with ID: {}", instructorId);
       Optional<InstructorBean> optionalInstructor = adminService.getInstructorById(instructorId);
       if (optionalInstructor.isPresent()) {
           model.addAttribute("instructor", optionalInstructor.get());
           return "update-instructor";
       } else {
           logger.error("Instructor with ID {} not found!", instructorId);
           model.addAttribute("errorMessage", "Instructor not found.");
           return "error-page";
       }

   }

   @PostMapping("/updateIns/{instructorId}")

   public String updateInstructor(@PathVariable("instructorId") Integer instructorId,
                                  @RequestParam String name,
                                  @RequestParam String emailId,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String qualification,
                                  @RequestParam int workExperience,
                                  @RequestParam String achievement,
                                  @RequestParam(required = false) String password,
                                  Model model,HttpSession session) {
	   Integer sessionInstructorId = (Integer) session.getAttribute("instructorId");
   	   Integer sessionAdminId = (Integer) session.getAttribute("adminId");

       logger.info("Updating instructor with ID: {}", instructorId);
       Optional<InstructorBean> optionalInstructor = adminService.getInstructorById(instructorId);
       if (!optionalInstructor.isPresent()) {
           logger.error("Instructor not found!");
           model.addAttribute("errorMessage", "Instructor not found.");
           return "error-page";
       }

       InstructorBean instructor = optionalInstructor.get();
       instructor.setName(name);
       instructor.setEmailId(emailId);
       instructor.setPhoneNumber(phoneNumber);
       instructor.setQualification(qualification);
       instructor.setWorkExperience(workExperience);
       instructor.setAchievement(achievement);
       if (password != null && !password.trim().isEmpty()) {
           instructor.setPassword(password);
       }

       try {
           adminService.updateInstructor(instructorId, instructor);
           logger.info("Instructor updated successfully.");
           if(sessionInstructorId==instructorId) {
               return "course-home";
           }
           
           else {
        	   return "redirect:/instructor-list";  
           }
           // Redirecting like users
       } catch (Exception e) {
           logger.error("Error updating instructor: {}", e.getMessage());
           model.addAttribute("errorMessage", "Error updating instructor. Please try again.");
           return "error-page";

       }

   }
   
   @GetMapping("/deleteIns/{instructorId}")

   public String deleteInstructor(@PathVariable("instructorId") Integer instructorId, Model model) {
       try {
           adminService.deleteInstructor(instructorId);
       } catch (RuntimeException e) {
           logger.error("Error deleting instructor: {}", e.getMessage());
           model.addAttribute("errorMessage", e.getMessage());
           return "error-page";
       }
       return "redirect:/instructor-list"; // Redirecting like users
   }
   
    
    
    
}
