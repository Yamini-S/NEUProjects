package com.neu.edu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.model.LoginUser;

public class LoginFormValidator implements Validator {


	public boolean supports(Class aClass) {
		return aClass.equals(LoginUser.class);
	}


	public void validate(Object obj, Errors errors) {
		LoginUser loginUser = (LoginUser)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","error.invalid.loginUser","username required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","error.invalid.loginUser","password required");
		
	}
	

}
