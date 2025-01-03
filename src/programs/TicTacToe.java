package programs;
import java.util.Scanner;

public class TicTacToe {
    public static boolean heWon(char[][] board, char curP) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == curP && board[i][1] == curP && board[i][2] == curP) ||
                    (board[0][i] == curP && board[1][i] == curP && board[2][i] == curP)) {
                return true;
            }
        }
        if ((board[0][0] == curP && board[1][1] == curP && board[2][2] == curP) ||
                (board[0][2] == curP && board[1][1] == curP && board[2][0] == curP)) {
            return true;
        }
        return false;
    }
    public static boolean isFullBoard(char[][] board){
        int emptyCells = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == ' '){
                    emptyCells += 1;
                }
            }
        }
        return emptyCells == 0;
    }
    public static void showBoard(char[][] board){
        System.out.println("__________");
        for (int i = 0; i < 3; i++){
            System.out.print("|");
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
        System.out.println("__________");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';
        String status;
        int[] where = {0, 0};
        while (true){
            System.out.println("Move of "+currentPlayer);
            showBoard(board);
            System.out.print("X pos where to paste: ");
            where[0] = scanner.nextInt()-1;
            System.out.print("Y pos where to paste: ");
            where[1] = scanner.nextInt()-1;
            if (board[where[1]][where[0]]!=' '){
                System.out.println();
                System.out.println("Not ABLE to move THERE!");
                System.out.println();
            }
            else{
                board[where[1]][where[0]] = currentPlayer;
            }
            if (heWon(board, currentPlayer)){
                status = currentPlayer + " won!";
                break;
            }
            if (isFullBoard(board)){
                status = "Tie!";
                break;
            }
            if (currentPlayer == 'X'){
                currentPlayer = 'O';
            }
            else{
                currentPlayer = 'X';
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Game Status: "+status);
        System.out.println("You did a good job! Have a nice day! Thank you for playing! Bye!");
        scanner.close();
    }
}
