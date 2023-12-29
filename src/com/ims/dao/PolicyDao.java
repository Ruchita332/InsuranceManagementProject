package com.ims.dao;

import java.util.List;

import com.ims.pojo.Policy;
import com.ims.pojo.SubCat;

public interface PolicyDao {
	List<Policy> add_policy(List<Policy> pList, List<SubCat> scList);
	void policy_list(List<Policy> pList);
	List<Policy> edit_policy(List<Policy>pList, List<SubCat>scList);
	List<Policy> dlt_policy(List<Policy>pList);
	

}
