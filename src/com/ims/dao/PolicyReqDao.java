package com.ims.dao;

import java.util.List;

import com.ims.pojo.Policy;
import com.ims.pojo.PolicyReq;
import com.ims.pojo.User;

public interface PolicyReqDao {
	void policyreq_list(List<PolicyReq> prList, User user);
	List<PolicyReq> apply_policy(List<PolicyReq> prList, List<Policy> pList, User u);
	List<PolicyReq> edit_policy(List<PolicyReq> prList, int req);

}
