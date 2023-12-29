package com.ims.dao.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.ims.dao.UserDAO;
import com.ims.pojo.Category;
import com.ims.pojo.User;

public class UserDaoImpl implements UserDAO {
	
	List<User> userList = new ArrayList<>();
	Scanner sc = new Scanner (System.in);
	
	
	public List<User> loadAdminInfo() {
		//Load some prdefined data into system such as admin info
		
		User admin = new User(1, "admin", "admin", "admin","admin123@gmail.com", "admin@123");
		admin.setRole("admin");
		
		User u1 = new User(111, "Ruchita", "G", "ruchi","ruchi424@gmail.com", "user@123");
		User u2 = new User(222, "Susie", "B", "su123","susie1552@gmail.com", "user@123");
		User u3 = new User(333, "Tom", "Holland", "tom123","tom123456@gmail.com", "user@123");


		
		userList.add(admin);
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		
		return userList;

	}


	@Override
	public List<User> addUser(List<User> users) {
		// TODO Auto-generated method stub
	
		int choice = 1;
		
		while (choice == 1) {
			
			System.out.println("Please enter user details:");
			
			boolean isunique;
			int id;
			
			do {
				isunique = false;
				System.out.print("User id: ");
				id = sc.nextInt();
				isunique = isUnique (users, id);
				
				if (!isunique) {
					System.out.println("Error! UserID had to be unique.");
				}
				
			}while(!isunique);
			
			System.out.print("First Name: ");
			String f_name = sc.next();
			System.out.print("Last Name: ");
			String l_name = sc.next();
			
			String u_name;
			
			
			do {
				isunique = false;
			System.out.print("User Name: ");		
			u_name = sc.next();
			
			//check if username is unique
			isunique = isUnique(users, u_name);
			if (!isunique) {
				System.out.println("Error! Username had to be unique.");
			}
			 
			}while (!(isunique));
			
			System.out.print("Email @ : ");
			
			String email = sc.next();
			System.out.print("Password: ");
			String pass = sc.next();
			
			
			
			User user = new User (id, f_name, l_name, u_name, email, pass);
			//Add the user into the list
			userList.add(user);
			System.out.println("User " + f_name +" " +l_name + " was successfully added!");
			
			System.out.println();
			System.out.println("Would you like to add another user?");
			System.out.println ("Please Enter 1 for YES and 2 for NO");
			choice = sc.nextInt();
			System.out.println("choice: " +choice);

		}
		
		return userList;
	}
	
	@Override
	public User verifyUser(String uname, String pwd) {
		// TODO Auto-generated method stub
		for (User u: userList) {
			if (u.getUsername().equals(uname) && u.getPassword().equals(pwd)){
				
				//we found a match user is verified
				return u;
			}
		}
		
		System.out.println("\nUser Info not found!\n");
		return null; // no match was found
	}


	@Override
	public void forgotPassword(List<User> users) {
		// TODO Auto-generated method stub
		
		System.out.println("Please Enter Your username: ");
		String userName = sc.next();
		System.out.println("Please enter your userId: ");
		int id = sc.nextInt();
		
		for(User u: users) {
			if (u.getUsername().equals(userName) && u.getU_id() == id) {
				//User found
				System.out.println("Your password is " +u.getPassword());
				return;
			}
		}
		
		//Case user not found
		System.out.println("Error! Invalid UserName or userId!");	
	}


	@Override
	public void userList(List<User> users) {
		// TODO Auto-generated method stub
		//Display the user info
	
		for (User u: users) {
						display_user(u);
		}
	}
	
	
	public void display_user (User u) {
		
		System.out.println("-------------------------------------------------------");
		System.out.println("User Id: " + u.getU_id());
		System.out.println("User Name: " + u.getFirst_name() + " "+ u.getLast_name());
		System.out.println("Username: " + u.getUsername());
		System.out.println("Email @: " + u.getEmail());
		System.out.println("User Role: " + u.getRole());
		System.out.println("-------------------------------------------------------");
		System.out.println();	
	}
	
	public User find_user (List<User> users, int id) { //check using userid
		//Find the Category to update or delete
		
				for (User u: users) {
					if (u.getU_id() == id) {
						//found the category
						return u;
					}
				}
				
							
				return null;
	}
	
	public User find_user (List<User> users, String username) { //check the username
		//Find the Category to update or delete
		
				for (User u: users) {
					if (u.getUsername().equals(username)) {
						//found the category
						return u;
					}
				}
				
							
				return null;
	}
	
	
	public boolean isUnique(List<User> users, int id) { //for int
		if (find_user (users, id) == null) {
			//the category id is unique
			return true;
		}
		return false;
	}
	
	public boolean isUnique (List<User> users, String username) { // for string
		if (find_user(users, username) == null) {
			//didn't find user
			//username is unique
			return true;
		}
		else return false;
	}
}
