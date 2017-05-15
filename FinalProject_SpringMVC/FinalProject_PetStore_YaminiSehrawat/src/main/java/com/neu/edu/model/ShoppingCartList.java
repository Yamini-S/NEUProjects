package com.neu.edu.model;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCartList {
	
	private int totalPrice;
	private ArrayList<ShoppingCart> shoppingCartList;
	
	public ShoppingCartList(){
		shoppingCartList = new ArrayList<ShoppingCart>();
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ArrayList<ShoppingCart> getShoppingCartList() {
		return shoppingCartList;
	}
	public void setShoppingCartList(ArrayList<ShoppingCart> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}
	
	public void addShoppingCart(ShoppingCart shoppingCart){
		shoppingCart.setProductId(shoppingCart.getProductId());
		shoppingCart.setProductName(shoppingCart.getProductName());
        shoppingCart.setProductDesc(shoppingCart.getProductDesc());
        shoppingCart.setPhotoName(shoppingCart.getPhotoName());
        shoppingCart.setProductPrice(shoppingCart.getProductPrice());
        shoppingCartList.add(shoppingCart);
	}
	
	public void deleteFromShoppingCart(String removeProductID){
		Iterator<ShoppingCart> itr = shoppingCartList.iterator();
		while(itr.hasNext()){
			ShoppingCart sCart = itr.next();
			if(sCart.getProductId().equals(Integer.parseInt(removeProductID))){
				itr.remove();
				
			}
		}
		
		
	}
	
	public void shoppingCartTotal(){
		int total = 0;
		for(ShoppingCart sCart: shoppingCartList){
			if(sCart.getProductId() != null){
				total = total + sCart.getProductPrice();
			}
		}
		totalPrice = total;
	}
	
	public boolean isAlreadyAdded(String productID){
		for(ShoppingCart sCart:shoppingCartList){
			if(sCart.getProductId().equals(productID)){
				return true;
			}
		}return false;
	}
	

}
