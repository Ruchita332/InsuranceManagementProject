package com.ims.dao.impl;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import com.ims.dao.PolicyDao;
import com.ims.dao.impl.SubCatDaoImpl;
import com.ims.pojo.Category;
import com.ims.pojo.Policy;
import com.ims.pojo.SubCat;

public class PolicyDaoImpl implements PolicyDao {
	
	List <Policy> pList = new ArrayList<>();
	Scanner sc = new Scanner (System.in);
	SubCatDaoImpl sDao = new SubCatDaoImpl();
	
	public List<Policy> loadAdminInfo(List<SubCat>scList) {
		SubCat sc1 = scList.get(0);
		SubCat sc2 = scList.get(1);		
		SubCat sc3 = scList.get(2);
		
		Policy p1 = new Policy(1111, sc1.getCategory(), sc1, "Policy 1",500000, 1000, 12 );
		Policy p2 = new Policy (1112, sc2.getCategory(), sc2, "Policy 2",1000000, 500, 50 );
		Policy p3 = new Policy (1113, sc3.getCategory(), sc3, "Policy 3",60000, 500, 34 );

		pList.add(p1);
		pList.add(p2);
		pList.add(p3);

		
		return pList;
	}
	

	@Override
	public List<Policy> add_policy(List<Policy> pList, List<SubCat> scList) {
		// TODO Auto-generated method stub
		int choice = 1;
		while(choice == 1) {
			
			//Find the sub category to add the policy to
			System.out.print("Select a Subcategory Id for Policy: ");
			int sc_id = sc.nextInt();
			
			//Validate if it a valid Sub Category
			SubCat subc = sDao.find_subcat(scList, sc_id);
			
			if (subc == null) {
				//subc is incalid
				System.out.println("Error! Invalid Sub Category Id!");
			}
			else {
				//Subcategory selected
				//Input rest of policy information
				
				int p_id;
				
				do {
				
					System.out.print("Policy ID: ");
					p_id = sc.nextInt();
					
				//Validate if its a unique pid
				if (!isUnique(pList, p_id)) {
					//not unique
					System.out.println ("Error! Policy Id has to be unique!\n");
					}
				}while(!isUnique(pList, p_id));
				
				
					//if id is unique the contnue
				
					System.out.print("Policy Name: ");
					sc.nextLine() ;// to clear the extra "\n" character
					String name = sc.nextLine();
					
					System.out.println("Sum Assured");
					double sum = sc.nextDouble();
					
					System.out.println("Premium Per month: ");
					double premium = sc.nextDouble();
					
					System.out.println("Tenure (in Years): ");
					int tenure = sc.nextInt();
					
					Policy  p = new Policy (p_id, subc.getCategory(), subc, name, sum, premium, tenure);
					pList.add(p);
					
					System.out.println("Policy \"" + name + "\" was successfully added!\n");
					
				
			}
			System.out.println();
			System.out.println("Would you like to add another Policy?");
			System.out.println ("Please Enter 1 for YES and 2 for NO");
			choice = sc.nextInt();
			System.out.println();

		}
				
		return pList;
	}

	@Override
	public void policy_list(List<Policy> pList) {
		// TODO Auto-generated method stub
		pList.stream().forEach(
				(p)-> {
						display_pinfo(p);
				}
				);

		
	}

	@Override
	public List<Policy> edit_policy(List<Policy> pList, List<SubCat> scList) {
		// TODO Auto-generated method stub
		
		System.out.println ("Pleasee Enter the ID of Policy you would like to Update");
		int id = sc.nextInt();
		
		//Check if the Sub category exist and id is valid
		Policy p = find_policy(pList, id);
		
		if (p == null) {
			//subcategory not found end the just return
			System.out.println("Error! Invalid Policy ID\n");

			return pList;
		}
		else {
			//Policy id found
			
			//Save the index of policy
			int index = pList.indexOf(p);
				display_pinfo(p);							
			
			while(true) {
				
				System.out.println("Please selelct the Edit option");
				System.out.println("----------------------------------------------------");	
				System.out.println("                 1)Policy Id                   		");
				System.out.println("                 2)Sub Category Info           		");
				System.out.println("                 3)Policy Name            	 		");
				System.out.println("                 4)Sum Insured               		"); 
				System.out.println("                 5)Premium              			"); 
				System.out.println("                 6)Tenure               			"); 
				System.out.println("                 7)Back             				"); 				
				System.out.println("----------------------------------------------------");	

				int choice = sc.nextInt();
				
				
				switch(choice) {
				case 1: //Update Policy id
					System.out.println("Enter New Id policy.");
					int p_id = sc.nextInt();
					
					//Validate the s_id
					if (!isUnique(pList, p_id)) {
						//not unique
						System.out.println("Error! Policy Id has to be unique!\n");
					}
					else {
						//id is unique
						p.setP_id(p_id);

					}
					break;
					
				case 2: //Update SubCAtegory Info
					//find the category info
					System.out.println ("Select new subcategory Id to add policy to");
					int sc_id = sc.nextInt();
					
					//find the category to edit
					SubCat subc = sDao.find_subcat(scList, sc_id);
					
					if (sc == null) {
						//Category not found;
						System.out.println("Error! Sub Category Id not valid!\n");
					}
					else {
							p.setSub_category(subc);
							p.setCategory(subc.getCategory());
						
					}
					break;
					
				case 3: //Policy name
					System.out.println("Please enter Sub Policy Name.");
					sc.nextLine(); //clear the \n char
					String pname = sc.nextLine();
					p.setPolicy_name(pname);
					break;
					
				case 4://Sum insured
					System.out.println("Please enter new Sum Insured.");
					double sum = sc.nextDouble();
					p.setSum_Assured(sum);
					break;
					
				case 5://Premium
					System.out.println("Please enter new Premoum Amount.");
					double premium = sc.nextDouble();
					p.setPremium(premium);
					break;
				case 6://Tenure
					System.out.println("Please enter new Tenure in Years.");
					int tenure = sc.nextInt();
					p.setTenure(tenure);
					break;
				case 7: //Exit to main menu
					pList.set(index, p);
					System.out.println("The SubCategory has been updated!\n");
					return pList;
					
					default:
						System.out.println("Error! Please make valid selection\n");
				}
			
			}

		}
	}

	@Override
	public List<Policy> dlt_policy(List<Policy> pList) {
		// TODO Auto-generated method stub
		System.out.println ("Please Enter the ID of Policy you would like to Delete");
		int id = sc.nextInt();
		
		//find the category to edit
		Policy p = find_policy(pList, id);
		
		if (p == null) {
			//Category not found;
			System.out.println("Error! Policy Id not valid!");
			
		}
		else {
				//we found the Policy
				//delete
				pList.remove(p);
				System.out.println("The Policy has been successfully removed!\n");
		}
		
		
		return pList;
	}
	
	public void display_pinfo(Policy p) {
		System.out.println("----------------------------------------------------");	
		System.out.println(" Policy Id: "  + p.getP_id());  
		System.out.println(" Category: "  + p.getCategory().getC_name());                             					
		System.out.println(" SubCategory: "  + p.getSub_category().getSc_name());                           					
		System.out.println(" Policy Name: "  + p.getPolicy_name());                             					
		System.out.println(" SumAssured: "  + p.getSum_Assured());                             					
		System.out.println(" Premium: "  + p.getPremium());                             					
		System.out.println(" Tenure: "  + p.getTenure());                             					
		System.out.println("----------------------------------------------------");	
		System.out.println();
	}
	
	public Policy find_policy(List<Policy> pList, int id) {
		//Find the Subcategory to update or delete			
		
		for (Policy p: pList) {
			if (p.getP_id() == id) {
				//found the category
				return p;
			}
		}
		
		return null;
				
	}
	
	public boolean isUnique(List<Policy> pList, int id) {
		if (find_policy (pList, id) == null) {
			//the category id is unique
			return true;
		}
		
		return false;
	}


	
}
