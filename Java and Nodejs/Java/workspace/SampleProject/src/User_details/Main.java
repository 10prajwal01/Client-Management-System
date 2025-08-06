package User_details;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------------");
		System.out.println("Welome to User Management");
		System.out.println("--------------------------------------------------");
		System.out.println();
		int initial;
		while(true) {
			Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Select 1:Admin, 2:User, 0:Exit");
			initial = sc.nextInt();
			sc.nextLine();
		}catch(Exception e) {
			System.out.println("Invalid Input. Enter valid input.");
			sc.nextLine();
			continue;
		}
		String admin = "admin";
		String password = "user";
		if(initial == 0) {
			System.out.println("Thank you for visiting.....");
			break;
		}
		switch(initial) {
		case 1: {
				
				DBConnect.passwordAdmin();
				System.out.println();
				while(true) {
					int input;
					Scanner sc5 = new Scanner(System.in);
					while(true) {
					try {
						System.out.println("Select 1:Add user, 2: Remove User, 3:Update User, 4:Show Users, 0:Exit");
						input = sc5.nextInt();
						sc5.nextLine();
					}
					catch(Exception e) {
						System.out.println("Invalid Input. Enter valid input.");
						sc5.nextLine();
						continue;
					}
					break;
					}
					
					if (input == 0) {
						//System.out.println(react);
						break;
					}
					
					switch (input) {
					case 1: {
						Scanner sc10 = new Scanner(System.in);
						boolean validPhno = false;
						boolean validAge = false;
						System.out.println();
						System.out.println("Enter user details:");
						System.out.println("ID:");
						String user_id = sc10.nextLine();
						System.out.println("Name:");
						String user_name = sc10.nextLine();
						System.out.println("Email:");
						String user_email = sc10.nextLine();
						System.out.println("Phone Number:");
						String user_phone_number = sc10.nextLine();
						int user_age = 0;
						while(!validAge) {
							System.out.println("Age:");
						try{
							user_age = sc10.nextInt();
							sc10.nextLine();
							validAge = true;
						}catch(Exception ex) {
							System.out.println("Invalid input. Please enter valid number");
							sc10.nextLine();
						}
						
						}
						System.out.println("User Information:");
						String user_info = sc10.nextLine();
						//sc10.next();
						System.out.println("Default Password: "+ password);
						User A = new User(user_id, user_name, user_email,user_phone_number, user_age, user_info, password);
						DBConnect.insertData(A);//
						//System.out.println("Default Password: "+ password);
						System.out.println();
						break;
					}

					case 2: {
						Scanner sc25 = new Scanner(System.in);
						boolean flag=true;
						System.out.println("Enter user ID to be removed:");
						String user_id = sc25.nextLine();
						while(true) {
						DBConnect.deleteUsersbyID(user_id);
						if(flag==false) {
							System.out.println("ID not found.....Please enter correct User ID.");
						}
						break;
						}
						break;
					}
					
					case 3:{
						Scanner sc11 = new Scanner(System.in);
						boolean validPhno = false;
						boolean validAge = false;
						System.out.println("Enter the user ID to update:");
						String user_id = sc11.nextLine();
						System.out.println("Name: ");
						String user_name = sc11.nextLine();
						System.out.println("Email: ");
						String user_email = sc11.nextLine();
						System.out.println("Enter Phone Number: ");
						String user_phone_number = sc11.nextLine();
						
						int user_age = 0;
						while(!validAge) {
							System.out.println("Age: ");
						try{
							user_age = sc11.nextInt();
							sc11.nextLine();
							validAge = true;
						}catch(Exception ex) {
							System.out.println("Invalid input. Please enter Age");
							sc11.nextLine();
						}
						}
						System.out.println("User Information: ");
						sc11.next();
						String user_info = sc11.nextLine();
						User A = new User(user_id, user_name, user_email,user_phone_number, user_age, user_info, null);
						DBConnect.updateUser1(A);
						System.out.println();
									
						break;
						
					}

					case 4: {
						System.out.println();
						DBConnect.getAllUsers();
						break;
					}
				
					}
				}
					break;
					//break;
		}
		case 2:{
			DBConnect.passwordUser();
			System.out.println();
			while(true) {
			Scanner sc6 = new Scanner(System.in);
			int input;
			
			try {
				System.out.println("Select 1: Remove User, 2:Update User, 3:Show User, 0:Exit");
				input = sc6.nextInt();
				sc6.nextLine();
			}
			catch(Exception e) {
				System.out.println("Enter valid input.");
				sc6.nextLine();
				continue;
			}
			
			if (input == 0) {
				break;
			}
			
			switch (input) {

			case 1: {
				Scanner sc25 = new Scanner(System.in);
				boolean flag=true;
				System.out.println("Enter user ID to be removed:");
				String user_id = sc25.nextLine();
				System.out.println("Enter password: ");
				String user_password = sc25.nextLine();
				while(true) {
					
						if(DBConnect.authenticateUser(user_id, user_password)) {
							DBConnect.deleteUsersbyID(user_id);
							}else {
								System.out.println("UseName and Password are incorrect. Please try again...");
							}
					
				
				if(flag==false) {
					System.out.println("ID not found.....");
				}
				break;}
				break;
				
			}
			
			case 2:{
				Scanner sc11 = new Scanner(System.in); 
				boolean validation = false;
				boolean validPhno = false;
				boolean validAge = false;
				System.out.println("Enter the user ID to update:");
				String user_id = sc11.nextLine();
				System.out.println("Name: ");
				String user_name = sc11.nextLine();
				System.out.println("Email: ");
				String user_email = sc11.nextLine();
				
				System.out.println("Phone Number: ");
				String user_phone_number = sc11.nextLine();
				int user_age = 0;
				while(!validAge) {
					System.out.println("Age:");
				try{
					user_age = sc11.nextInt();
					sc11.nextLine();
					validAge = true;
				}catch(Exception ex) {
					System.out.println("Invalid input. Please enter valid number");
					sc11.nextLine();
				}
				
				}
				System.out.println("User Information: ");
				//sc11.next();
				String user_info = sc11.nextLine();
				System.out.print("User Password: ");
				System.out.println();
				String user_password = null;
				String currentPassword = null;
				while(!validation) {
					System.out.println("Enter Previous password: ");
					currentPassword = sc11.nextLine();
					
					if(DBConnect.authenticateUser(user_id, currentPassword)) {
						validation = true;
						System.out.println("Authentication successful!");
						System.out.println("Enter new password: ");
						user_password = sc11.nextLine();
						}else {
							System.out.println("Password is incorrect. Please try again...");
						}
				}
				
				User B = new User(user_id, user_name, user_email, user_phone_number, user_age, user_info, user_password);
				DBConnect.updateUser2(B);
				System.out.println();
							
							
						
						break;
				
			}

			case 3: {
				boolean flag=true;
				System.out.println("Enter ID to Show User: ");
				String user_id=sc6.nextLine();
				DBConnect.getUsersbyID(user_id);
				if(flag==false) {
					System.out.println("ID not found.....");
				}
				break;
			}
			}
			}
			break;
		}	
		
		}
		
		}
		
	}
}









