package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	private int userID;
	private String userName;
	private String password;
	
	
	public User() {
	}


	public User(int userID, String userName, String password) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
	}

	@Id
	@GeneratedValue
	@Column(name="userID")
	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Column(name="userName")
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
