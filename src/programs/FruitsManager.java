package programs;
import java.util.Scanner;
import java.util.ArrayList;
public class FruitsManager {
    public static void showFruits(ArrayList<String> fruits){
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
    public static ArrayList<String> removeFruit(String fruit, ArrayList<String> fruits){
        fruits.remove(fruit);
        return fruits;
    }
    public static ArrayList<String> addFruit(String fruit, ArrayList<String> fruits){
        fruits.add(fruit);
        return fruits;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> fruits = new ArrayList<String>();
        String command;
        String fruit;
        while (true){
            System.out.print("Command (remove, add, show, stop): ");
            command = scanner.nextLine();
            if (command.equals("show")){
                showFruits(fruits);
            }
            else if (command.equals("add")){
                System.out.print("Fruit to add: ");
                fruit = scanner.nextLine();
                fruits = addFruit(fruit, fruits);
            }
            else if (command.equals("stop")){
                break;
            }
            else {
                System.out.print("Fruit to remove: ");
                fruit = scanner.nextLine();
                fruits = removeFruit(fruit, fruits);
            }
        }
        scanner.close();
    }
}
