package com.neu.edu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="product_catalog_table")
public class ProductCatalog{
	
	@Id
	@Column(name="product_catalog_ID")
	private Integer productCatalogID;
	
	
	@Column(name="product_catalog_desc")
	private String productCatalogDesc;
	
	@Transient
	private String productType;
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy="productCatalog")
	private Set<Product> products = new HashSet<Product>();
	
	public ProductCatalog(String productCatalogDesc,Set<Product> products){
		this.productCatalogDesc = productCatalogDesc;
		this.products = products;
	}
	
	public ProductCatalog(){
		
	}

	public Integer getProductCatalogID() {
		return productCatalogID;
	}

	public void setProductCatalogID(Integer productCatalogID) {
		this.productCatalogID = productCatalogID;
	}

	public String getProductCatalogDesc() {
		return productCatalogDesc;
	}

	public void setProductCatalogDesc(String productCatalogDesc) {
		this.productCatalogDesc = productCatalogDesc;
	}


	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	
}
