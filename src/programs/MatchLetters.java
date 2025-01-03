package programs;
import java.util.Scanner;
import java.util.Random;

public class MatchLetters {
    public static char[] generate(Random random){
        int power;
        if (random.nextInt(0,1) == 1){
            power = 2;
        }
        else {
            power = 3;
        }
        char[] chars = new char[30];
        chars[random.nextInt(0,29)] = 'A';
        chars[random.nextInt(0,29)] = 'A';
        if (power == 3){
            chars[random.nextInt(0,29)] = 'A';
        }
        return chars;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        char[] letters = generate(random);
        int number;
        boolean done = false;
        long attempts = 0;
        while (!done){
            System.out.print("Guess (1-30): ");
            number = scanner.nextInt()-1;
            attempts += 1;
            if (letters[number] == 'A'){
                done = true;
            }
        }
        System.out.println();
        System.out.println("You guessed! But you needed "+attempts+" tries.");
        System.out.println();
        System.out.println("Well, here is the guessing string: ");
        for (int i = 0; i < letters.length; i++){
            System.out.print(letters[i]);
        }
        scanner.close();
    }
}
