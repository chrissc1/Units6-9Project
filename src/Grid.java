import java.util.Scanner;

public class Grid {
    private Player player;
    private Player playerDown;
    private Player playerLeft;
    private Player playerRight;
    private Space space;
    private Pellets pellet;
    private Ghost ghost;
    private Block block;
    private Space[][] grid;

    public Grid() {
        pellet = new Pellets(5);
        player = new Player("V");
        space = new Space("_");
        ghost = new Ghost();
        block = new Block();
    }

    public void play() {
        boolean play = true;
        int turns = 0;
        while (play) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Make a move.. (W, A, S, D: up, left, down, right)");
            String movement = scan.nextLine().toLowerCase();
            if (movement.equals("w")) {
                player.setSymbol("v");

            }
            if (movement.equals("a")) {
                player.setSymbol(">");
            }
            if (movement.equals("s")) {
                player.setSymbol("^");
            }
            if (movement.equals("d")) {
                player.setSymbol("<");
            }
        }
    }

    public void gridSetup(int map) {
        if (map == 1) {
            grid = new Space[9][9];
            for (int i = 0; i < grid.length; i++) {
                for (int k = 0; k < grid[i].length; k++) {
                    grid[i][k] = space;
                }
            }
            for (int row = 1; row < 8; row++) {
                grid[row][1] = block;
                grid[row][4] = block;
                grid[row][7] = block;
                grid[4][row] = block;
            }
            grid[1][2] = block;
            grid[1][6] = block;
            grid[7][2] = block;
            grid[7][6] = block;
            addPellets(12, 9, 9);
        } else if (map == 2) {
            grid = new Space[9][10];
            for (int i = 0; i < grid.length; i++) {
                for (int k = 0; k < grid[i].length; k++) {
                    grid[i][k] = space;
                }
            }
            for (int row = 1; row < 5; row++) {
                grid[row][2] = block;
                grid[row][6] = block;
            }
            for (int row = 3; row < 7; row++) {
                grid[row][4] = block;
            }
            for (int col = 2; col < 7; col++) {
                grid[2][col] = block;
            }
            for (int col = 2; col < 7; col++) {
                grid[7][col] = block;
            }
            grid[8][2] = block;
            grid[8][6] = block;
            grid[7][4] = space;
            addPellets(15,9,10);
        } else if (map == 3) {
            grid = new Space[11][11];
            for (int i = 0; i < grid.length; i++) {
                for (int k = 0; k < grid[i].length; k++) {
                    grid[i][k] = space;
                }
            }
            for (int col = 1; col < 10; col++) {
                grid[1][col] = block;
                if (col >= 3 && col <= 7) {
                    grid[3][col] = block;
                }
                if (col >= 3) {
                    grid[7][col] = block;
                }
            }
        }
    }

    public void printGrid() {
        for (int row = 0 ; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col].getSymbol() + "  ");
            }
            System.out.println();
        }
    }

    public void addPellets(int numPellets,int rows,int cols) {
        for (int i = 0; i < numPellets; i++) {
            int row = (int) (Math.random() * rows);
            int col = (int) (Math.random() * cols);
            if (grid[row][col] == space) {
                grid[row][col] = pellet;
            } else {
                i--;
            }
        }
    }


}
//        _  _  _  _  _  _  _  _  _  _  _
//        _  █  █  █  █  █  █  █  █  █  _
//        _  █  _  _  _  _  _  _  _  █  _
//        _  █  _  █  █  █  █  █  _  █  _
//        _  █  _  █  _  _  _  █  _  █  _
//        _  █  _  █  _  █  █  █  _  █  _
//        _  █  _  █  _  _  _  _  _  █  _
//        _  █  _  █  █  █  █  █  █  █  _
//        _  █  _  _  _  _  _  _  _  _  _
//        _  █  █  █  █  █  █  █  _  _  _
//        _  _  _  _  _  _  _  _  _  _  _

//        *  *  _  _  _  _  _  *  *
//        *  _  █  _  _  _  █  _  *
//        _  _  █  _  _  _  █  _  _
//        _  _  █  █  █  █  █  _  _
//        _  _  _  _  █  _  _  _  _
//        _  _  _  _  █  _  _  _  _
//        _  _  _  _  █  _  _  _  _
//        *  _  █  █  _  █  █  _  *
//        *  *  █  _  _  _  █  *  *
//        _  _  _  _  _  _  _  _  _



//        *  *  _  _  _  _  _  *  *
//        *  █  █  _  █  _  █  █  *
//        _  █  _  _  █  _  _  █  _
//        _  █  _  _  █  _  _  █  _
//        _  █  █  █  █  █  █  █  _
//        _  █  _  _  █  _  _  █  _
//        _  █  _  _  █  _  _  █  _
//        *  █  █  _  █  _  █  █  *
//        *  *  _  _  _  _  _  *  *