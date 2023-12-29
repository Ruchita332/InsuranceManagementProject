	package com.ims.client;

	import java.util.List;
	import java.util.Scanner;

	import com.ims.dao.impl.CategoryDaoImpl;
	import com.ims.dao.impl.PolicyDaoImpl;
	import com.ims.dao.impl.PolicyReqDaoImpl;
	import com.ims.dao.impl.SubCatDaoImpl;
	import com.ims.dao.impl.UserDaoImpl;
	import com.ims.pojo.*;


public class Customer {

	Scanner sc = new Scanner(System.in);
		
		UserDaoImpl uDao = new UserDaoImpl();
		CategoryDaoImpl cDao = new CategoryDaoImpl();
		SubCatDaoImpl scDao = new SubCatDaoImpl();
		PolicyDaoImpl pDao = new PolicyDaoImpl();
		PolicyReqDaoImpl prDao = new PolicyReqDaoImpl();
		
		public int display_options() {

			System.out.println("----------------------------------------------------");	
			
			System.out.println("                 1)Category List               	 ");
			System.out.println("                 2)Sub-Category List             "); 
			System.out.println("                 3)Policy List               	 "); 
			System.out.println("                 4)Apply request                "); 
			System.out.println("                 5)View Policy                "); 
			System.out.println("                 6)Log Out                      		");		
					
					
			System.out.println("----------------------------------------------------");	
			
			int choice = sc.nextInt();
			return choice;
		}
		
				
		public void display_clist(List<Category> cList){
			cDao.category_list(cList);			
		}

		public void display_scList (List<SubCat> scList, List<Category> cList){
			
			scDao.subcat_list(scList);
		}
		
		public void display_policy (List<Policy> pList, List<SubCat>scList){
			pDao.policy_list(pList);
			
		}
		
		public List<PolicyReq> apply_policy (List<PolicyReq> prList, List<Policy> pList, User User){
			
			prList = prDao.apply_policy(prList, pList, User);
			
			return prList;
		}
		
		public List<PolicyReq> display_policy_req (List<PolicyReq> prList, User user){
			
			prDao.policyreq_list(prList, user);

			
			int choice;
			
			do {

				System.out.println("----------------------------------------------------");	
				System.out.println(""
						+ "1 CANCEL REQUEST \t\t\t"
						+ "0 HOME");	
				System.out.println("----------------------------------------------------");	
				
				choice = sc.nextInt();
				
				if (choice == 1) {
				
		
				System.out.print("CANCEL REQUEST\n");
				prList = prDao.dlt_policyReq(prList, user);
				
				System.out.println();
				}
				
				else if (choice !=0 && choice !=1) {
					System.out.println("Error! Invalid entry!");
				}

				
			}while (choice != 0);
			
			return prList;
	}


}
