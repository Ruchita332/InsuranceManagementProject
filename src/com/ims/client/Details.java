package com.ims.client;

import com.ims.pojo.*;

import java.util.List;

public class Details {
	
	
	
	public ObjList categoryMenu (ObjList all_list, User loggedInUser) {
				
		Admin admin = new Admin();
		Customer customer = new Customer();
		
		List<User> uList = all_list.getuList();
		List<Category> cList = all_list.getcList();
		List<SubCat> scList = all_list.getScList();
		List<Policy>pList = all_list.getpList();
		List<PolicyReq> prList = all_list.getPrList();
	
		String role = loggedInUser.getRole();
				
		
		while(role.equals("admin")) {
			//display the options
			int choice =admin.display_options();
	
			switch(choice) {
			
				case 1: //View All Users
					admin.display_userList(uList);
					break;
					
				case 2: //View All Categories
					cList = admin.display_clist(cList); 
					break;
					
				case 3:  //sub category list
					scList = admin.display_scList(scList, cList);
					break;
				
				case 4: //Policy List
					pList = admin.display_policy(pList, scList);
					break;
					
				case 5: // Buyers policy req View/Activate/Cancel
					prList = admin.display_policy_req(prList, pList, loggedInUser);				
					break;
					
				case 6: // Back to Login page
				role = " ";
				break;

					default: 
						if (choice < 1 || choice > 6) {
							System.out.println("Error! Invalid Request");
						}
			}
		}
		
		while(role.equals("customer") ) {
			
			int choice = customer.display_options();
		
			switch(choice) {
			
			case 1: //View All Categories
				customer.display_clist(cList);				
				break;
				
			case 2:  //sub category list
				customer.display_scList(scList, cList);
				break;
			
			case 3: //Policy List
				customer.display_policy(pList, scList);
				
			case 4: // Apply policy 
				prList = customer.apply_policy(prList, pList, loggedInUser);
				
				break;
			case 5: //View the list of Policy he/she holds
				prList = customer.display_policy_req(prList, loggedInUser);
				break;
				
			case 6: //Back
				role = " ";
					default:
						if (choice < 1 || choice > 6) {
							System.out.println("Error! Invalid Request");
						}
			}
		}
		
		
		
		return  ( new ObjList (uList, cList, scList, pList, prList) );
		
		
	}
	
}
