package programs;
import java.util.Scanner;
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Password: ");
        String passwordString = scanner.nextLine();
        char[] password = new char[passwordString.length()];
        for (int i = 0; i < passwordString.length(); i++) {
            password[i] = passwordString.charAt(i);
        }
        boolean[] checks = {false, false, false, false};
        for (char letter : password) {
            if (Character.isLowerCase(letter)) {
                checks[0] = true;
            } else if (Character.isUpperCase(letter)) {
                checks[1] = true;
            } else if (Character.isDigit(letter)) {
                checks[2] = true;
            }
        }
        if (passwordString.length() >= 8) {
            checks[3] = true;
        }
        boolean strong = checks[0] && checks[1] && checks[2] && checks[3];
        if (strong) {
            System.out.println("The password is strong.");
        } else {
            System.out.println("The password is weak.");
        }
        scanner.close();
    }
}