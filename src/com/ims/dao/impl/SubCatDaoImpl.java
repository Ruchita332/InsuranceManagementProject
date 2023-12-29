package com.ims.dao.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.ims.dao.SubCatDao;
import com.ims.pojo.Category;
import com.ims.pojo.SubCat;
import com.ims.dao.impl.CategoryDaoImpl;

public  class SubCatDaoImpl implements SubCatDao {
	
	List<SubCat> scList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	CategoryDaoImpl cDao = new CategoryDaoImpl();
	
	public List<SubCat> loadAdminInfo(List<Category> categories) {
		Category c1 = categories.get(0);
		Category c2 = categories.get(1);
		Category c3 = categories.get(2);
		SubCat sc1 = new SubCat(111, c1, "Sub Cat 1", null);
		SubCat sc2 = new SubCat(112, c2, "Sub Cat 2", null);	
		SubCat sc3 = new SubCat(113, c3, "Sub Cat 3", "balh blah");
		scList.add(sc1);
		scList.add(sc2);
		scList.add(sc3);
		
		return scList;
	}
	
	

	@Override
	public void subcat_list(List<SubCat> scList) {
		// TODO Auto-generated method stub
		scList.stream().forEach(
				(sc)-> {
						display_sc_info(sc);
				}
				);


	}

	@Override
	public List<SubCat> add_subcat(List<SubCat> scList, List<Category> categoryList) {
		int choice = 1;
		while(choice == 1){
			//find the category to add the sub category to
			System.out.print("Select a Category Id for Sub category: ");
			int c_id = sc.nextInt();
			//check if category with c_id exists
			Category c = cDao.find_category(categoryList, c_id);
			
			if (c == null) {
				//Category doesn't exist
				System.out.println("Error! Category Id not found!");
			}
			else {
				//Category was valid and found 
				int id;
				do {
				//Input rest of the Subcategory detail
					System.out.print("SubCategory id: ");
					id = sc.nextInt(); 
					
					//check if the subcategory id is unique
					if (!isUnique(scList, id)) {
						//id is not unique
						System.out.println ("Error! Subcategory Id has to be unique!\n");
				}
				}while(!isUnique(scList, id));
				
					//the id is unique//continue
					System.out.print("SubCategory Name: ");
					sc.nextLine() ;// to clear the extra "\n" character
					String name = sc.nextLine();
					
					System.out.println("Category details");
					String details = sc.nextLine();
					
					SubCat sc = new SubCat (id, c, name, details);
					scList.add(sc);
					
					System.out.println("SubCategory \"" + name + "\" was successfully added!\n");
			
			
			}
			
			System.out.println();
			System.out.println("Would you like to add another SubCategory?");
			System.out.println ("Please Enter 1 for YES and 2 for NO");
			choice = sc.nextInt();	
			System.out.println();

		}
					
		
		return scList;
	}
	
	@Override
	public List<SubCat> edit_subcat(List<SubCat> scList, List<Category> categoryList) {
		// TODO Auto-generated method stub
		
		System.out.println ("Pleasee Enter the ID of Sub Category you would like to Update");
		int id = sc.nextInt();
		
		//Check if the Sub category exist and id is valid
		SubCat subc = find_subcat(scList, id);
		
		if (subc == null) {
			//subcategory not found end the just return
			System.out.println("Error! Invalid Subcategory ID\n");
			
			return scList;

		}
		
		else {
			//Sub ccatogy is valid
			int index = scList.indexOf(subc);  //to remember position of subcat
							display_sc_info(subc);
			
			while(true) {
				
				System.out.println("Please selelct the Edit option");
				System.out.println("----------------------------------------------------");	
				System.out.println("                 1)SubCategory Id                   ");
				System.out.println("                 2)Category Info            		");
				System.out.println("                 3)SubCategory Name            	 	");
				System.out.println("                 4)Details               			"); 
				System.out.println("                 5)Back             				"); 				
				System.out.println("----------------------------------------------------");	

				int choice = sc.nextInt();
				
				
				switch(choice) {
				case 1: //Update SubCAtegory id
					System.out.println("Please enter new Sub Category Id.");
					int s_id = sc.nextInt();
					
					//Validate the s_id
					if (!isUnique(scList, s_id)) {
						//not unique
						System.out.println("Error! Sub Category Id has to be unique!");
					}
					else {
						//id is unique
						subc.setSc_id(id);

					}
					break;
					
				case 2: //Update Category Info
					//find the category info
					System.out.println ("Pleasee Enter the ID of category you would like to update subcategory to");
					int c_id = sc.nextInt();
					
					//find the category to edit
					Category c = cDao.find_category(categoryList, c_id);
					
					if (c == null) {
						//Category not found;
						System.out.println("Error! Category Id not valid!");
					}
					else {
							subc.setCategory(c);
						
					}
					break;
					
				case 3: //subCategory name
					System.out.println("Please enter Sub Category Name.");
					sc.nextLine(); //clear the \n char
					String name1 = sc.nextLine();
					subc.setSc_name(name1);
					break;
				case 4://Update Subcategory Details
					System.out.println("Please enter new Category Details.");
					sc.nextLine(); //clear the \n char
					String details = sc.nextLine();
					subc.setDetails(details);
					break;
				case 5: //Exit to main menu
					scList.set(index, subc);
					System.out.println("The SubCategory has been updated!");
					
					return scList;
					
					default:
						System.out.println("Error! Please make valid selection\n");
				}
			
			}
			
			
			}
		}


	@Override
	public List<SubCat> dlt_subcat(List<SubCat> scList) {
		// TODO Auto-generated method stub
		System.out.println ("Pleasee Enter the ID of Sub-Category you would like to Delete");
		int id = sc.nextInt();
		
		//find the category to edit
		SubCat subc = find_subcat(scList, id);
		
		if (subc == null) {
			//Category not found;
			System.out.println("Error! Category Id not valid!\n");
			
		}
		else {
				//we found the element
				//delete
				scList.remove(subc);
				System.out.println("The category has been successfully removed!\n");
		}
		
		
		return scList;
	}



	public SubCat find_subcat(List<SubCat> scList, int id) {
		//Find the Subcategory to update or delete			
		
		for (SubCat sc: scList) {
			if (sc.getSc_id() == id) {
				//found the category
				return sc;
			}
		}
		
		return null;
				
	}
	
	public boolean isUnique(List<SubCat> scList, int id) {
		if (find_subcat (scList, id) == null) {
			//the category id is unique
			return true;
		}
		
		return false;
	}
	
	
	public void display_sc_info (SubCat sc) {
		System.out.println("----------------------------------------------------");	
		System.out.println("SubCategory Id: "+ sc.getSc_id());
		System.out.println("Category Name: "+ sc.getCategory().getC_name());
		System.out.println("SubCategory Name: "+ sc.getSc_name());
		System.out.println("SubCategory Details: "+ sc.getDetails());	
		System.out.println("----------------------------------------------------");	
		System.out.println();
	}




}
