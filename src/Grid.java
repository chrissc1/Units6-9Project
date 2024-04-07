import java.util.Arrays;
import java.util.Scanner;

public class Grid {
    private final Player player;
    private final Space space;
    private Pellets pellet;
    private final Block block;
    private Space[][] grid;
    private final int[] pos;
    private int point;
    private int score;
    private int highScore;

    public Grid() {
        player = new Player("V");
        space = new Space("_");
        block = new Block();
        pos = new int[2];
        highScore = -10000;
    }

    public void play() {
        boolean play = true;
        printGrid();
        int turns = 0;
        while (play) {
            if (score == 100) {
                score = 0;
            }
            System.out.println("Score: " + score);
            Scanner scan = new Scanner(System.in);
            System.out.println("Make a move.. (W, A, S, D: up, left, down, right)");
            String movement = scan.nextLine().toLowerCase();
            turns++;
            if (movement.equals("w")) {
                player.setSymbol("v");
                if (pos[0] > 0) {
                    if (grid[pos[0] - 1][pos[1]] == block) {
                        printGrid();
                        System.out.println("A wall is preventing you from moving that way!");
                    } else if (grid[pos[0] - 1][pos[1]] == pellet) {
                        score += point;
                        grid[pos[0]][pos[1]] = space;
                        pos[0] -= 1;
                        grid[pos[0]][pos[1]] = player;
                        printGrid();
                        System.out.println(point + " points gained!");
                    } else if (grid[pos[0] - 1][pos[1]] == space) {
                        grid[pos[0]][pos[1]] = space;
                        pos[0] -= 1;
                        grid[pos[0]][pos[1]] = player;
                        printGrid();
                    }
                } else {
                    printGrid();
                    System.out.println("Can't go that way");
                }
            }
            if (movement.equals("a")) {
                player.setSymbol(">");
                if (pos[1] > 0) {
                    if (grid[pos[0]][pos[1] - 1] == block) {
                        printGrid();
                        System.out.println("A wall is preventing you from moving that way!");
                    } else if (grid[pos[0]][pos[1] - 1] == pellet) {
                        score += point;
                        grid[pos[0]][pos[1]] = space;
                        pos[1] -= 1;
                        grid[pos[0]][pos[1]] = player;
                        printGrid();
                        System.out.println(point + " points gained!");
                    } else if (grid[pos[0]][pos[1] - 1] == space) {
                        grid[pos[0]][pos[1]] = space;
                        pos[1] -= 1;
                        grid[pos[0]][pos[1]] = player;
                        printGrid();
                    }
                } else {
                    printGrid();
                    System.out.println("Can't go that way");
                }
            }
            if (movement.equals("s")) {
                player.setSymbol("^");
                if (pos[0] < grid.length - 1) {
                    if (grid[pos[0]+1][pos[1]] == block) {
                        printGrid();
                        System.out.println("A wall is preventing you from moving that way!");
                    } else if (grid[pos[0]+1][pos[1]] == pellet) {
                        score += point;
                        grid[pos[0]][pos[1]] = space;
                        pos[0] += 1;
                        grid[pos[0]][pos[1]] = player;
                        printGrid();
                        System.out.println(point + " points gained!");
                    } else if (grid[pos[0]+1][pos[1]] == space) {
                        grid[pos[0]][pos[1]] = space;
                        pos[0] += 1;
                        grid[pos[0]][pos[1]] = player;
                        printGrid();
                    }
                } else {
                    printGrid();
                    System.out.println("Can't go that way");
                }
            }
            if (movement.equals("d")) {
                player.setSymbol("<");
                if (pos[1] < grid[0].length - 1) {
                    if (grid[pos[0]][pos[1] + 1] == block) {
                        printGrid();
                        System.out.println("A wall is preventing you from moving that way!");
                    } else if (grid[pos[0]][pos[1] + 1] == pellet) {
                        score += point;
                        grid[pos[0]][pos[1]] = space;
                        pos[1] += 1;
                        grid[pos[0]][pos[1]] = player;
                        printGrid();
                        System.out.println(point + " points gained!");
                    } else if (grid[pos[0]][pos[1] + 1] == space) {
                        grid[pos[0]][pos[1]] = space;
                        pos[1] += 1;
                        grid[pos[0]][pos[1]] = player;
                        printGrid();
                    }
                } else {
                    printGrid();
                    System.out.println("Can't go that way");
                }
            }
            if (score == 100) {
                play = false;
                System.out.println("You win! It took a total of " + turns + " turns!");
                if (highScore == -10000) {
                    System.out.println("You've reached a new high score!\nHigh score: " + turns);
                    highScore = turns;
                } else if (highScore > turns) {
                    System.out.println("You've reached a new high score!\nPrevious high score: " + highScore);
                    highScore = turns;
                    System.out.println("New high score: " + highScore);
                } else {
                    System.out.println("High score: " + highScore);
                }
                System.out.println("Would you like to play again? (y/n)");
                String ans = scan.nextLine().toLowerCase();
                if (ans.equals("y")) {
                    System.out.println("Which map would you like to play? (1, 2, or 3)");
                    int map = scan.nextInt();
                    gridSetup(map);
                } else {
                    System.out.println("Have a nice day!");
                }
            }
        }
    }

    public void gridSetup(int map) {
        if (map == 1) {
            grid = new Space[9][9];
            for (Space[] spaces : grid) {
                Arrays.fill(spaces, space);
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
            int rand = (int) (Math.random() * 4);
            if (rand == 0) {
                pellet = new Pellets(10);
                point = pellet.pointValue();
                grid = addPellets(10, grid);
            } else if (rand == 1) {
                pellet = new Pellets(20);
                point = pellet.pointValue();
                grid = addPellets(20, grid);
            } else if (rand == 2) {
                pellet = new Pellets(25);
                point = pellet.pointValue();
                grid = addPellets(25, grid);
            }
        } else if (map == 2) {
            grid = new Space[10][9];
            for (Space[] spaces : grid) {
                Arrays.fill(spaces, space);
            }
            for (int row = 1; row < 4; row++) {
                grid[row][2] = block;
                grid[row][6] = block;
            }
            for (int row = 3; row < 7; row++) {
                grid[row][4] = block;
            }
            for (int col = 2; col < 7; col++) {
                grid[3][col] = block;
            }
            for (int col = 2; col < 7; col++) {
                grid[7][col] = block;
            }
            grid[8][2] = block;
            grid[8][6] = block;
            grid[7][4] = space;
            int rand = (int) (Math.random() * 4);
            if (rand == 0) {
                pellet = new Pellets(10);
                point = pellet.pointValue();
                grid = addPellets(10, grid);
            } else if (rand == 1) {
                pellet = new Pellets(20);
                point = pellet.pointValue();
                grid = addPellets(20, grid);
            } else if (rand == 2) {
                pellet = new Pellets(25);
                point = pellet.pointValue();
                grid = addPellets(25, grid);
            }
        } else if (map == 3) {
            grid = new Space[11][11];
            for (Space[] spaces : grid) {
                Arrays.fill(spaces, space);
            }
            for (int col = 1; col < 10; col++) {
                grid[1][col] = block;
                if (col <= 7) {
                    grid[9][col] = block;
                }
                if (col >= 3) {
                    grid[7][col] = block;
                    if (col <= 7) {
                        grid[3][col] = block;
                        if (col >= 5) {
                            grid[5][col] = block;
                        }
                    }
                }
            }
            for (int row = 1; row < 10; row++) {
                grid[row][1] = block;
                if (row > 3 && row < 7) {
                    grid[row][3] = block;
                }
                if (row < 8) {
                    grid[row][9] = block;
                }
            }
            grid[4][7] = block;
            int rand = (int) (Math.random() * 4);
            if (rand == 0) {
                pellet = new Pellets(10);
                point = pellet.pointValue();
                grid = addPellets(10, grid);
            } else if (rand == 1) {
                pellet = new Pellets(20);
                point = pellet.pointValue();
                grid = addPellets(20, grid);
            } else if (rand == 2) {
                pellet = new Pellets(25);
                point = pellet.pointValue();
                grid = addPellets(25, grid);
            }
        }
        play();
    }

    private void printGrid() {
        for (Space[] spaces : grid) {
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(spaces[col].getSymbol() + "  ");
            }
            System.out.println();
        }
    }

    private Space[][] addPellets (int numPellets,Space[][] g) {
        int rows = g.length;
        int cols = g[0].length;
        for (int i = 0; i < numPellets; i++) {
            int row = (int) (Math.random() * rows);
            int col = (int) (Math.random() * cols);
            if (g[row][col] == space) {
                g[row][col] = pellet;
            } else {
                i--;
            }
        }
        for (int i = 0; i < 1; i++) {
            int row = (int) (Math.random() * rows);
            int col = (int) (Math.random() * cols);
            if (g[row][col] == space) {
                g[row][col] = player;
                pos[0] = row;
                pos[1] = col;
            } else {
                i--;
            }
        }
        return g;
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