package com.ims.dao;

import java.util.List;

import com.ims.pojo.Category;
import com.ims.pojo.Policy;
import com.ims.pojo.PolicyReq;
import com.ims.pojo.SubCat;

public interface CategoryDao {
	List<Category> add_category(List<Category> categories);
	void category_list(List<Category> categories);
	List <Category> edit_category(List<Category> c_name);
	List <Category> dlt_category (List<Category> categories);

	
	
//	void subcat_list ();
//	List<SubCat> add_subcat(Category category);
//	List<SubCat> edit_subcat(Category category);
//	List<SubCat> dlt_subcat (String sc_name);
//	
//	List<Policy> add_policy();
//	void policy_list(List<Policy> policies);
//	List<Policy> edit_policy(String p_name);
//	List<Policy> dlt_policy(String p_name);
	
//	void policyreq_list(List<PolicyReq> req_lists);
//	void apply_policy(String p_name);
//	void edit_policy(PolicyReq p_req);
	
	
	

}
