import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Grid grid = new Grid();
        System.out.println("Which may would you like to play? (1, 2, or 3)");
        int scanned = scan.nextInt();
        grid.gridSetup(scanned);
    }
}
