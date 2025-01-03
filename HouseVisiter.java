package programs;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class HouseVisiter {
    public static int resolution(Scanner scanner) {
        System.out.print("Size: ");
        return scanner.nextInt();
    }

    public static char[][] generate(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = 'E';
            }
        }
        return board;
    }

    public static int[] pos(Random random, int size){
        int x = random.nextInt(0,size-1);
        int y = random.nextInt(0, size-1);
        int[] coords = {x, y};
        return coords;
    }

    public static char[][] put(char[][] board, Random random) {
        int[] pos1 = pos(random, board.length);
        int[] pos2 = pos(random, board.length);
        int[] pos3 = pos(random, board.length);
        board[pos1[0]][pos1[1]] = 'A';
        board[pos2[0]][pos2[1]] = 'B';
        board[pos3[0]][pos3[1]] = 'C';
        return board;
    }

    public static char[][] putPlayer(char[][] board){
        board[0][0] = 'P';
        return board;
    }

    public static void showBoard(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[] decideDirection(String side){
        int[] dxDy = {0, 0};
        if (side.equals("left")){
            dxDy[1] = -1;
        }
        else if (side.equals("right")){
            dxDy[1] = 1;
        }
        else if (side.equals("up")){
            dxDy[0] = -1;
        }
        else if (side.equals("down")){
            dxDy[0] = 1;
        }
        return dxDy;
    }

    public static char[][] leaveRoad(int[] coords, char[][] board){
        board[coords[0]][coords[1]] = 'H';
        return board;
    }

    public static char[][] movePlayer(char[][] board, int[] currentCoord, int[] dxAndDy, ArrayList<Character> homesThatAreVisited){
        int[] newPos = {currentCoord[0]+dxAndDy[0], currentCoord[1]+dxAndDy[1]};
        if (homesThatAreVisited.contains(board[newPos[0]][newPos[1]])){
            return board;
        }
        if (board[newPos[0]][newPos[1]] == 'A' || board[newPos[0]][newPos[1]] == 'B' || board[newPos[0]][newPos[1]] == 'C'){
            homesThatAreVisited.add(board[newPos[0]][newPos[1]]);
        }
        board = leaveRoad(currentCoord, board);
        if (board[newPos[0]][newPos[1]] == 'A' || board[newPos[0]][newPos[1]] == 'B' || board[newPos[0]][newPos[1]] == 'C'){
            board[currentCoord[0]][currentCoord[1]] = board[newPos[0]][newPos[1]];
        }
        board[newPos[0]][newPos[1]] = 'P';
        return board;
    }

    public static boolean checkForWin(char[][] board){
        int homes = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == 'A' || board[i][j] == 'B' || board[i][j] == 'C'){
                    homes += 1;
                }
            }
        }
        return homes != 0;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int size = resolution(scanner);
        char[][] board = putPlayer(put(generate(size), random));
        int[] currentPlayer = {0, 0};
        int[] direction;
        ArrayList<Character> visitedHomes = new ArrayList<Character>();
        scanner.nextLine();
        while (checkForWin(board)) {
            try {
                showBoard(board);
                String directionString = scanner.nextLine();
                direction = decideDirection(directionString);
                board = movePlayer(board, currentPlayer, direction, visitedHomes);
                currentPlayer = new int[]{currentPlayer[0] + direction[0], currentPlayer[1] + direction[1]};
            }
            catch (ArrayIndexOutOfBoundsException e) {}
        }
        showBoard(board);
        System.out.println();
        System.out.println();
        System.out.println("Congratulations! You won a game of Mushroom Picker!");
        scanner.close();
    }
}