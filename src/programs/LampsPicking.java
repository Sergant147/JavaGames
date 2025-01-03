package programs;
import java.util.Scanner;
public class LampsPicking {
    public static void show(String[] row){
        System.out.println();
        for (int i = 0; i < row.length; i++){
            System.out.print(row[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String target = "\uD83D\uDCA1";
        String player = "\uD83D\uDC64";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Row Size: ");
        int brain = 0;
        int size = scanner.nextInt();
        System.out.println();
        String[] SetUpRow = new String[size];
        for (int i = 0; i < size; i++) {
            SetUpRow[i] = target;
        }
        SetUpRow[0] = player;
        String[] row = SetUpRow.clone();
        String direction;
        int dx = 0;
        int index = 0;
        scanner.nextLine();
        while (brain < size - 1){
            show(SetUpRow);
            System.out.print("Direction (DA): ");
            direction = scanner.nextLine();
            System.out.println();
            if (direction.equals("d")){
                dx = 1;
            }
            else if (direction.equals("a")){
                dx = -1;
            }
            row[index] = " ";
            if (row[index+dx].equals(target)){
                brain += 1;
            }
            row[index+dx] = player;
        }
        System.out.println("Congratulations! You are very smart by now! Because you won a game of Lamps Picking!");
        scanner.close();
    }
}