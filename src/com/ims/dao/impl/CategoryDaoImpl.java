package com.ims.dao.impl;

import java.util.List;

import java.util.Scanner;
import java.util.ArrayList;

import com.ims.dao.CategoryDao;
import com.ims.pojo.Category;
import com.ims.pojo.Policy;
import com.ims.pojo.PolicyReq;
import com.ims.pojo.SubCat;
import com.ims.pojo.User;

public class CategoryDaoImpl implements CategoryDao {
	List<Category> categoryList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public List<Category> loadAdminInfo() {
		Category c1 = new Category(11, "Category A", null);
		Category c2 = new Category(12, "Category B", null);
		Category c3 = new Category(13, "Category C", null);
		
		categoryList.add(c1);
		categoryList.add(c2);
		categoryList.add(c3);
		
		return categoryList;
	}
	
	@Override
	public List<Category> add_category(List<Category> categories) {
		// TODO Auto-generated method stub
			int choice = 1;
			
			while (choice == 1) {	
				int id;
		
				System.out.println("Please enter Category details:");
				
				do {
					//get the id and Check if the id is unique

					System.out.print("Category id: ");
					id = sc.nextInt(); 
					
					if (!(isUnique(categories, id))) {
						System.out.println("Error! Id has to be unique!\n");
					}
				}while (!isUnique(categories, id));
				
					//the id is unique then we continue

					System.out.print("Category Name: ");
					sc.nextLine(); //to clear /n char
					String name = sc.nextLine();
					
					System.out.println("Category details");
					String details = sc.nextLine();
					
					Category c = new Category (id, name, details);
					categories.add(c);
					
					System.out.println("Category \"" + name + "\" was successfully added!");
					
							
				System.out.println();
				System.out.println("Would you like to add another Category?");
				System.out.println ("Please Enter 1 for YES and 2 for NO");
				choice = sc.nextInt();
				System.out.println("choice: " +choice);
			}
			return categories;
	}
	
	@Override
	public void category_list(List<Category> categories) {
		// TODO Auto-generated method stub
		
		categories.stream().forEach(
				(c)-> {
						display_category(c);
				}
				);

	}
	
	@Override
	public List<Category> edit_category(List<Category> categories) {
		// TODO Auto-generated method stub
		
		System.out.println ("Pleasee Enter the ID of category you would like to Update");
		int id = sc.nextInt();
		
		//find the category to edit
		Category c = find_category(categories, id);
		
		if (c == null) {
			//Category not found;
			System.out.println("Error! Category Id not valid!");
			
			return categories;
		}
		
		
		else { // Category was found{
			
			display_category(c);

			int index = categories.indexOf(c);
					
				while (true){
					System.out.println("Please selelct the Edit option");
					System.out.println("----------------------------------------------------");	
					System.out.println("                 1)Category Id                  ");
					System.out.println("                 2)Category Name            	 ");
					System.out.println("                 3)Details                "); 
					System.out.println("                 4)Back             "); 				
					System.out.println("----------------------------------------------------");	
	
					int choice = sc.nextInt();
					switch(choice) {
					case 1: //Update Category id
						System.out.println("Please enter new Category Id.");
						int new_id = sc.nextInt();
						//check if the new id is unique
						if (isUnique(categories, new_id)) {
						c.setC_id(new_id);
						}
						break;
						
					case 2: //Update Category Name
						System.out.println("Please enter new Category Name.");
						sc.nextLine(); //clear the \n char
						String name1 = sc.nextLine();
						c.setC_name(name1);
						break;
					case 3://Update Category Details
						System.out.println("Please enter new Category Details.");
						sc.nextLine(); //clear the \n char
						String details = sc.nextLine();
						c.setC_detail(details);
						break;
					case 4: //Exit to main menu
						//update the category
						categories.set(index, c);
						System.out.println("The category has been updated!");
						return categories;
						
						default:
							System.out.println("Please make valid selection");
					}
					
					}
				}
						
	}
	
	@Override
	public List<Category> dlt_category(List<Category> categories) {
		// TODO Auto-generated method stub
		System.out.println ("Pleasee Enter the ID of category you would like to Delete");
		int id = sc.nextInt();
		
		//find the category to edit
		Category c = find_category(categories, id);
		
		if (c == null) {
			//Category not found;
			System.out.println("Error! Category Id not valid!");
			
		}
		else {
				//we found the element
				//delete
				categories.remove(c);
				System.out.println("The category has been successfully removed!");
		}
			
			
		return categories;
	}
	

	
	public Category find_category (List<Category> categoryList, int id) {
		//Find the Category to update or delete
		
				for (Category c: categoryList) {
					if (c.getC_id() == id) {
						//found the category
						return c;
					}
				}
				
							
				return null;
	}
	
	public boolean isUnique(List<Category> categoryList, int id) {
		if (find_category (categoryList, id) == null) {
			//the category id is unique
			return true;
		}
		return false;
	}
	
	
	public void display_category (Category c) {
		System.out.println("----------------------------------------------------");	
		System.out.println("Category Id: "+ c.getC_id());
		System.out.println("Category Name: "+ c.getC_name());
		System.out.println("Category Details: "+ c.getC_detail());	
		System.out.println("----------------------------------------------------");	
		System.out.println();

		
	}
	




}
