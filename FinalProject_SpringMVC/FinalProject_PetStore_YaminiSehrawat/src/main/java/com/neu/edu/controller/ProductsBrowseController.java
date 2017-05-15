package com.neu.edu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.model.LoginUser;
import com.neu.edu.model.Order;
import com.neu.edu.dao.AddProductDAO;
import com.neu.edu.dao.OrderDAO;
import com.neu.edu.model.Product;
import com.neu.edu.model.ProductOrder;
import com.neu.edu.model.ShoppingCart;
import com.neu.edu.model.ShoppingCartList;

@Controller
public class ProductsBrowseController {
	
	@Autowired
	AddProductDAO addProductDao;
	
	@Autowired
	ShoppingCart shoppingCart;
	
	@Autowired
	ShoppingCartList shoppingCartList;
	
	@Autowired
	OrderDAO orderDao;
	
//	@RequestMapping(value="/loadProductCatalog" ,method=RequestMethod.GET)
//	public String loadProductCatalog(Model model,HttpServletRequest request){
//		List<Product> productList =  addProductDao.getAllProducts();
//		//ShoppingCart shoppingCart = new ShoppingCart();
//		//model.addAttribute("shoppingCart",shoppingCart);
//		request.setAttribute("productList", productList);
//		return "forward:/loadShoppingCart";
//	}
	
	
	@RequestMapping(value="/loadProductCatalog" ,method=RequestMethod.GET)
	public String loadShoppingCart(Model model,HttpServletRequest request){
		List<Product> productList =  addProductDao.getAllProducts();
		ShoppingCart shoppingCart = new ShoppingCart();		
		model.addAttribute("shoppingCart",shoppingCart);
		request.setAttribute("productList", productList);
		return "productBrowsing";
	}
	
	@RequestMapping(value="/addToCart", method = RequestMethod.GET)
	public String addToCart(Model model, HttpServletRequest request ){
		String productID = request.getParameter("productID");	
		String catProductId = request.getParameter("catProductID");
		if (catProductId != null && !catProductId.isEmpty()){
			productID = catProductId;
		}
		
		HttpSession session = request.getSession();
		//ShoppingCartList myCartList =  (ShoppingCartList)session.getAttribute("cartList");		
		if(productID !=null && !shoppingCartList.isAlreadyAdded(productID)){
			ShoppingCart shoppingCart = makeShoppingCartProduct(Integer.parseInt(productID));
			shoppingCartList.addShoppingCart(shoppingCart);
		}
		shoppingCartList.shoppingCartTotal();
		session.setAttribute("cartList", shoppingCartList);
		model.addAttribute("scl",shoppingCartList);
		return "forward:/loadProductCatalog";
		
	}
	
	@RequestMapping(value="/RemoveCart", method = RequestMethod.GET)
	public String deleteCart(Model model, HttpServletRequest request ){
		String removeID = request.getParameter("removeProductID");
		HttpSession session = request.getSession();
		//ShoppingCartList cartList =  (ShoppingCartList)session.getAttribute("cartList");
		
		if(removeID !=null){
			shoppingCartList.deleteFromShoppingCart(removeID);
			shoppingCartList.shoppingCartTotal();
		}
	//	HttpSession session = request.getSession();
	//	session.removeAttribute("cartList");
		model.addAttribute("shoppingCart",shoppingCart);
		session.setAttribute("cartList", shoppingCartList);
		model.addAttribute("scl",shoppingCartList);
		return "forward:/loadProductCatalog";

	}
	
	
	@RequestMapping(value="/RemoveShoppingCart", method = RequestMethod.POST)
	public String deleteShoppingCart(Model model, ShoppingCart shoppingCart, HttpServletRequest request ){
		model.addAttribute("shoppingCart",shoppingCart);
		shoppingCartList.deleteFromShoppingCart(shoppingCart.getProductName());
		shoppingCartList.shoppingCartTotal();
		HttpSession session = request.getSession();
		session.removeAttribute("cartList");
		session.setAttribute("cartList", shoppingCartList);
		model.addAttribute("scl",shoppingCartList);
		return "viewShoppingCart";

	}
	
	@RequestMapping(value="/viewShoppingCart", method = RequestMethod.GET)
	public String shoppingCart(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("shoppingCart",shoppingCart);
		ShoppingCartList shoppingCartList = (ShoppingCartList)session.getAttribute("cartList");
		model.addAttribute("scl",shoppingCartList);
		return "viewShoppingCart";
    }
	
	@RequestMapping(value = "/Checkout", method = RequestMethod.GET)
	public String checkOut(Model model, HttpServletRequest request) throws Exception{
		String price = request.getParameter("TotalPrice");
		if(price!=null){
			Order order = prepareOrderTable(request);
		try{
			Order order1 = orderDao.createOrder(order);
			if(order1.getOrderId()!=null){
				request.getSession().setAttribute("orderInfo", order1);
				return "forward:/orderSummary";
			}
		}catch(HibernateException hibernateException){
			hibernateException.printStackTrace();
		}	
		return "productBrowsing";
	    }
	    else{
	    	return "forward:/orderSummary";
	    }
      }
	
	@RequestMapping(value = "/orderSummary", method = RequestMethod.GET)
	public String getOrderSummary(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("userSession");
		Order orderInfo = (Order)session.getAttribute("orderInfo");
		request.setAttribute("orderInfo", orderInfo);
		session.setAttribute("orderSummarySession", orderInfo);
		model.addAttribute("orderSummaryInfo", orderInfo);
		return "orderSummary";
		
	}
	
	@RequestMapping(value = "/confirmOrder", method = RequestMethod.GET)
	public String confirmOrder(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("userSession");
		session.removeAttribute("cartList");
		shoppingCartList.getShoppingCartList().clear();
//		Order orderInfo = (Order)session.getAttribute("orderInfo");
//		request.setAttribute("orderInfo", orderInfo);
		return "confirmedOrder";
		
	} 
	
	@RequestMapping(value = "/newShoppingCart", method = RequestMethod.GET)
	public String newShopping(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("userSession");
		//ShoppingCart shoppingCart = new ShoppingCart();
		return "forward:/loadProductCatalog";
		
	} 
	
	@RequestMapping(value = "/productSearch", method = RequestMethod.GET)
	public String searchProduct(Model model, HttpServletRequest request){
		String key = request.getParameter("keyword");
		String searchOption = request.getParameter("search");
	//	Product prod = new Product();
		List<Product> prodList = null;
		
			if(searchOption.equals("byID")){
				prodList = addProductDao.getProductListByID(Integer.parseInt(key));
				
			}else if(searchOption.equals("byName")){
			       prodList = addProductDao.getProductListByName(key);
			}
			
		request.setAttribute("prodList", prodList);
		return "searchProduct";
	}
	
	private Order prepareOrderTable(HttpServletRequest request){
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("userSession");
		int userId = loginUser.getUserId();
		ShoppingCartList shoppingCartList = (ShoppingCartList)session.getAttribute("cartList");
		
		Order order = new Order();
		order.setCreationDate(new Date());
		order.setOrderDescription("order is placed by " + userId);
		order.setUserId(userId);
		order.setStatus("Proceed To Confirm");
		List<ProductOrder> offerList = new ArrayList<ProductOrder>();
		for(ShoppingCart cart:shoppingCartList.getShoppingCartList()){
			ProductOrder productOrder = new ProductOrder();
			productOrder.setOfferId(cart.getProductId());
			productOrder.setProdName(cart.getProductName());
			productOrder.setProdDesc(cart.getProductDesc());
			productOrder.setPrice(cart.getProductPrice());
			productOrder.setCreationDate(order.getCreationDate());
			offerList.add(productOrder);
			
		}
		order.setOfferList(offerList);
		return order;
	}
	
	private ShoppingCart makeShoppingCartProduct(Integer productID){
		List<Product> productList =  addProductDao.getProductListByID(productID);
		ShoppingCart shop = new ShoppingCart();
		for (Product prod : productList){
			shop.setProductId(prod.getProductId());
			shop.setProductName(prod.getProductName());
			shop.setProductDesc(prod.getProductDesc());
			shop.setProductPrice(prod.getProductPrice());
			shop.setPhotoName(prod.getPhotoName());
		}
		return shop;
	}
	
	
	
}
