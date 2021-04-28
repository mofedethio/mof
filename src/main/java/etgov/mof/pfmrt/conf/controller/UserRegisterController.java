package etgov.mof.pfmrt.conf.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import etgov.mof.pfmrt.conf.dao.RoleRepository;
import etgov.mof.pfmrt.conf.exception.CustomeFieldValidationException;
import etgov.mof.pfmrt.conf.exception.UsernameOrIdNotFound;
import etgov.mof.pfmrt.conf.util.ChangePasswordForm;
import etgov.mof.pfmrt.conf.model.Directorate;
import etgov.mof.pfmrt.conf.model.Organization;
import etgov.mof.pfmrt.conf.model.Role;
import etgov.mof.pfmrt.conf.model.User;
import etgov.mof.pfmrt.conf.service.DirectorateService;
import etgov.mof.pfmrt.conf.service.OrganizationService;
import etgov.mof.pfmrt.conf.service.UserService;
import etgov.mof.pfmrt.conf.validation.UserValidator;



@Controller

public class UserRegisterController {


	@Autowired
	UserService userService;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private OrganizationService orgservice;
	@Autowired
	private DirectorateService dirservice;
	
	 @Autowired
	private UserValidator userValidator;
	
	 
	 
	 
	@GetMapping({"/login"})
	public String login(Model model,String error, String logout) {
		model.addAttribute("userForm", new User());
		if (error != null)
            model.addAttribute("error", "Your username or password is invalid.");
		
		 if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");
		 
		return "login";
	}
	
	/*
	 * //for login form validation
	 * 
	 * 
	 * @RequestMapping(value= "/login", method= RequestMethod.POST) public String
	 * doLogin(@Valid @ModelAttribute("userForm") User user, BindingResult result) {
	 * if (result.hasErrors()) { return "redirect:/login"; }
	 * 
	 * return "login"; }
	 */	
	
	
	//used to get list of users from database;
	@GetMapping("/userlist")
	public String userList(Model model,User user) {
		
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		
		model.addAttribute("signup",true);
		model.addAttribute("userForm", new User());
		model.addAttribute("roles",roles);
		
		//for user role and organization list
		model.addAttribute("userForm", user);
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		
		List<Organization> orglist = orgservice.getOrganizations();
		model.addAttribute("organizations",orglist);
		List<Directorate> dirlist = dirservice.GetAllDirectorates();
		model.addAttribute("directorate",dirlist);
		
		return "emcp/user-register";
	}
	
	

	
	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap model) {
		userValidator.validate(user, result);
		
		
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		model.addAttribute("user", user);
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		
		if(result.hasErrors()) {

			return "validation-error";
		}else {
			try {
				userService.createUser(user);
				model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + 
						" registered successfully");
				
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
               
			}catch (Exception e) {
				model.addAttribute("errors",e.getMessage());
				
			}
		}
		return "emcp/user-register-success";
	}
	
	/**
     * This method will provide the medium to update an existing user.
	 * @throws Exception 
     */
	@RequestMapping(value = { "/user/findById-{id}" }, method = RequestMethod.GET)
	public String getEditUserForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		User user = userService.getUserById(id);

		//baseAttributerForUserForm(model, userToEdit );
		model.addAttribute("editMode","true");
		model.addAttribute("passwordForm",new ChangePasswordForm(id));
        return "emcp/user-register";
    }
     
    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     * @throws Exception 
     */
	 @RequestMapping(value = { "/user/update" }, method = RequestMethod.POST)
	public String postEditUserForm(@Valid @ModelAttribute("userForm")User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			//baseAttributerForUserForm(model, user, TAB_FORM );
			model.addAttribute("editMode","true");
			model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
		}else {
			try {
				userService.updateUser(user);
				//baseAttributerForUserForm(model, new User(), TAB_LIST );
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				
				//baseAttributerForUserForm(model, user, TAB_FORM );
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
				model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
			}
		}
        
        return "emcp/user-update-success";
    }
 
 
     
    /**
     * This method will delete an user by it's ID value.
     * @throws UsernameOrIdNotFound 
     */
	
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) throws UsernameOrIdNotFound {
        userService.deleteUser(id);
        return "redirect:/userlist";
    }
	
	@PostMapping("/editUser/changePassword")
	public ResponseEntity postEditUseChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		try {
			if( errors.hasErrors()) {
				String result = errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}

	
	    //user profile handler
		@GetMapping("/profile")
		public String yourProfile(Model model,Principal principal) {
			String un = principal.getName();
			model.addAttribute("user",userService.getUserByUsername(un) );
			System.out.println(un);
			
			return "emcp/profile";
			
		}
	
	
}