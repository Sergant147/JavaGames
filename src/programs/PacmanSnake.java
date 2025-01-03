package programs;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class PacmanSnake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Board Size: ");
        int size = scanner.nextInt();
        char[][] board = new char[size][size];
        ArrayList<int[]> snake = new ArrayList<>();
        snake.add(new int[]{size / 2, size / 2});
        Random random = new Random();
        int foodX = random.nextInt(size), foodY = random.nextInt(size);
        while (true) {
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    board[i][j] = ' ';
            for (int[] part : snake)
                board[part[0]][part[1]] = 'З';
            board[foodX][foodY] = 'Я';
            for (int i = 0; i < size + 2; i++){
                System.out.print('_');
            }
            System.out.println();
            for (int i = 0; i < size; i++) {
                System.out.print('|');
                for (int j = 0; j < size; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.print("|");
                System.out.println();
            }
            for (int i = 0; i < size + 2; i++){
                System.out.print('_');
            }
            System.out.println();
            System.out.print("Enter move (НВПЛ): ");
            char move = scanner.next().charAt(0);
            int[] head = snake.get(0).clone();
            switch (move) {
                case 'в': head[0]--; break;
                case 'н': head[0]++; break;
                case 'л': head[1]--; break;
                case 'п': head[1]++; break;
            }
            if (head[0] == -1){
                head[0] = size-1;
            }
            if (head[0] == size){
                head[0] = 0;
            }
            if (head[1] == -1){
                head[1] = size-1;
            }
            if (head[1] == size){
                head[1] = 0;
            }
            if (head[0] < 0 || head[0] >= size || head[1] < 0 || head[1] >= size ||
                    snake.stream().anyMatch(part -> part[0] == head[0] && part[1] == head[1])) {
                System.out.println("Game Over!");
                break;
            }
            snake.add(0, head);
            if (head[0] == foodX && head[1] == foodY) {
                foodX = random.nextInt(size);
                foodY = random.nextInt(size);
            } else {
                snake.remove(snake.size() - 1);
            }
        }
        scanner.close();
    }
}