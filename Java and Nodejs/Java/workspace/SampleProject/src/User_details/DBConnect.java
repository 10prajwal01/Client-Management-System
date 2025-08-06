package User_details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
	
	public static void passwordAdmin(){
		String username = "admin";
        String password = "admin";
        System.out.println("Enter your Admin ID:");
		Scanner sc = new Scanner(System.in);
        String user = sc.next();
        boolean loggedIn = false;
        
        while(!loggedIn) {
        JPasswordField passwordField = new JPasswordField();
        int result = JOptionPane.showConfirmDialog(null, passwordField, "Enter password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
 
        if (result == JOptionPane.OK_OPTION) {
            String passwrd = new String(passwordField.getPassword());
 
            if (!user.equals(username) || !passwrd.equals(password)) {
                System.out.println("Invalid username or password. Try again..");
            }else {
            	System.out.println("Login successful!");
                loggedIn = true;
            }
        } else {
            System.out.println("Password input canceled.");
            sc.close();
            System.exit(1);
        }
        }
        
        
	}


	public static void passwordUser() {
	    String url = "jdbc:mysql://localhost:3306/users_db";
	    String usernameDB = "root";
	    String passwordDB = "admin";

	    String query = "SELECT user_password FROM users WHERE user_id = ?";

	    try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
	         PreparedStatement statement = connection.prepareStatement(query)) {

	        Scanner sc = new Scanner(System.in);

	        boolean loggedIn = false;

	        while (!loggedIn) {
	            System.out.println("Enter your User ID:");
	            String user = sc.next();
	            statement.setString(1, user);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    String userPassword = resultSet.getString("user_password");

	                    JPasswordField passwordField = new JPasswordField();
	                    int result = JOptionPane.showConfirmDialog(null, passwordField, "Enter password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

	                    if (result == JOptionPane.OK_OPTION) {
	                        String passwrd = new String(passwordField.getPassword());

	                        if (!passwrd.equals(userPassword)) {
	                            System.out.println("Invalid password");
	                        } else {
	                            System.out.println("Login successful!");
	                            loggedIn = true; // Set loggedIn to true to exit the loop
	                        }
	                    } else {
	                        System.out.println("Password input canceled.");
	                        System.exit(1);
	                    }
	                } else {
	                    System.out.println("User not found.");
	                }
	            } catch (SQLException e) {
	                System.out.println("Error retrieving user information.");
	                e.printStackTrace();
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Database connection failed.");
	        e.printStackTrace();
	    }
	}

	
	
static public boolean authenticateUser(String user_id, String user_password) {
	String url = "jdbc:mysql://localhost:3306/users_db";
	String user = "root";
	String pass = "admin";
	
	try {
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement statement = con.prepareStatement("SELECT * FROM users WHERE user_id = ? AND user_password = ?");
		
		statement.setString(1, user_id);
        statement.setString(2, user_password);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
	}catch(Exception ex) {
		ex.printStackTrace();
		return false;
	}
}
	
	
	
	static public void insertData(User User) {
		
		String url = "jdbc:mysql://localhost:3306/users_db";
		String user = "root";
		String pass = "admin";
		
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "INSERT INTO users(user_id, user_name, user_email, user_phone_number, user_age, user_info, user_password) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			//System.out.println(User.getUser_id());
			if (User.getUser_id() != null) {
		        ps.setString(1, User.getUser_id());
		    } else {
		        // Handle the situation where user_id is null
		        // You may throw an exception, log an error, or take other appropriate action
		        throw new IllegalArgumentException("User ID cannot be null");
		    }
			ps.setString(2,User.getUser_name());
			ps.setString(3,User.getUser_email());
			ps.setString(4, User.getUser_phone_number());
			ps.setInt(5,User.getUser_age());
			ps.setString(6,User.getUser_info());
			ps.setString(7,User.getUser_password());
			
	        int rowsInserted = ps.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("User Inserted Successfully");
	        } else {
	            System.out.println("Failed to insert user");
	        }
	        ps.close();
	        con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void getAllUsers() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","admin");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			// Print the separator line
			if (!rs.isBeforeFirst()) {
		        System.out.println("No users available in the database");
		    } else {
			System.out.println("All Users: ");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

			// Print the table header
			System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-5s | %-50s |\n", 
			        "User ID", "User Name", "User Email", "User Phone Number", "User Age", "User Information");

			// Print the separator line
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

			// Iterate over the ResultSet and print each row
			while (rs.next()) {
			    System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-5s | %-50s |\n",
			            rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}

			// Print the separator line
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		    }
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void getUsersbyID(String user_id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","admin");
			Statement stmt = con.createStatement();
			String query = String.format("SELECT * FROM users WHERE user_id = \"%s\"", user_id);
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()== false) {
				System.out.println("User ID does not exist.");
				
			}else {
				// Print the separator line
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

				// Print the table header
				System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-5s | %-50s |\n", 
				        "User ID", "User Name", "User Email", "User Phone Number", "User Age", "User Information");

				// Print the separator line
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

				// Iterate over the ResultSet and print each row
				
				    System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-5s | %-50s |\n",
				            rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				

				// Print the separator line
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

				
			}
			
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	static public void updateUser1(User User) {
		
		String url = "jdbc:mysql://localhost:3306/users_db";
		String user = "root";
		String pass = "admin";
		
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement ps = con.createStatement();
			
			String query2 = String.format("SELECT * FROM users WHERE user_id = \"%s\"", User.getUser_id());
			ResultSet rs = ps.executeQuery(query2);
			if(rs.next()== false) {
				System.out.println("User ID does not exist");
			}else {
				String query = String.format("UPDATE users SET user_name = \"%s\", user_email = \"%s\", user_phone_number = \"%s\", user_age = %d, user_info = \"%s\" WHERE user_id = \"%s\"", 
						User.getUser_name(),User.getUser_email(),User.getUser_phone_number(),User.getUser_age(),User.getUser_info(),User.getUser_id());
				ps.executeUpdate(query);
				System.out.println("User ID "+ User.getUser_id() +" got updated.");
				
			}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteUsersbyID(String user_id) {
		String url = "jdbc:mysql://localhost:3306/users_db";
		String user = "root";
		String pass = "admin";
		
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "DELETE FROM users WHERE user_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,user_id);
			int rowsDeleted = ps.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("User with ID " + user_id + " deleted successfully.");
	        } else {
	            System.out.println("User with ID " + user_id + " not found.");
	        }
			ps.close();
	        con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
static public void updateUser2(User User) {
		
	String url = "jdbc:mysql://localhost:3306/users_db";
	String user = "root";
	String pass = "admin";
	
	try {
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement ps = con.createStatement();
		
		String query2 = String.format("SELECT * FROM users WHERE user_id = \"%s\"", User.getUser_id());
		ResultSet rs = ps.executeQuery(query2);
		if(rs.next()== false) {
			System.out.println("User ID does not exist");
		}else {
			String query = String.format("UPDATE users SET user_name = \"%s\", user_email = \"%s\", user_phone_number = \"%s\", user_age = %d, user_info = \"%s\", user_password = \"%s\" WHERE user_id = \"%s\"", 
					User.getUser_name(),User.getUser_email(),User.getUser_phone_number(),User.getUser_age(),User.getUser_info(),User.getUser_password(),User.getUser_id());
			ps.executeUpdate(query);
			System.out.println("User ID "+ User.getUser_id() +" got updated.");
			
		}
			con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
