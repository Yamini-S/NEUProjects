package com.neu.edu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.neu.edu.dao.AddProductDAO;
import com.neu.edu.exception.AddException;
import com.neu.edu.model.Product;
import com.neu.edu.model.ProductCatalog;

@Controller
public class AddProductController {
	

	@Autowired
	private AddProductDAO addProductDao;
	
	@Autowired
	AddProductValidator productValidator;
	
	@InitBinder
	private void initbinder(WebDataBinder binder){
		binder.setValidator(productValidator);
	}

		
	@RequestMapping(value="/loadAddProduct" ,method=RequestMethod.GET)
	public String loadAddProduct(Model model){
		Product product =  new Product();
		model.addAttribute("product",product);		
		return "selleraddproducts";
	}

	@RequestMapping(value ="/addProducts",method = RequestMethod.POST)
    protected String dosubmitAction(Model model, @ModelAttribute("product")Product product,BindingResult result,HttpServletRequest request)
	throws Exception{
		
		productValidator.validate(product, result);
		if(result.hasErrors()){
			return "selleraddproducts";
		}


		File file;
		ServletContext servletContext = request.getSession().getServletContext();

		try{
			System.out.println("test");
			
			ProductCatalog prodCatalog = new ProductCatalog();
			if(product.getProductType().equals("Dogs")){
				prodCatalog.setProductCatalogID(1);
				prodCatalog.setProductCatalogDesc("Dogs");
				
			} else if(product.getProductType().equals("Cats")){
				prodCatalog.setProductCatalogID(2);
				prodCatalog.setProductCatalogDesc("Cats");
			}
			
			Product product1 = new Product(prodCatalog, product.getProductName(),product.getProductDesc(),product.getProductPrice(),product.getPhoto());
			prodCatalog.getProducts().add(product1);
			
			String check = File.separator;
			String path = null;
			if(check.equalsIgnoreCase("\\")){
				path = servletContext.getRealPath("").replace("build\\","");
			}
			
			 if(check.equalsIgnoreCase("/")) {
			       path = servletContext.getRealPath("").replace("build/","");
			       path += "/"; //Adding trailing slash for Mac systems.
	        }
			
			if(product.getPhoto()!=null){
				String fileNameWithExt = product.getPhoto().getOriginalFilename();
        		file = new File(path + fileNameWithExt);
				String context = servletContext.getContextPath();
				
			    product.getPhoto().transferTo(file);
                product1.setPhotoName(context + "/" + fileNameWithExt);
			}

			//addProductDao.getProductCatalogByDesc(productCatalogDesc);
			addProductDao.createProductCatalog(prodCatalog);
			product1.setProductCatalog(prodCatalog);
			addProductDao.createProduct(product1);
		
			
		} catch (AddException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "addedProduct";
		
	}
	
	@RequestMapping(value ="/addMoreProduct",method = RequestMethod.POST)
	public String addMore(Model model,HttpServletRequest request){
		Product product = new Product();
		model.addAttribute("product",product);
		request.setAttribute("product", product);
		return "selleraddproducts";
	}

}
