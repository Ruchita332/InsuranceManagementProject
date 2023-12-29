package com.ims.pojo;

public class Policy {
	private int p_id;
	private Category category;
	private SubCat sub_category;
	private String policy_name;
	private double sum_Assured;
	private double premium;
	private int tenure;
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policy(int p_id, Category category, SubCat sub_category, String policy_name, double sum_Assured,
			double premium, int tenure) {
		super();
		this.p_id = p_id;
		this.category = category;
		this.sub_category = sub_category;
		this.policy_name = policy_name;
		this.sum_Assured = sum_Assured;
		this.premium = premium;
		this.tenure = tenure;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
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
	public String getPolicy_name() {
		return policy_name;
	}
	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}
	public double getSum_Assured() {
		return sum_Assured;
	}
	public void setSum_Assured(double sum_Assured) {
		this.sum_Assured = sum_Assured;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	
	
}
