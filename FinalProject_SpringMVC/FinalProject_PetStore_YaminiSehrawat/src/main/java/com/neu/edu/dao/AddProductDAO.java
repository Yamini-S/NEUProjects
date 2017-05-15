package com.neu.edu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.AddException;
import com.neu.edu.model.Product;
import com.neu.edu.model.ProductCatalog;

public class AddProductDAO extends DAO{
	
	public AddProductDAO(){
		
	}
	
	public ProductCatalog createProductCatalog(ProductCatalog productCatalog) throws Exception{
		try{
			System.out.print("testDAo");			
			
			begin();				
			getSession().saveOrUpdate(productCatalog);			
			
			commit();
			return productCatalog;
		}catch (HibernateException e) {
			rollback();
			throw new AddException("Exception while creating product: " + e.getMessage());
		}
	}
	
	public List<ProductCatalog> getProductCatalogByDesc(String productCatalogDesc) throws Exception{
		try{
			System.out.print("testDAo");			
			
			begin();
			Query q = getSession().createQuery("from ProductCatalog where productCatalogDesc = :productCatalogDesc");
			q.setString("productCatalogDesc", productCatalogDesc);
			List<ProductCatalog> productCatalog = q.list();
			return productCatalog;
		}catch (HibernateException e) {
			rollback();
			throw new AddException("Exception while creating product: " + e.getMessage());
		}
	}
	
	
	
	public Product createProduct(Product product) throws Exception{
		try{
			System.out.print("testDAo");			
			
			begin();				
			getSession().save(product);			
			
			commit();
			return product;
		}catch (HibernateException e) {
			rollback();
			throw new AddException("Exception while creating product: " + e.getMessage());
		}
	}
	
	public List<Product> getProductListByID(Integer productId){
		
		try{
			begin();
			Query q = getSession().createQuery("from Product where productId = :productId");
			q.setString("productId", String.valueOf(productId));
			List<Product> products = q.list();
			return products;
           }catch(HibernateException e){
        	   e.printStackTrace();
           }
		return null;
		
	}
	
    public List<Product> getProductListByName(String productName){
		
		try{
			begin();
			Query q = getSession().createQuery("from Product where productName = :productName");
			q.setString("productName", productName);
			List<Product> products = q.list();
			return products;
           }catch(HibernateException e){
        	   e.printStackTrace();
           }
		return null;
		
	}
	
	
    public List<Product> getProductListByproductCatalogID(Integer productCatalogID){
		
		try{
			begin();
			Query q = getSession().createQuery("from Product where productCatalogID = :productCatalogID");
			q.setString("productCatalogID", String.valueOf(productCatalogID));
			List<Product> products = q.list();
			return products;
           }catch(HibernateException e){
        	   e.printStackTrace();
           }
		return null;
		
	 }
	
    public List<Product> getAllProducts(){
		
		try{
			begin();
			Criteria crit = getSession().createCriteria(Product.class);
			//Query q = getSession().createQuery("from Product");
			List<Product> productList = crit.list();
			return productList;
           }catch(HibernateException e){
        	   e.printStackTrace();
           }
		return null;
		
	}
	
	public List<ProductCatalog> getProductCatalogList(){
		try{
			Query q = getSession().createQuery("from ProductCatalog");
			List<ProductCatalog> productCatalogList = q.list();
			return productCatalogList;
		}catch(HibernateException e){
     	   e.printStackTrace();
        }
		return null;
	}
	
	public void deleteProduct(Product product) throws Exception{
		try{
			begin();
			getSession().delete(product);
			commit();
		}catch (HibernateException e) {
			rollback();
			throw new AddException("Could not delete product " + e);
		}
	}

}
