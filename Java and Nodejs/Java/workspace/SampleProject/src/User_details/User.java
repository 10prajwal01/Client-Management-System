package User_details;

public class User {
		String user_id;
		String user_name;
		String user_email;
		String user_phone_number;
		int user_age;
		String user_info;
		String user_password;
		
		public User(String user_id,String user_name, 
				String user_email, String user_phone_number, int user_age,
				String user_info,String user_password) {
			
			this.user_id = user_id;
			this.user_name = user_name;
			this.user_email = user_email;
			this.user_phone_number = user_phone_number;
			this.user_age = user_age;
			this.user_info=user_info;
			this.user_password=user_password;
			
	}
		
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}
		public String getUser_phone_number() {
			return user_phone_number;
		}
		public void setUser_phone_number(String user_phone_number) {
			this.user_phone_number = user_phone_number;
		}
		public int getUser_age() {
			return user_age;
		}
		public void setUser_age(int user_age) {
			this.user_age = user_age;
		}
		public String getUser_info() {
			return user_info;
		}
		public void setUser_info(String user_info) {
			this.user_info = user_info;
		}
		public String getUser_password() {
			return user_password;
		}
		public void setUser_password(String user_password) {
			this.user_password = user_password;
		}
		
		
		

	}



