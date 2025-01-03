package programs;
import java.util.Scanner;
import java.util.Random;
public class Hacker {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Min Value: ");
        int minimum = scanner.nextInt();
        System.out.print("Max Value: ");
        int maximum = scanner.nextInt();
        int value = random.nextInt(minimum, maximum);
        long attempts = 0;
        boolean done = false;
        int guess;
        while (!done){
            System.out.print("Guess: ");
            guess = scanner.nextInt();
            if (guess > value){
                System.out.println("You guessed a number that is too big!");
            }
            else if (guess < value){
                System.out.println("You guessed a number that is too little!");
            }
            if (guess == value){
                done = true;
            }
            attempts += 1;
        }
        System.out.println("You've finally guessed! You needed "+attempts+" tries!");
        System.out.println("Poor programs.Hacker!");
        scanner.close();
    }
}
