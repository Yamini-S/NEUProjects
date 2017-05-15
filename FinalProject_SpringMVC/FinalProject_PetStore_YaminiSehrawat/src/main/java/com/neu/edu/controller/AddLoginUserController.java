package com.neu.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.LoginUserDAO;
import com.neu.edu.exception.AddException;
import com.neu.edu.model.LoginUser;
import com.neu.edu.model.Role;

@Controller
public class AddLoginUserController {
	
	@Autowired
	private LoginUserDAO loginUserDao;
	
	@Autowired
	@Qualifier("validator")
	LoginUserValidator validator;
	
	@Autowired
	@Qualifier("loginValidator")
	LoginFormValidator loginValidator;
	
	@InitBinder("validator")
	private void initUserBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@InitBinder("loginValidator")
	private void initLoginBinder(WebDataBinder binder) {
		binder.setValidator(loginValidator);
	}

	
	//Register new user
	@RequestMapping(value ="/addLoginUser", method = RequestMethod.GET)
	protected String doSubmitAction(Model model,@ModelAttribute("loginUser") LoginUser loginUser,BindingResult result,HttpServletRequest request)
	          throws Exception{
		validator.validate(loginUser, result);
		if(result.hasErrors()){
			return "login";
		}

		
		try {
			System.out.print("test");			
			
			Role role = new Role();
			if (loginUser.getRoleType().equals("seller"))
			{
				role.setRoleId("seller");
				role.setRoleType("seller");
			} else {
				role.setRoleId("customer");
				role.setRoleType("customer");
			}
				
			System.out.print("test");			
			
			role.setUsername(loginUser.getUsername());
			loginUser.getRole().add(role);
						
			loginUserDao.addLoginUser(loginUser);
			System.out.print("test1");			
			
			// DAO.close();
		} catch (AddException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "registrationConfirm";
	}
	
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String enter(Model model, HttpServletRequest request, HttpServletResponse response){
		
		model.addAttribute("loginUser", new LoginUser());
		
		return "login";
	}
	
	
	// error login
	@RequestMapping(value ="/errorLogin", method = RequestMethod.GET)
	public String returnLogin(Model model, HttpServletRequest request, HttpServletResponse response){
	//	LoginUser loginUser = new LoginUser();
		model.addAttribute("loginUser", new LoginUser());
		
		return "login";
	}
	
	
	
	// Login
	@RequestMapping(value="/signInUser", method = RequestMethod.GET)  
	 public String doLoginAction(Model model, @ModelAttribute("loginUser")LoginUser loginUser,HttpServletRequest request,BindingResult results)
	{
		
        loginValidator.validate(loginUser, results);
		if(results.hasErrors()){
			return "login";
		}
		
		HttpSession session = request.getSession();
		try{
		LoginUser user = loginUserDao.getLoginUser(loginUser.getUsername(),loginUser.getPassword());
	//	request.setAttribute("loginUser", loginUser);
		if(user!=null){
		session.setAttribute("userSession", user);
		model.addAttribute("loginUser", loginUser);
		session.setAttribute("loginUserName", loginUser.getUsername());
		List roles = user.getRole();
		Role role = (Role) roles.get(0);		
			if(role.getRoleType().equals("seller")){
				return "forward:/loadAddProduct";
			}
			else if(role.getRoleType().equals("customer")){
				return "forward:/loadProductCatalog";
			}
			
		  }
		else{
			return "error";
		}
		}catch (AddException e) {
		System.out.println("Exception: " + e.getMessage());
    	}
		

		return "forward:/loadProductCatalog";

	}
	
	
	
	//Logout
	
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		LoginUser loginUser = new LoginUser();
        model.addAttribute("loginUser",loginUser);
        return "login";
		
	}
	
	//Initialization

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("loginUser") LoginUser loginUser) {

		return "login";
	}
	
	
	@RequestMapping(value = "/checkUniqueUsername", method = RequestMethod.GET , produces="application/text")
	public String checkUniqueUserName(HttpServletRequest request, HttpServletResponse response){
		String userName = request.getParameter("username");
		boolean results = loginUserDao.checkLoginUser(userName);
		
		if(results == true)
		{
			return "true";
		}
		else
		{
			return "false";
		}
	}
	
	
	
}
