package task_03;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SeaBattle {
    private int attempts;
    private PlayingField shipsField;
    public PlayingField playerField;

    public static void main(String[] args) {
        SeaBattle b = new SeaBattle();
        b.playerField.printPlayingField();
        b.shipsField.printPlayingField();
    }

    public SeaBattle() {
        this(50);
    }

    public SeaBattle(int n) {
        this.attempts = n;
        this.shipsField = new PlayingField();
        this.shipsField.createShips();
        this.playerField = new PlayingField();
    }

    public void startBattle() { // A B C D E F G H I J
        //shipsField.printPlayingField();
        playerField.printPlayingField();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //int damagedCellsCount = 0;
        Set<Pair<Integer, Integer>> damagedCells = new HashSet<>();
        /*Set<Pair<Integer, Integer>> damagedCells = new HashSet<>();

        for (int i = 0; i < shipsField.getN(); i++) {
            for (int j = 0; j < shipsField.getN(); j++) {
                if (shipsField.getCell(i, j) == PlayingField.SHIP) {
                    shipCells.add(new Pair<>(i, j));
                }
            }
        }*/

        for (int i = 0; i < this.attempts; i++) {
            System.out.println("Enter cell: ");

            String str = null;

            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int letter = -1;
            int digit = Integer.parseInt(str.substring(1));

            switch (str.charAt(0)) {
                case 'A':
                    letter = 0;
                    break;
                case 'B':
                    letter = 1;
                    break;
                case 'C':
                    letter = 2;
                    break;
                case 'D':
                    letter = 3;
                    break;
                case 'E':
                    letter = 4;
                    break;
                case 'F':
                    letter = 5;
                    break;
                case 'G':
                    letter = 6;
                    break;
                case 'H':
                    letter = 7;
                    break;
                case 'I':
                    letter = 8;
                    break;
                case 'J':
                    letter = 9;
                    break;
            }

            if (shipsField.getCell(letter, digit) == PlayingField.CLEAR_WATER) {
                playerField.updateCell(letter, digit, PlayingField.WATER_NEAR_SHIP);
                System.out.println("Miss!");
                System.out.println();
                playerField.printPlayingField();
                continue;
            }

            if (shipsField.getCell(letter, digit) == PlayingField.SHIP) {
                playerField.updateCell(letter, digit, PlayingField.DAMAGED_SHIP);

                if (isKilled(letter, digit)) {
                    System.out.println("Killed!");
                } else {
                    System.out.println("Damaged!");
                }

                System.out.println();
                playerField.printPlayingField();

                //damagedCellsCount++;
                damagedCells.add(new Pair<>(letter, digit));

                if (/*damagedCellsCount == 20*/ damagedCells.size() == 20) {
                    System.out.println("You won this battle!!!");
                    break;
                }
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isKilled(int letter, int digit) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();

        int i = letter;
        int j = digit;

        while (i >=0 && i < shipsField.getN() && j >=0 && j < shipsField.getN() && shipsField.getCell(i, j) == PlayingField.SHIP) {
            set.add(new Pair<>(i, j));
            i++;
        }

        i = letter;
        j = digit;

        while (i >=0 && i < shipsField.getN() && j >=0 && j < shipsField.getN() && shipsField.getCell(i, j) == PlayingField.SHIP) {
            set.add(new Pair<>(i, j));
            i--;
        }

        i = letter;
        j = digit;

        while (i >=0 && i < shipsField.getN() && j >=0 && j < shipsField.getN() && shipsField.getCell(i, j) == PlayingField.SHIP) {
            set.add(new Pair<>(i, j));
            j++;
        }

        i = letter;
        j = digit;

        while (i >=0 && i < shipsField.getN() && j >=0 && j < shipsField.getN() && shipsField.getCell(i, j) == PlayingField.SHIP) {
            set.add(new Pair<>(i, j));
            j--;
        }

        for (Pair<Integer, Integer> pair : set) {
            if (playerField.getCell(pair.getKey(), pair.getValue()) != PlayingField.DAMAGED_SHIP) {
                return false;
            }
        }

        for (Pair<Integer, Integer> pair : set) {
            playerField.updateCellEnvironment(pair.getKey(), pair.getValue());
        }

        return true;
    }
}