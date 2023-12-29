package com.ims.dao.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.ims.dao.PolicyReqDao;
import com.ims.dao.impl.PolicyDaoImpl;
import com.ims.dao.impl.UserDaoImpl;
import com.ims.pojo.PolicyReq;
import com.ims.pojo.SubCat;
import com.ims.pojo.User;
import com.ims.pojo.Policy;

public class PolicyReqDaoImpl implements PolicyReqDao {
	
	PolicyDaoImpl pDao = new PolicyDaoImpl();
	UserDaoImpl uDao = new UserDaoImpl();
	
	List<PolicyReq> prList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public List<PolicyReq> loadAdminInfo(List<Policy>pList, List<User>users) {
		Policy p1 = pList.get(0);
		Policy p2 = pList.get(1);
		Policy p3 = pList.get(2);
		User u1 = users.get(1);
		User u2 = users.get(2);
		User u3 = users.get(3);

		
		PolicyReq pr1 = new PolicyReq(u1, p1);
		PolicyReq pr2 = new PolicyReq(u2, p2);
		pr2.setReq(2);
		PolicyReq pr3 = new PolicyReq(u3, p3);
		pr3.setReq(3);

		prList.add(pr1);
		prList.add(pr2);
		prList.add(pr3);

		
		return prList;
	}
	

	@Override
	public void policyreq_list(List<PolicyReq> prList, User user) {
		// TODO Auto-generated method stub
		
			//For Admin
				if (user.getRole().equals("admin")) {

					prList.stream().forEach(
							(pr)-> {
									display_prinfo(pr);
							}
							);
				}
				
				//For Customer
				
				else if (user.getRole().equals("customer")) {
					

				for (PolicyReq pr: prList) {
					String pr_user = pr.getUser().getUsername();
					if (user.getUsername().equals(pr_user)) {
						display_prinfo(pr);
					}
				}
					
					
				}
		
	}

	@Override
	public List<PolicyReq> apply_policy(List<PolicyReq> prList, List<Policy> pList, User u) {
		// TODO Auto-generated method stub
		
		int choice = 1;
		
		while (choice ==1) {
			System.out.print("Select Policy Id: ");
			int p_id = sc.nextInt();
			//Get the policy info
			Policy p = pDao.find_policy(pList, p_id);
			
			//check if p_id is valid
			if ( p == null) {
				//policy doesn't exist
				System.out.println("Error! Invalid Policy Id");
			}
			else {
				//Policy found
				PolicyReq pr = new PolicyReq(u, p);
				prList.add(pr); // Customer has selected a policy and teh request status is pending
				System.out.println("Policy \"" + p.getPolicy_name() + "\" was successfully Requested!\n");

			}
			
			System.out.println();
			System.out.println("Would you like to Request for another Policy?");
			System.out.println ("Please Enter 1 for YES and 2 for NO");
			choice = sc.nextInt();
			System.out.println();
		}
		
		return prList;
		
	}

	@Override
	public List<PolicyReq> edit_policy(List<PolicyReq> prList, int req) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Policy Id ");
		int pr_id = sc.nextInt();
		System.out.println("Enter User Id: ");
		int u_id = sc.nextInt();
		
		PolicyReq pr = (find_pr(prList, u_id, pr_id));
		 
		if (pr == null) {
			System.out.println("Error! Invalid Policy Id or User Id\n");
		}
		else {
			//pr found
			int index = prList.indexOf(pr);
			if (req == 2) {
				//Activate request
				pr.setReq(req);
				System.out.println("Policy Req ACTIVATED!\n");
				
				
			}
			else if (req == 3) {
				pr.setReq(req);
				System.out.println("Policy Req CANCELLED!\n");
				
			}
			prList.set(index, pr);
		}
		
		return prList;
		
	}
	
	public void display_prinfo(PolicyReq pr) {
		System.out.println("----------------------------------------------------");	
		System.out.println(" Customer Name: " + pr.getUser().getFirst_name() +" "+ pr.getUser().getLast_name());
		System.out.println(" Category: "  + pr.getCategory().getC_name());                             					
		System.out.println(" SubCategory: "  + pr.getSub_category().getSc_name());                           					
		System.out.println(" Policy Name: "  + pr.getPolicy().getPolicy_name());    					
		System.out.println(" Status: "  + pr.getStatus());
      					
		System.out.println("----------------------------------------------------");	
		System.out.println();
	}
	
	public boolean policyExist (List<Policy>pList, int p_id) {
			if (pDao.isUnique(pList, p_id)) {
				//Id is unique and does't exist in the system
				//NO such user exist
				return false;
			}
			else
			{
				return true;
		}
	}
	
	public PolicyReq find_pr (List<PolicyReq> prList, int u_id, int pr_id) {
		for (PolicyReq pr: prList) {
			if (pr.getUser().getU_id() == u_id && pr.getPolicy().getP_id() == pr_id) {
				//Policy req found
				return pr;
			}	
		}
		return null; // not found

	}
	
	public List<PolicyReq>  dlt_policyReq (List<PolicyReq> prList, User u) {
		
		System.out.println("Enter Policy Id ");
		int pr_id = sc.nextInt();
			
		PolicyReq pr = (find_pr(prList, u.getU_id(), pr_id));
		 
		if (pr == null) {
			System.out.println("Error! Invalid entry");
		}
		else {
			//pr req found
			//validate if the user has authority to make delete request
			if (u.getUsername().equals(pr.getUser().getUsername())) {
				//user has the authority to make changes
				prList.remove(pr);
				System.out.println("Policy Request successfully removed!\n");
			}
		}
		return prList;
	}

}
