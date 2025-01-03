package programs;
import java.util.Scanner;
public class ComputerNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Min Value: ");
        int l = scanner.nextInt();
        System.out.print("Max Value: ");
        int r = scanner.nextInt();
        long attempts = 0;
        int guess;
        String result;
        scanner.nextLine();
        while (l < r){
            guess = (Integer)(l+r)/2;
            System.out.println("My Guess: "+guess);
            System.out.print("Enter your answer (B,S,E): ");
            result = scanner.nextLine().trim();
            System.out.println();
            attempts += 1;
            if (result.equals("S")){
                r = guess+1;
            }
            else if (result.equals("B")){
                l = guess-1;
            }
            else break;
        }
        System.out.println("I finally guessed! I needed "+attempts+" tries");
        scanner.close();
    }
}
