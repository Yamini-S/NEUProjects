package com.neu.edu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductOrder {
	
	@Column(name="OFFER_ID")
	private Integer offerId;
	
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	@Column(name="PROD_NAME")
	private String prodName;
	
	@Column(name="PRICE")
	private Integer price;
	
	@Column(name="PROD_DESC")
	private String prodDesc;

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	
	
	

}
