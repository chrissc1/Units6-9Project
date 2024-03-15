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

    public void gridSetup() {
        grid = new Space[10][10];
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {
                grid[i][k] = space;
            }
        }
        for (int col = 0; col < 6; col++) {
            grid[0][col] = block;
        }
        for (int row = 0; row < 5; row++) {
            grid[row][5] = block;
        }
        for (int row = 4; row < 7; row++) {
            for (int col = 1; col < 5; col++) {
                grid[row][col] = block;
            }
        }
        for (int col = 1; col < 9; col++) {
            grid[8][col] = block;
        }
        for (int row = 4; row < 7; row++) {
            grid[row][8] = block;
        }
        grid[4][7] = block;
        grid[6][9] = block;
        grid[9][5] = playerRight;
        grid[6][6] = ghost;
        for (int i = 0; i < 20; i++) {
            int row = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            if (grid[row][col] == space) {
                grid[row][col] = pellet;
            } else {
                i--;
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