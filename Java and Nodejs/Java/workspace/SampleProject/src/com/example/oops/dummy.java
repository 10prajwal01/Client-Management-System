package com.example.oops;

import java.util.Objects;

import User_details.Logic;
import User_details.User;

public class dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		while (true) {
			int input;
			
			try {
				System.out.println("Select 1:Add user, 2: Remove User, 3:Update User, 4:Show User, 0:Exit");
				input = sc.nextInt();
				sc.nextLine();
			}
			catch(Exception e) {
				System.out.println("Enter valid input.");
				sc.nextLine();
				continue;
			}
			
			if (input == 0) {
				System.out.println("Thank you for the visit.....SUIIIIIIIIIII");
				break;
			}
			
			switch (input) {
			case 1: {
				System.out.println();
				System.out.println("Enter user details:");
				User A = new User();
				System.out.println("ID:");
				A.setUser_id(sc.nextLine());
				System.out.println("Name:");
				A.setUser_name(sc.nextLine());
				System.out.println("Email:");
				A.setUser_email(sc.nextLine());
				System.out.println("Phone Number:");
				A.setUser_phone_number(sc.nextLine());
				System.out.println("Age:");
				A.setUser_age(sc.nextLine());
				System.out.println("User Info:");
				A.setUser_info(sc.nextLine());
				Logic.addUser(A);
				break;
			}

			case 2: {
				boolean flag=false;
				System.out.println("Enter user ID to be removed:");
				for (User u : Logic.userList) {
						if (Objects.equals(u.getUser_id(), sc.nextLine())) {
							flag=true;
							Logic.removeUser(u);
							break;
						}
					}
				if(flag==false) {
					System.out.println("ID not found.....");
				}
				break;
			}
			
			case 3:{
				boolean flag=false;
				System.out.println("Enter the user ID to update:");
				for (User u : Logic.userList) {
						if(Objects.equals(u.getUser_id(), sc.nextLine())) {
							flag=true;
							System.out.println("Name: ");
							u.setUser_name(sc.nextLine());
							System.out.println("Email: ");
							u.setUser_email(sc.nextLine());
							System.out.println("Phone Number: ");
							u.setUser_phone_number(sc.nextLine());
							System.out.println("Age: ");
							u.setUser_age(sc.nextLine());
							System.out.println("User Information: ");
							u.setUser_info(sc.nextLine());
							Logic.updateUser(u);;
							break;
							}
						}
						if(flag==false) {
							System.out.println("ID not found.....");
						}break;
				
			}

			case 4: {
				boolean flag=false;
				System.out.println("Enter ID to Show User: ");
				System.out.println();
				String temp=sc.next();
				for (User u : Logic.userList) {
						if(Objects.equals(u.getUser_id(), temp)) {
							flag=true;
							Logic.showDetails(u);
							break;
							}
				}
				if(flag==false) {
					System.out.println("ID not found.....");
				}break;
				
			}

			}
		}
	}

}
	}

}
