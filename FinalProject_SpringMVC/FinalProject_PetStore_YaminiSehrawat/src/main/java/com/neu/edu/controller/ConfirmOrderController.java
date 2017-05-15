package com.neu.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.model.LoginUser;
import com.neu.edu.model.Order;

public class ConfirmOrderController {
	
//	@RequestMapping(value = "/orderSummary", method = RequestMethod.GET)
//	public String orderSummary(Model model,HttpServletRequest request){
//		HttpSession session = request.getSession();
//		LoginUser loginUser = (LoginUser)session.getAttribute("userSession");
//		Order orderInfo = (Order)session.getAttribute("orderInfo");
//		request.setAttribute("orderInfo", orderInfo);
//		session.setAttribute("orderSummarySession", orderInfo);
//		model.addAttribute("orderSummaryInfo", orderInfo);
//		return "orderSummary";
//		
//	}
	
//	@RequestMapping(value = "/confirmOrder", method = RequestMethod.GET)
//	public String confirmOrder(Model model, HttpServletRequest request){
//		HttpSession session = request.getSession();
//		LoginUser loginUser = (LoginUser)session.getAttribute("userSession");
//		Order orderInfo = (Order)session.getAttribute("orderInfo");
//		request.setAttribute("orderInfo", orderInfo);
//		return "confirmedOrder";
//		
//	} 

}
