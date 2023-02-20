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
//		1.find user in the db by email
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		
//		2. if the email is present, reject
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "unique", "Email is already registered, please login");
		}
		
//		3. reject if password doesn't match confirm
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password does not match");
		}
		
//		4. if result has errors, return
		if(result.hasErrors()) {
			return null;
		}
		
//		hash and set password, save use to db (HpSpSu)
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()); //hash pass
		newUser.setPassword(hashed);//set pass
		userRepo.save(newUser);//save user
		
//		return to controller after validations
		return newUser;
	}
	
    public User login(LoginUser newLogin, BindingResult result) {
//    	1. find user by email in db    	
    	Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());

//    	2. if the email is not present reject
		if(!optionalUser.isPresent()) {
			result.rejectValue("email", "Unknown", "Email is not registered, please register");
			return null;
		}
		
//    	3.1 grab the user from potential user
		User user = optionalUser.get();
//    	3.2 if bcrypt password match fails
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) { // input first, db second
		    result.rejectValue("password", "Matches", "Invalid Password");
		}
		
//    	4. if result has errors, return
		if(result.hasErrors()) {
			return null;
		}
		
//    	otherwise, return the user object    	
        return user;
    }
}
