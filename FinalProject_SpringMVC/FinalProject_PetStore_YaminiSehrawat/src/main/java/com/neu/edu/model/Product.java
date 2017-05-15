package com.neu.edu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="Product_table")
public class Product implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_ID")
	private Integer productId;
	
	@Column(name="product_desc")
	private String productDesc;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private Integer productPrice;
	

	@Transient
	private MultipartFile photo;
	
	@Column(name="product_photoName")
	private String photoName;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productCatalogID",nullable=false)
	private ProductCatalog productCatalog;
	
	@Transient
	private String productType;
	
//	@ElementCollection(fetch = FetchType.EAGER)
//	@JoinTable(name = "productcatalog_table",joinColumns =@JoinColumn(name="product_ID"))
//	private List<ProductCatalog> productCatalogList =  new ArrayList<ProductCatalog>();

	
	public Product(){
		
	}

	public Product(ProductCatalog productCatalog,String productName,String productDesc, Integer productPrice){
		this.productCatalog = productCatalog;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}
	
	public Product(ProductCatalog productCatalog,String productName,String productDesc, Integer productPrice,MultipartFile photo){
		this.productCatalog = productCatalog;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.photo = photo;
	}
	

	
	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getProductDesc() {
		return productDesc;
	}


	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Integer getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


//	public List<ProductCatalog> getProductCatalogList() {
//		return productCatalogList;
//	}
//
//
//	public void setProductCatalogList(List<ProductCatalog> productCatalogList) {
//		this.productCatalogList = productCatalogList;
//	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public ProductCatalog getProductCatalog() {
		return productCatalog;
	}

	public void setProductCatalog(ProductCatalog productCatalog) {
		this.productCatalog = productCatalog;
	}
	
	
	

}
