package com.ims.client;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.ims.dao.impl.*;
import com.ims.pojo.*;
import com.ims.dao.*;

public class UserClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDaoImpl uDao = new UserDaoImpl();
		CategoryDaoImpl cDao = new CategoryDaoImpl();
		SubCatDaoImpl scDao = new SubCatDaoImpl();
		PolicyDaoImpl pDao = new PolicyDaoImpl();
		PolicyReqDaoImpl prDao = new PolicyReqDaoImpl();
	
		
		List<User> uList = uDao.loadAdminInfo();
		List<Category> cList = cDao.loadAdminInfo();
		List<SubCat> scList = scDao.loadAdminInfo(cList);
		List<Policy> pList = pDao.loadAdminInfo(scList);
		List<PolicyReq> prList = prDao.loadAdminInfo(pList, uList);
		
		ObjList allObj = new ObjList (uList, cList, scList, pList, prList);
		
		Details details = new Details();


		Scanner sc = new Scanner(System.in);

		User loggedInUser = null;
	
		
		while(true) {
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println("             1)Register                                ");
			System.out.println("             2)Login                                "   );
			System.out.println("             3)Forgot Password                       "   );
			System.out.println("             4)Exit                                "    );
			System.out.println("-------------------------------------------------------");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: //Register
				uList = uDao.addUser(uList);
				allObj.setuList(uList);
					
				break;
			case 2: //Login
				//Get the username and password to continue
				System.out.println("Log In Form");
				System.out.print("Username: ");
				String userName = sc.next();
				System.out.print("Password: ");
				String pass = sc.next();
				
				//validate userInfo
				loggedInUser = uDao.verifyUser(userName, pass);
				
				if (loggedInUser != null) {
					System.out.println("\nWelcome " + loggedInUser.getFirst_name() + " " +loggedInUser.getLast_name());

					allObj = details.categoryMenu(allObj, loggedInUser);	
					
				}
				else {
					System.out.println ("Please Register/Sign In!");
				}
								
				break;
				
			case 3: //Forgot Password
				uDao.forgotPassword(uList);
				break;
				
			case 4: //exit
				System.out.println("Have a nice day!");
				System.exit(0);
				default:
					System.out.println("Error! Invalid Entry!");
			}
			
		}
		

	}

}
