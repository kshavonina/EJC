package task_03;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * The SeaBattle class represents a Sea Battle game.
 *
 * @author Kseniya Shavonina
 * @version 2.0
 */
public class SeaBattle {
    /** Player's field. */
    public PlayingField playerField;

    /** Number of shot attempts. */
    private int shotAttempts;

    /** Field with ships randomly created on it. */
    private PlayingField shipsField;

    /**
     * Initializes default SeaBattle object
     * with 50 shot attempts.
     */
    public SeaBattle() {
        this(50);
    }

    /**
     * Initializes a SeaBattle object with defined number of
     * shot shotAttempts. Creates player's field and field with ships.
     *
     * @param shotAttempts is a number of shot shotAttempts.
     */
    public SeaBattle(int shotAttempts) {
        this.shotAttempts = shotAttempts;
        this.shipsField = new PlayingField();
        this.shipsField.createShips();
        this.playerField = new PlayingField();
    }

    /**
     * The main process of the Sea Battle game. A map with ships is generated.
     * The player have several attempts to shoot (50 by default). If he kills all
     * the ships, he wins.
     */
    public void startBattle() {
        playerField.printPlayingField();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Pair<Integer, Integer>> damagedCells = new HashSet<>();
        Set<Pair<Integer, Integer>> enteredCells = new HashSet<>();
        int invalidInputCount = 0;

        for (int i = 0; i < this.shotAttempts; i++) {
            System.out.println("Enter cell: ");

            String userShot = "";

            try {
                userShot = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (userShot.length() != 2) {
                if (++invalidInputCount > 4) {
                    System.out.println("It seems you don't want to play. Try again later.");
                    break;
                }

                System.out.println("Invalid input. Please, try again.");
                i--;
                continue;
            }

            int letter;
            int digit;
            try {
                digit = Integer.parseInt(userShot.substring(1));
            } catch (IllegalArgumentException e) {
                if (++invalidInputCount > 4) {
                    System.out.println("It seems you don't want to play. Try again later.");
                    break;
                }

                System.out.println("Invalid input. Please, try again.");
                i--;
                continue;
            }

            if (invalidInputCount > 4) {
                System.out.println("It seems you don't want to play. Try again later.");
                break;
            }

            switch (userShot.charAt(0)) {
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
                default:
                    System.out.println("Invalid input. Please, try again.");
                    invalidInputCount++;
                    i--;
                    continue;
            }

            Pair<Integer, Integer> currentCell = new Pair<>(letter, digit);

            if (enteredCells.contains(currentCell)) {
                System.out.println("You already shot this cell. Try to shoot somewhere else.");
                invalidInputCount++;
                i--;
                continue;
            } else {
                enteredCells.add(currentCell);
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

                damagedCells.add(new Pair<>(letter, digit));

                if (damagedCells.size() == 20) {
                    System.out.println("You won this battle!!!");
                    break;
                }
            }
        }

        System.out.println("There are no more attempts to shoot. Game over.");

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the ship is killed.
     *
     * @param letter defines a first coordinate of certain ship's cell.
     * @param digit defines a second coordinate of certain ship's cell.
     * @return true if the ship is killed, false - otherwise.
     */
    private boolean isKilled(int letter, int digit) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();

        int i = letter;
        int j = digit;

        while (i >= 0 && i < shipsField.getFieldSize() && j >= 0 && j < shipsField.getFieldSize()
                && shipsField.getCell(i, j) == PlayingField.SHIP) {
            set.add(new Pair<>(i, j));
            i++;
        }

        i = letter;
        j = digit;

        while (i >= 0 && i < shipsField.getFieldSize() && j >= 0 && j < shipsField.getFieldSize()
                && shipsField.getCell(i, j) == PlayingField.SHIP) {
            set.add(new Pair<>(i, j));
            i--;
        }

        i = letter;
        j = digit;

        while (i >= 0 && i < shipsField.getFieldSize() && j >= 0 && j < shipsField.getFieldSize()
                && shipsField.getCell(i, j) == PlayingField.SHIP) {
            set.add(new Pair<>(i, j));
            j++;
        }

        i = letter;
        j = digit;

        while (i >= 0 && i < shipsField.getFieldSize() && j >= 0 && j < shipsField.getFieldSize()
                && shipsField.getCell(i, j) == PlayingField.SHIP) {
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
