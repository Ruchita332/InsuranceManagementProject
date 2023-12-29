package com.ims.pojo;

public class PolicyReq {
	private User user;
	private Category category;
	private SubCat sub_category;
	private Policy policy;
	private int req;
	private String status;
	public PolicyReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PolicyReq(User user, Policy policy) {
		super();
		this.user = user;
		this.category = policy.getCategory();
		this.sub_category = policy.getSub_category();
		this.policy = policy;
		this.req = 1;
		this.setStatus(req);
		
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public SubCat getSub_category() {
		return sub_category;
	}
	public void setSub_category(SubCat sub_category) {
		this.sub_category = sub_category;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public int getReq() {
		return req;
	}
	public void setReq(int req) {
		this.req = req;
		this.setStatus(req);
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(int req) {
		switch(req) {
		case 1:
			this.status = "PENDING";
			break;
		case 2: this.status = "ACTIVE";
		break;
		case 3: this.status = "CANCELLED";
			
		}
	}
	

}
