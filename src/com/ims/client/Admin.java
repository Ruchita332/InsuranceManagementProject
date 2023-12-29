package com.ims.client;

import java.util.List;

import java.util.Scanner;

import com.ims.dao.impl.CategoryDaoImpl;
import com.ims.dao.impl.PolicyDaoImpl;
import com.ims.dao.impl.PolicyReqDaoImpl;
import com.ims.dao.impl.SubCatDaoImpl;
import com.ims.dao.impl.UserDaoImpl;
import com.ims.pojo.*;

public class Admin {
	Scanner sc = new Scanner(System.in);
	
	UserDaoImpl uDao = new UserDaoImpl();
	CategoryDaoImpl cDao = new CategoryDaoImpl();
	SubCatDaoImpl scDao = new SubCatDaoImpl();
	PolicyDaoImpl pDao = new PolicyDaoImpl();
	PolicyReqDaoImpl prDao = new PolicyReqDaoImpl();
	
	public int display_options() {
		
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("                 HOME                    			"	);
		System.out.println("-------------------------------------------------------");
		System.out.println("                 1)User List                     	   ");
		System.out.println("                 2)Category List               	 	   ");
		System.out.println("                 3)Sub-Category List            	   "); 
		System.out.println("                 4)Policy List               	 	   "); 
		System.out.println("                 5)Policy request                	   "); 
		System.out.println("                 6)Log Out						 	   ");						
		System.out.println("-------------------------------------------------------");
		
		int choice = sc.nextInt();
		return choice;
	}
	
	public void display_userList(List<User> uList) {
		uDao.userList(uList);

	}
	
	public List<Category> display_clist(List<Category> cList){
		
		cDao.category_list(cList);

		
		int choice_c;
		do {
			
			System.out.println("-------------------------------------------------------");
			System.out.println(""
					+ "1 ADD \t"
					+ "2 UPDATE \t"
					+ "3 DELETE \t"
					+ "0 MAIN MENU");	
			System.out.println("-------------------------------------------------------");
			
			choice_c = sc.nextInt();
			
				switch(choice_c) {
				case 1: //ADD CAtegory
					System.out.println("ADD CATEGORY");
					//Add New Categories
					cList = cDao.add_category(cList);
					break;
					
				case 2: //UPDATE CATEGORY					
					System.out.println("UPDATE  CATEGORY");
					cList =cDao.edit_category(cList);
					break;
					
				case 3: //DELETE
					System.out.println("DELETE SUB CATEGORY");
					cList = cDao.dlt_category(cList);
					break;
					default:
						if(choice_c != 0) {
						System.out.println("Error! Invalid Entry!");
						}
				}
		}while (choice_c !=0);
		return cList;
		
	}

	public List<SubCat> display_scList (List<SubCat> scList, List<Category> cList){
		scDao.subcat_list(scList);

		
		int choice_sc;
		do {
			
			
			System.out.println("-------------------------------------------------------");
			System.out.println(""
					+ "1 ADD \t\t"
					+ "2 UPDATE \t\t"
					+ "3 DELETE \t\t"
					+ "0 MAIN MENU");	
			System.out.println("-------------------------------------------------------");
			
			choice_sc = sc.nextInt();
												
				switch(choice_sc) {
				case 1: //Add subcategory
					System.out.println("ADD NEW SUB CATEGORY");
					scList= scDao.add_subcat(scList, cList);
					break;
	
				case 2: //Update Edit Sub CATegory
					System.out.println("UPDATE SUB CATEGORY");
					scList = scDao.edit_subcat(scList, cList);
					break;
				case 3: //Delete SubCAtegory
					System.out.println("DELETE SUB CATEGORY");
					scList = scDao.dlt_subcat(scList);
					break;
					default:
						if(choice_sc != 0) {
							System.out.println("Error! Invalid Entry!");
							}
					
				}
		} while (choice_sc!= 0);
			
		return scList;
	}
	
	public List<Policy> display_policy (List<Policy> pList, List<SubCat>scList){

		pDao.policy_list(pList);

		int choice_p;
	
		do {
			System.out.println("-------------------------------------------------------");
			System.out.println(""
					+ "1 ADD \t\t"
					+ "2 UPDATE \t\t"
					+ "3 DELETE \t\t"
					+ "0 HOME");	
			System.out.println("-------------------------------------------------------");
			
			choice_p = sc.nextInt();
												
				switch(choice_p) {
				case 1: //Add Policy
					System.out.println("ADD NEW POLICY");
					pList= pDao.add_policy(pList, scList);
					break;
	
				case 2: //Update Edit Policy
					System.out.println("UPDATE POLICY");
					pList = pDao.edit_policy(pList, scList);
					break;
					
				case 3: //Delete Policy
					System.out.println("DELETE POLICY");
					pList = pDao.dlt_policy(pList);
					break;
					
					default:
						if(choice_p != 0) {
							System.out.println("Error! Invalid Entry!");
							}
				}
		}while (choice_p !=0);
				
		return pList;
	}
	
	public List<PolicyReq> display_policy_req (List<PolicyReq> prList, List<Policy> PList, User user){
		
		prDao.policyreq_list(prList, user);

		int choice_pr;
		
		do{
		
			System.out.println("-------------------------------------------------------");
			System.out.println(""
					+ "1 ACTIVATE \t\t"
					+ "2 CANCEL \t\t"
					+ "0 HOME");	
			System.out.println("-------------------------------------------------------");
			
			choice_pr = sc.nextInt();
			
												
				switch(choice_pr) {
				case 1: //Add Policy
					System.out.println("Activate POLICY");
					prList= prDao.edit_policy(prList, 2);
					break;
	
				case 2: //Update Deactivate/Cancel
					System.out.println("UPDATE POLICY");
					prList = prDao.edit_policy(prList, 3);
					break;
					
								
					default:
						if(choice_pr != 0) {
						System.out.println("Error! Invalid Entry!");
						}
				}
		}while(choice_pr !=0);
		
			return prList;
			
	}
}
