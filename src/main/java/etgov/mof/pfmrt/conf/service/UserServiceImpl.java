package etgov.mof.pfmrt.conf.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import etgov.mof.pfmrt.conf.dao.UserRepository;
import etgov.mof.pfmrt.conf.exception.CustomeFieldValidationException;
import etgov.mof.pfmrt.conf.exception.UsernameOrIdNotFound;
import etgov.mof.pfmrt.conf.util.ChangePasswordForm;
import etgov.mof.pfmrt.conf.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}
	
	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = repository.findByUsername(user.getUsername());
		if (userFound.isPresent()) {
			throw new CustomeFieldValidationException("Username not available","username");
		}
		return true;
	}

	private boolean checkPasswordValid(User user) throws Exception {
		if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new CustomeFieldValidationException("Confirm Password is required","confirmPassword");
		}
		
		if ( !user.getPassword().equals(user.getConfirmPassword())) {
			throw new CustomeFieldValidationException("Password and Confirm Password are not the same","password");
		}
		return true;
	}


	@Override
	public User createUser(User user) throws Exception {
		if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
			String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			user = repository.save(user);
		}
		return user;
	}

	@Override
	public User getUserById(Long id) throws UsernameOrIdNotFound {
		return repository.findById(id).orElseThrow(() -> new UsernameOrIdNotFound("User id does not exist."));
	}

	@Override
	public User updateUser(User fromUser) throws Exception {
		User toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);
		return repository.save(toUser);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapUser(User from,User to) {
		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setRoles(from.getRoles());
		to.setStatus(from.isStatus());
	}

	@Override
	//@PreAuthorize("hasAnyRole(ADMIN)")
	public void deleteUser(Long id) throws UsernameOrIdNotFound {
		User user = getUserById(id);
		repository.delete(user);
	}

	
	
	@Override
	public User changePassword(ChangePasswordForm form) throws Exception {
		User user = getUserById(form.getId());
		
		if ( !isLoggedUserADMIN() && !user.getPassword().equals(form.getPassword())) {
			throw new Exception ("Current Password is invalid.");
		}
		
		if( user.getPassword().equals(form.getNewPassword())) {
			throw new Exception ("New must be different from the current password.");
		}
		
		if( !form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception ("New Password and Confirm Password do not match.");
		}
		
		String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
		user.setPassword(encodePassword);
		return repository.save(user);
	}
	
	private boolean isLoggedUserADMIN() {
		//Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserDetails loggedUser = null;
		Object roles = null;

		//Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;

			roles = loggedUser.getAuthorities().stream()
					.filter(x -> "ROLE_ADMIN".equals(x.getAuthority())).findFirst()
					.orElse(null); 
		}
		return roles != null ? true : false;
	}
	
	private User getLoggedUser() throws Exception {
		//Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserDetails loggedUser = null;

		//Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;
		}
		
		User myUser = repository
				.findByUsername(loggedUser.getUsername()).orElseThrow(() -> new Exception("Error getting the user logged in from the session."));
		
		return myUser;
	}

	
	//for user profile
	//public User findByUsername(String un) {
		// TODO Auto-generated method stub
		//return repository.getUserByUsername(un);
		
	//}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return repository.getUserByUsername(username);
	}
	
	
}
