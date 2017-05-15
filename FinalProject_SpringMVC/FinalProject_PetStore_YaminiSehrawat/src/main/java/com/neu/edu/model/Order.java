package com.neu.edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;


@Entity
@Table(name = "order_table")
public class Order {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "order_Id")
	private Integer orderId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "order_desc")
	private String orderDescription;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "order_status")
	private String status;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="order_product_table",joinColumns=@JoinColumn(name="order_Id"))
	private List<ProductOrder> offerList = new ArrayList<ProductOrder>();


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getOrderDescription() {
		return orderDescription;
	}


	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<ProductOrder> getOfferList() {
		return offerList;
	}


	public void setOfferList(List<ProductOrder> offerList) {
		this.offerList = offerList;
	}
	
	
	
}
