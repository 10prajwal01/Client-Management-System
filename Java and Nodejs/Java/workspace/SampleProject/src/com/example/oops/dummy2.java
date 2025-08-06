package User_details;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Main {
	
	public static void passwordAdmin(){
		String username = "admin";
        String password = "admin";
        
		System.out.println("Enter your Username:");
		Scanner sc = new Scanner(System.in);
        String user = sc.next();
 
        JPasswordField passwordField = new JPasswordField();
        int result = JOptionPane.showConfirmDialog(null, passwordField, "Enter password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
 
        if (result == JOptionPane.OK_OPTION) {
            String passwrd = new String(passwordField.getPassword());
 
            if (!user.equals(username) || !passwrd.equals(password)) {
                System.out.println("Invalid username or password");
                sc.close();
                System.exit(0);
            }
        } else {
            System.out.println("Password input canceled.");
            sc.close();
            System.exit(1);
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------");
		System.out.println("Welome to User Management");
		System.out.println("-------------------------");
		System.out.println();
		while(true) {
		char mainMenu;
		
		System.out.println("Are you a admin or user?");
		Scanner sc = new Scanner(System.in);
		String admin = "admin";
		String password = "User123";
		if(Objects.equals(admin, sc.nextLine())) {
			passwordAdmin();
			System.out.println();
			while (true) {
				int input;
				
				try {
					System.out.println("Select 1:Add user, 2: Remove User, 3:Update User, 4:Show Users, 0:Exit");
					input = sc.nextInt();
					sc.nextLine();
				}
				catch(Exception e) {
					System.out.println("Enter valid input.");
					sc.nextLine();
					continue;
				}
				
				if (input == 0) {
					System.out.println("Thank you for the visit.....");
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
					System.out.println("Defauld Password: "+ password);
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
					System.out.println("All Users: ");
					System.out.println();
					for (User u : Logic.userList) {
								Logic.showDetailsAdmin();
								break;
								
					}
				}

				}
			}
		}else {
			System.out.println();
			while (true) {
				int input;
				
				try {
					System.out.println("Select 1: Remove User, 2:Update User, 3:Show User, 0:Exit");
					input = sc.nextInt();
					sc.nextLine();
				}
				catch(Exception e) {
					System.out.println("Enter valid input.");
					sc.nextLine();
					continue;
				}
				
				if (input == 0) {
					System.out.println("Thank you for the visit.....");
					break;
				}
				
				switch (input) {

				case 1: {
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
				
				case 2:{
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
								System.out.println("User Password: ");
								System.out.println("Enter Previous password: ");
								String currentPassword = sc.nextLine();
								while(true){
									if(Objects.equals(currentPassword, password)) {
									System.out.println("Enter new password: ");
									u.setUser_password(sc.nextLine());
								}else {
									System.out.println("Password is incorrect.");
									}
									break;
								}
								Logic.updateUser(u);;
								break;
								}
							}
							if(flag==false) {
								System.out.println("ID not found.....");
							}break;
					
				}

				case 3: {
					boolean flag=false;
					System.out.println("Enter ID to Show User: ");
					System.out.println();
					String temp=sc.next();
					for (User u : Logic.userList) {
							if(Objects.equals(u.getUser_id(), temp)) {
								flag=true;
								Logic.showDetailsUser(u);
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