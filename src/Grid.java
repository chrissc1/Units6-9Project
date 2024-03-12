public class Grid {
    private Player playerUp;
    private Player playerDown;
    private Player playerLeft;
    private Player playerRight;
    private Space space;
    private Pellets pellet;
    private Ghost ghost;
    private Block block;

    public Grid() {
        pellet = new Pellets(5);
        playerUp = new Player("V");
        playerDown = new Player("^");
        playerLeft = new Player(">");
        playerRight = new Player("<");
        space = new Space(" ");
    }

    public void gridSetup() {
        Space[][] grid = new Space[10][10];
        for (int i = 0; i < grid.length; i++) {
            for (int k = 0; k < grid[i].length; k++) {
                grid[i][k] = pellet;
            }
        }
    }
}
/*
█ █ █ █ █ █ O O O O
_ _ _ _ _ █ O _ _ O
O O O O O █ O O O O
_ _ _ _ _ █ _ _ _ _
_ █ █ █ █ █ _ █ █ _
_ █ █ █ █ _ O _ █ _
_ █ █ █ █ _ G _ █ _
_ _ _ _ _ _ O _ _ _
_ █ █ █ █ █ █ █ █ _
_ _ _ _ > _ _ _ _ _


 */