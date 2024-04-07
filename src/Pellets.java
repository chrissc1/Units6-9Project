public class Pellets extends Space{
    private int numPellets;

    public Pellets(int num) {
        super("*");
        numPellets = num;
    }
    @Override
    public int pointValue() {
        return 100/numPellets;
    }
}
