package programs;
import java.util.Random;
import java.util.Scanner;
class Cells {
    public Cells(){}
    public String player = "🟦";
    public String wall = "🟥";
    public String mushroom = "🟩";
    public String empty = "⬛";
    public String road = "🟪";
}

class BoardGenerator {
    public BoardGenerator(){}
    public String[][] generate(short size, Random random){
        Cells cells = new Cells();
        String[][] maze = new String[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                maze[i][j] = cells.empty;
            }
        }
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (random.nextInt(1,1000) < 300) {
                    if (random.nextInt(1,100) > 50){
                        maze[i][j] = cells.wall;
                    }
                    if (random.nextInt(1,100) > 50){
                        maze[i][j] = cells.mushroom;
                    }
                }
            }
        }
        maze[0][0] = cells.player;
        return maze;
    }
}

class Player {
    public int[] pos;
    public int countOfWallsToBreak;
    public Player(int[] pos, int countOfWallsThatICanBreak){
        this.pos = pos;
        this.countOfWallsToBreak = countOfWallsThatICanBreak;
    }
    public String[][] leaveRoad(String[][] board){
        Cells cells = new Cells();
        board[this.pos[0]][this.pos[1]] = cells.road;
        return board;
    }
    public int[] decideDxAndDy(String dir){
        int[] res = {0, 0};
        if (dir.equals("left")){
            res[1] = -1;
        }
        else if (dir.equals("right")){
            res[1] = 1;
        }
        else if (dir.equals("up")){
            res[0] = -1;
        }
        else {
            res[0] = 1;
        }
        return res;

    }
    public int[] getNewPosition(int[] oldPosition, int[] shift, String[][] board){
        int[] res = {oldPosition[0]+shift[0], oldPosition[1]+shift[1]};
        if (res[0] < 0){
            res[0] = board.length - Math.abs(res[0]);
        }
        else if (res[1] < 0){
            res[1] = board.length - Math.abs(res[1]);
        }
        if (res[1] > board.length - 1){
            res[1] = 0;
        }
        else if (res[0] > board.length - 1){
            res[0] = 0;
        }
        return res;
    }
    public String[][] move(String direction, String[][] board){
        Cells cells = new Cells();
        int[] dir = this.decideDxAndDy(direction);
        int[] newPos = this.getNewPosition(this.pos, dir, board);
        String elementToMoveInto = board[newPos[0]][newPos[1]];
        if (elementToMoveInto.equals(cells.wall) && this.countOfWallsToBreak <= 0){
            return board;
        }
        if (elementToMoveInto.equals(cells.wall) && this.countOfWallsToBreak > 0){
            this.countOfWallsToBreak--;
        }
        board = this.leaveRoad(board);
        board[newPos[0]][newPos[1]] = cells.player;
        this.pos = newPos;
        return board;
    }

}

public class Maze {
    public static void showBoard(String[][] maze, Player player) {
        System.out.println("You have "+player.countOfWallsToBreak+" more walls that you could break.");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public static boolean isDone(String[][] board){
        short mushrooms = 0;
        Cells cells = new Cells();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == cells.mushroom){
                    mushrooms += 1;
                }
            }
        }
        return mushrooms == 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        BoardGenerator boardGenerator = new BoardGenerator();
        int[] startPos = {0, 0};
        System.out.print("Walls you can break over the game: ");
        int powerLevel = scanner.nextInt();
        Player player = new Player(startPos, powerLevel);
        System.out.print("What size of the board do you prefer: ");
        short size = scanner.nextShort();
        System.out.println();
        String[][] maze = boardGenerator.generate(size, random);
        String direction;
        scanner.nextLine();
        while (!isDone(maze)){
           showBoard(maze, player);
           direction = scanner.nextLine();
           maze = player.move(direction, maze);
        }
        System.out.println();
        showBoard(maze, player);
        System.out.println();
        System.out.println();
        System.out.println("Congratulations! You won a game of Maze Mushroom Picker!");
        scanner.close();
    }
}
