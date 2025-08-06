import java.util.Scanner;

public class AgeVerification {
	static void validate(int age) {
		if(age >= 18) {
			System.out.println("eligible");
		}else {
			System.out.println("Not eligible");
		}
		
	
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age:");
		validate(sc.nextInt());
}}
