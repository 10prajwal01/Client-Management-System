import java.io.Console;
import java.util.Scanner;
public class abc {
	public static void main(String[] args) {
        Console console = System.console();
        
//        char[] passwordArray = console.readPassword("Enter your password: ");
//        String password = new String(passwordArray);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password:");
        String pwd = sc.nextLine();
        System.out.print("Your password is: ");
        for (char c : pwd.toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }
}
