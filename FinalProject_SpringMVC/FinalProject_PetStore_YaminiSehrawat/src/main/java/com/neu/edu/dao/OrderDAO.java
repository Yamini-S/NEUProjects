package com.neu.edu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import com.neu.edu.exception.AddException;
import com.neu.edu.model.Order;

public class OrderDAO extends DAO {
	
	
	public Order createOrder(Order order) throws Exception{
		
		try{
			System.out.print("testDAO");			
			
			begin();				
			getSession().save(order);			
			
			commit();
			return order;
		}catch (HibernateException e) {
			rollback();
			throw new AddException("Exception while creating product: " + e.getMessage());
		}
		
	}
	
	public List<Order> getAllOrders(){
		try{
			begin();
			Criteria crit = getSession().createCriteria(Order.class);
			List<Order> orderList = crit.list();
			return orderList;
		}catch(HibernateException e){
     	   e.printStackTrace();
        }
		return null;
		
	}
	
	
	public Order updateOrder(Order order){
		getSession().update(order);
		return order;
	}
	
	public void deleteOrder(int orderId) throws Exception{
		try{
			begin();
			getSession().createQuery("Delete from order where orderId = "+ orderId).executeUpdate();
		}catch (HibernateException e) {
			rollback();
			throw new AddException("Could not delete order " + e);
		}
	}

}
