package com.ims.pojo;

public class SubCat {
	private int sc_id;
	private Category category;
	private String sc_name;
	private String details;
	
	public SubCat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubCat(int sc_id, Category category, String sc_name, String details) {
		super();
		this.sc_id = sc_id;
		this.category = category;
		this.sc_name = sc_name;
		this.details = details;
	}

	public int getSc_id() {
		return sc_id;
	}

	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSc_name() {
		return sc_name;
	}

	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
	
	

//	public int getScId() {
//		return scId;
//	}
//
//	public void setScId(int scId) {
//		this.scId = scId;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//	public String getScName() {
//		return scName;
//	}
//
//	public void setScName(String scName) {
//		this.scName = scName;
//	}
//
//	public String getDetails() {
//		return details;
//	}
//
//	public void setDetails(String details) {
//		this.details = details;
//	}
//	
//
////	public SubCat(int scId, String scName, double price) {
////		super();
////		this.scId = scId;
////		this.scName = scName;
////		this.price = price;
////	}
////
////	public int getScId() {
////		return scId;
////	}
////
////	public void setScId(int scId) {
////		this.scId = scId;
////	}
////
////	public String getScName() {
////		return scName;
////	}
////
////	public void setScName(String scName) {
////		this.scName = scName;
////	}
////
////	public double getPrice() {
////		return price;
////	}
////
////	public void setPrice(double price) {
////		this.price = price;
////	}
////	
//	
//	
//
//}
