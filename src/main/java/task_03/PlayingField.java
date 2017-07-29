package task_03;

/**
 * The PlayingField class represents field for sea battle game.
 * Also contains a set of methods for work with ships.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class PlayingField {
    /**
     * A constant holding the state of clear water
     * on the playing field.
     */
    public final static char CLEAR_WATER = '.';
    /**
     * A constant holding the state of water near ship
     * on the playing field. These cells are not available
     * for creating another ships.
     */
    public final static char WATER_NEAR_SHIP = '-';
    /**
     * A constant holding the state of ship
     * on the playing field.
     */
    public final static char SHIP = 'S';
    /**
     * A constant holding the state of damaged part of ship
     * on the playing field.
     */
    public final static char DAMAGED_SHIP = 'X';
    /**
     * Array of letters for playing field.
     */
    private final static char[] FIELD_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    /**
     * Size of playing field.
     */
    private int fieldSize;
    /**
     * Represents playing field itself.
     */
    private char[][] field;

    /**
     * Initializes a newly created playing field
     * with default field size = 10.
     */
    public PlayingField() {
        this(10);
    }

    /**
     * Initializes a newly created playing field
     * with defined field size. Every cell of field
     * marked as clear water.
     *
     * @param fieldSize is the size of field.
     */
    public PlayingField(int fieldSize) {
        this.fieldSize = fieldSize;
        this.field = new char[fieldSize][fieldSize];

        for (int i = 0; i < this.fieldSize; i++) {
            for (int j = 0; j < this.fieldSize; j++) {
                this.field[i][j] = CLEAR_WATER;
            }
        }
    }

    /**
     * Returns the size of playing field.
     *
     * @return the size of playing field.
     */
    public int getFieldSize() {
        return this.fieldSize;
    }

    /**
     * Prints the current playing field
     * to the console.
     *
     * @throws IllegalArgumentException when size of playing field
     *                                  more than 26 (number of letters in English alphabet).
     */
    public void printPlayingField() {
        if (this.fieldSize > 26) {
            System.err.println("Cannot display playing field, since field size more than 26 and" +
                    " the English alphabet does not have enough letters.");
            throw new IllegalArgumentException();
        }

        System.out.print(" " + " ");

        for (int i = 0; i < this.fieldSize; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < this.fieldSize; i++) {
            System.out.print(PlayingField.FIELD_LETTERS[i] + " ");

            for (int j = 0; j < this.fieldSize; j++) {
                System.out.print(field[i][j] + " ");

                if (j >= 10) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    /**
     * Creates ships randomly on playing field.
     */
    public void createShips() {
        boolean isCreated = false;

        // create four-decker
        while (!isCreated) {
            isCreated = createShip((int) Math.round(Math.random() * 9),
                    (int) Math.round(Math.random() * 9), 4);
        }

        isCreated = false;

        // create two three-deckers
        for (int i = 0; i < 2; i++) {
            while (!isCreated) {
                isCreated = createShip((int) Math.round(Math.random() * 9),
                        (int) Math.round(Math.random() * 9), 3);
            }

            isCreated = false;
        }

        // create three two-deckers
        for (int i = 0; i < 3; i++) {
            while (!isCreated) {
                isCreated = createShip((int) Math.round(Math.random() * 9),
                        (int) Math.round(Math.random() * 9), 2);
            }

            isCreated = false;
        }

        // create four one-deckers
        for (int i = 0; i < 4; i++) {
            while (!isCreated) {
                isCreated = createShip((int) Math.round(Math.random() * 9),
                        (int) Math.round(Math.random() * 9), 1);
            }

            isCreated = false;
        }

        // clear cells near ships
        for (int i = 0; i < this.fieldSize; i++) {
            for (int j = 0; j < this.fieldSize; j++) {
                if (this.field[i][j] == PlayingField.WATER_NEAR_SHIP) {
                    updateCell(i, j, PlayingField.CLEAR_WATER);
                }
            }
        }

    }

    /**
     * Creates ship with defined number of decks on the playing field.
     *
     * @param letter      defines a first coordinate on the playing field to start
     *                    building a ship.
     * @param digit       defines a second coordinate on the playing field to start
     *                    building a ship.
     * @param decksNumber defines a number of decks for the created ship.
     * @return true if ship is successfully created, false otherwise.
     */
    private boolean createShip(int letter, int digit, int decksNumber) {
        if (!isCellAvailable(letter, digit)) {
            return false;
        }

        int direction = (int) Math.round(Math.random() * 3);

        for (int i = 0; i < 4; i++) {
            if (isDirectionAvailable(letter, digit, decksNumber, direction)) {
                createShipInAvailableDirection(letter, digit, decksNumber, direction);
                return true;
            }

            direction = (direction + 1) % 4;
        }

        return false;
    }

    /**
     * Checks if required direction is available for creating ship with a certain number
     * of decks from specific cell.
     *
     * @param letter defines a first coordinate of cell on the playing field.
     * @param digit defines a second coordinate of cell on the playing field.
     * @param decksNumber is number of ship decks.
     * @param direction is a required direction:
     *                  0 - right;
     *                  1 - down;
     *                  2 - left;
     *                  3 - up.
     * @return true if the direction is available, false - otherwise.
     */
    private boolean isDirectionAvailable(int letter, int digit, int decksNumber, int direction) {
        switch (direction) {
            case 0:
                if (decksNumber - 1 + digit >= fieldSize) {
                    return false;
                }

                for (int i = digit; i < digit + decksNumber; i++) {
                    if (!isCellAvailable(letter, i)) {
                        return false;
                    }
                }

                break;
            case 1:
                if (decksNumber - 1 + letter >= fieldSize) {
                    return false;
                }

                for (int i = letter; i < letter + decksNumber; i++) {
                    if (!isCellAvailable(i, digit)) {
                        return false;
                    }
                }

                break;
            case 2:
                if (digit - (decksNumber - 1) < 0) {
                    return false;
                }

                for (int i = digit; i > digit - decksNumber; i--) {
                    if (!isCellAvailable(letter, i)) {
                        return false;
                    }
                }

                break;
            case 3:
                if (letter - (decksNumber - 1) < 0) {
                    return false;
                }

                for (int i = letter; i > letter - decksNumber; i--) {
                    if (!isCellAvailable(i, digit)) {
                        return false;
                    }
                }
                break;
        }

        return true;
    }

    /**
     * Creates a ship with a certain number of decks from specific cell in available
     * direction.
     *
     * @param letter defines a first coordinate of cell on the playing field.
     * @param digit defines a second coordinate of cell on the playing field.
     * @param decksNumber is number of ship decks.
     * @param direction is a required direction:
     *                  0 - right;
     *                  1 - down;
     *                  2 - left;
     *                  3 - up.
     */
    private void createShipInAvailableDirection(int letter, int digit, int decksNumber, int direction) {
        switch (direction) {
            case 0:
                for (int i = digit; i < digit + decksNumber; i++) {
                    updateCell(letter, i, PlayingField.SHIP);
                    updateCellEnvironment(letter, i);
                }

                break;
            case 1:
                for (int i = letter; i < letter + decksNumber; i++) {
                    updateCell(i, digit, PlayingField.SHIP);
                    updateCellEnvironment(i, digit);
                }

                break;
            case 2:
                for (int i = digit; i > digit - decksNumber; i--) {
                    updateCell(letter, i, PlayingField.SHIP);
                    updateCellEnvironment(letter, i);
                }

                break;
            case 3:
                for (int i = letter; i > letter - decksNumber; i--) {
                    updateCell(i, digit, PlayingField.SHIP);
                    updateCellEnvironment(i, digit);
                }

                break;
        }
    }

    /**
     * Checks if the cell is available for creating ships.
     *
     * @param letter defines a first coordinate of cell on the playing field.
     * @param digit defines a second coordinate of cell on the playing field.
     * @return true if the cell is available, false - otherwise.
     */
    private boolean isCellAvailable(int letter, int digit) {
        if (this.field[letter][digit] == PlayingField.SHIP ||
                this.field[letter][digit] == PlayingField.WATER_NEAR_SHIP) {
            return false;
        }

        return true;
    }

    /**
     * Updates cell state to required.
     *
     * @param letter defines a first coordinate of cell on the playing field.
     * @param digit defines a second coordinate of cell on the playing field.
     * @param ch is required state of the cell.
     */
    public void updateCell(int letter, int digit, char ch) {
        this.field[letter][digit] = ch;
    }

    /**
     * Updates cell environment. Marks cells near ship as not available
     * for creating another ships.
     *
     * @param letter defines a first coordinate of cell on the playing field.
     * @param digit defines a second coordinate of cell on the playing field.
     */
    public void updateCellEnvironment(int letter, int digit) {
        for (int i = letter - 1; i <= letter + 1; i++) {
            for (int j = digit - 1; j <= digit + 1; j++) {
                if (i >= 0 && i < this.field.length && j >= 0 && j < this.field.length) {
                    if (this.field[i][j] != PlayingField.SHIP && this.field[i][j] != PlayingField.DAMAGED_SHIP) {
                        this.field[i][j] = PlayingField.WATER_NEAR_SHIP;
                    }
                }
            }
        }
    }

    /**
     * Returns the state of specific cell on playing field.
     *
     * @param letter defines a first coordinate of cell on the playing field.
     * @param digit defines a second coordinate of cell on the playing field.
     * @return state of the cell.
     */
    public char getCell(int letter, int digit) {
        return this.field[letter][digit];
    }
}
