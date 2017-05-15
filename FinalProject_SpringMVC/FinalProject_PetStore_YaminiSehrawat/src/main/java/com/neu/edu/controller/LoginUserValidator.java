package com.neu.edu.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.model.LoginUser;

public class LoginUserValidator implements Validator {
	
	private Pattern pattern;  
	private Matcher matcher; 
	String MOBILE_PATTERN = "[0-9]{10}"; 
	public boolean supports(Class aClass) {
		return aClass.equals(LoginUser.class);
	}


	public void validate(Object obj, Errors errors) {
		LoginUser loginUser = (LoginUser)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","error.invalid.loginUser","username required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","error.invalid.loginUser","password required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"contactNo","error.invalid.loginUser","contact required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"emailId","error.invalid.loginUser","email required");
		
		if(!(loginUser.getContactNo()!=null && loginUser.getContactNo().isEmpty())){
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(loginUser.getContactNo());
			if(!matcher.matches()){
				errors.rejectValue("contactNo", "contactNo.incorrect","Enter a correct contact number");
			}
			
		}
	}
	
	


}
