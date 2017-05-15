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
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "loginUser_table")
public class LoginUser implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;

	@Column(name="username",unique=true)
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="contactNo")
	private String contactNo; 
	
	@Transient
	private String roleType;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "role_table",joinColumns =@JoinColumn(name="user_id"))
	private List<Role> role =  new ArrayList<Role>();
	
//	@Column(name="enabled")
//	private Integer enabled;
	
	
	public LoginUser(){
		
	}
	
	public LoginUser(String username, String password, String emailId, String contactNo){
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.contactNo = contactNo;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public List<Role> getRole() {
		return role;
	}


	public void setRole(List<Role> role) {
		this.role = role;
	}
	
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}




//	public Integer isEnabled() {
//		return enabled;
//	}
//
//
//	public void setEnabled(Integer enabled) {
//		this.enabled = enabled;
//	}
	
	
	
}
