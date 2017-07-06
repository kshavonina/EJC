package task_03;

public class PlayingField {
    private int n;
    private char[][] cells;

    private final static char CLEAR_WATER = '0';
    private final static char WATER_NEAR_SHIP = '-';
    private final static char SHIP = 'S';
    private final static char DAMAGED_SHIP = 'X';

    public static void main(String[] args) {
        //PlayingField f = new PlayingField();
        //f.printPlayingField();
    }

    public PlayingField() {
        this(10);
    }

    public PlayingField(int n) {
        this.n = n;
        cells = new char[n][n];

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                cells[i][j] = CLEAR_WATER;
            }
        }
    }

    public int getN() {
        return this.n;
    }

    public void printPlayingField() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }

}
