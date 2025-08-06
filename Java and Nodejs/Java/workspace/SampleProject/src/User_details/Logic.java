package User_details;
import java.util.Random;
import java.util.ArrayList;

public class Logic {
	public static ArrayList<User> userList = new ArrayList<User>();

	public static void addUser(User A) {
		userList.add(A);
	}

	public static void removeUser(User A) {
		userList.remove(A);
	}

	public static void showDetailsAdmin() {
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-5s | %-50s |\n", 
		    "User ID", "User Name", "User Email", "User Phone Number", "User Age", "User Infomation");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (User A : userList) {
		    System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-5s | %-50s |\n",
		        A.getUser_id(), A.getUser_name(), A.getUser_email(), 
		        A.getUser_phone_number(), A.getUser_age(), A.getUser_info());
		}

		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

	}
	public static void showDetailsUser(User B) {
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-5s | %-50s |\n", 
		    "User ID", "User Name", "User Email", "User Phone Number", "User Age", "User Infomation");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (User A : userList) {
		    if (A.getUser_id() == B.user_id) {
		        System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-5s | %-50s |\n",
		            A.getUser_id(), A.getUser_name(), A.getUser_email(), 
		            A.getUser_phone_number(), A.getUser_age(), A.getUser_info());
		    }
		}

		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");

		//for (User A : userList) {
			//if(A.getUser_id() == B.user_id) {
			//System.out.println("User ID: " + A.getUser_id());
			//System.out.println("User Name: " + A.getUser_name());
			//System.out.println("User Email: " + A.getUser_email());
			//System.out.println("User Phone Number: " + A.getUser_phone_number());
			//System.out.println("User Age: " + A.getUser_age());
			//System.out.println("User Information: " + A.getUser_info());
			//}
		//}
	}
	public static void updateUser(User A) {
		for(User B: userList) {
			if(B.getUser_id() == A.user_id) {
				B.setUser_name(A.user_name);
				B.setUser_email(A.user_email);
                B.setUser_phone_number(A.user_phone_number);
                B.setUser_age(A.user_age);
                B.setUser_info(A.user_info);
                B.setUser_password(A.user_password);
                break;
			}
		}
	}
	
	public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
	}
}
