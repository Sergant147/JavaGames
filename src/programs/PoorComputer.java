package programs;
import java.util.Scanner;
import java.util.Random;
public class PoorComputer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Value: ");
        int value = scanner.nextInt();
        System.out.print("Min Value: ");
        int minimum = scanner.nextInt();
        System.out.print("Max Value: ");
        int maximum = scanner.nextInt();
        scanner.close();
        long attempts = 0;
        Random random = new Random();
        boolean done = false;
        int number;
        while (!done){
            number = random.nextInt(minimum, maximum);
            System.out.println("I guessed "+number+'!');
            attempts += 1;
            if (number == value){
                done = true;
            }
        }
        System.out.println("I did that! I needed "+attempts+" tries.");
        System.out.println("Poor computer!");
    }
}