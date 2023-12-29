package com.ims.pojo;


public class Category  {
	private int c_id;
	private String c_name;
	private String c_detail;
//	private List<SubCat> subCategories;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Category(int c_id, String c_name, String c_detail) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_detail = c_detail;
	}


	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_detail() {
		return c_detail;
	}

	public void setC_detail(String c_detail) {
		this.c_detail = c_detail;
	}
}
	
//	public Category(int cId, String cName) {
////			List<SubCat> subCategories
//
//		super();
//		this.cId = cId;
//		CName = cName;
////		this.subCategories = subCategories;
//	}
//	public int getcId() {
//		return cId;
//	}
//	public void setcId(int cId) {
//		this.cId = cId;
//	}
//	public String getCName() {
//		return CName;
//	}
//	public void setCName(String cName) {
//		CName = cName;
//	}
//	public List<SubCat> getSubCategories() {
//		return subCategories;
//	}
//	public void setSubCategories(List<SubCat> subCategories) {
//		this.subCategories = subCategories;
//	}
	
	

