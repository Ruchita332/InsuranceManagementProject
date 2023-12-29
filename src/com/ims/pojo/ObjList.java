package com.ims.pojo;

import java.util.List;

public class ObjList {
	private List<User> uList;
	private List<Category> cList;
	private List<SubCat> scList;
	private List<Policy> pList;
	private List<PolicyReq> prList;
	public ObjList(List<User> uList, List<Category> cList, List<SubCat> scList, List<Policy> pList,
			List<PolicyReq> prList) {
		super();
		this.uList = uList;
		this.cList = cList;
		this.scList = scList;
		this.pList = pList;
		this.prList = prList;
	}
	public ObjList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<User> getuList() {
		return uList;
	}
	public void setuList(List<User> uList) {
		this.uList = uList;
	}
	public List<Category> getcList() {
		return cList;
	}
	public void setcList(List<Category> cList) {
		this.cList = cList;
	}
	public List<SubCat> getScList() {
		return scList;
	}
	public void setScList(List<SubCat> scList) {
		this.scList = scList;
	}
	public List<Policy> getpList() {
		return pList;
	}
	public void setpList(List<Policy> pList) {
		this.pList = pList;
	}
	public List<PolicyReq> getPrList() {
		return prList;
	}
	public void setPrList(List<PolicyReq> prList) {
		this.prList = prList;
	}
	
	

}
