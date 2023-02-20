package com.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.authentication.models.LoginUser;
import com.authentication.models.User;
import com.authentication.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		// find user in the db by email
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		
		if(optionalUser.isPresent()) { // if the email is present, reject
			result.rejectValue("email", "unique", "Email is already registered, please login");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) { // reject if password doesn't match confirm
			result.rejectValue("confirm", "Matches", "The Confirm Password does not match");
		}
		
		if(result.hasErrors()) { // if result has errors, return
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()); //hash pass
		newUser.setPassword(hashed);//set pass
		userRepo.save(newUser);//save user
		
		return newUser;
	}
	
    public User login(LoginUser newLogin, BindingResult result) {
    	// find user by email in db    	
    	Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());

		if(!optionalUser.isPresent()) { // if the email is not present reject
			result.rejectValue("email", "Unknown", "Email is not registered, please register");
			return null;
		}
		
		User user = optionalUser.get(); // grab the user from potential user
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) { // checkpw(input, DB)
		    result.rejectValue("password", "Matches", "Invalid Password");
		}
		
		if(result.hasErrors()) { // if result has errors, return
			return null;
		}
		    	
        return user;
    }
    
//  RENDER 
    //one
    public User oneUser(Long id) {
    	Optional<User> optionalUser = userRepo.findById(id);
    	if(optionalUser.isPresent()) {
    		return optionalUser.get();
    	}
    	return null;
    }
}
