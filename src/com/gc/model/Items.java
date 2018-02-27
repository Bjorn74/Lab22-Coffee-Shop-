package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="item")
public class Items {
	
	private int itemID;
	private String itemName;
	private String itemDesc;
	private double itemPrice;
	
	
	public Items() {
	}


	public Items(int itemID, String itemName, String itemDesc, double itemPrice) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
	}

	@Id
	@GeneratedValue
	@Column(name="itemID")
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	@Column(name="itemName")
	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name="itemDesc")
	public String getItemDesc() {
		return itemDesc;
	}


	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Column(name="itemPrice")
	public double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
	

}
