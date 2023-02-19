package com.authentication.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
//	MEMBERS
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    
//  CONSTRUCTOR
    public LoginUser() {}

    
//  GETTERS
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
//	SETTERS
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
