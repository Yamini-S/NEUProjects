package com.neu.edu.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.neu.edu.model.Product;

public class AddProductValidator implements Validator{


	//private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
	
	public boolean supports(Class bClass) {
		
		return bClass.equals(Product.class);
	}

	public void validate(Object object, Errors error) {
		
	    Product product = (Product)object;
		
		
        
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "productName", "error.invalid.product","Product Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "productPrice", "error.invalid.product","Product Price Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "productDesc", "error.invalid.product","Product Description Required");
		
		
		if(product.getPhoto().getSize()==0){
			error.rejectValue("file", "required.fileUpload");
		}
	}

}
