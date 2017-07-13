package task_03;

class PlayingField {
    private int fieldSize;
    private char[][] field;

    final static char CLEAR_WATER = '.';
    final static char WATER_NEAR_SHIP = '-';
    final static char SHIP = 'S';
    final static char DAMAGED_SHIP = 'X';

    public PlayingField() {
        this(10);
    }

    public PlayingField(int fieldSize) {
        this.fieldSize = fieldSize;
        this.field = new char[fieldSize][fieldSize];

        for (int i = 0; i < this.fieldSize; i++) {
            for (int j = 0; j < this.fieldSize; j++) {
                this.field[i][j] = CLEAR_WATER;
            }
        }
    }

    public int getFieldSize() {
        return this.fieldSize;
    }

    public void printPlayingField() {
        System.out.print(" " + " ");

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < this.fieldSize; i++) {
            switch (i) {
                case 0:
                    System.out.print("A" + " ");
                    break;
                case 1:
                    System.out.print("B" + " ");
                    break;
                case 2:
                    System.out.print("C" + " ");
                    break;
                case 3:
                    System.out.print("D" + " ");
                    break;
                case 4:
                    System.out.print("E" + " ");
                    break;
                case 5:
                    System.out.print("F" + " ");
                    break;
                case 6:
                    System.out.print("G" + " ");
                    break;
                case 7:
                    System.out.print("H" + " ");
                    break;
                case 8:
                    System.out.print("I" + " ");
                    break;
                case 9:
                    System.out.print("J" + " ");
                    break;
            }

            for (int j = 0; j < this.fieldSize; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public void createShips() {
        // create four-decker
        boolean isCreated = false;

        while (!isCreated) {
            isCreated = createShip((int) Math.round(Math.random() * 9), (int) Math.round(Math.random() * 9), 4);
        }

        isCreated = false;

        // create three-decker
        for (int i = 0; i < 2; i++) {
            while (!isCreated) {
                isCreated = createShip((int) Math.round(Math.random() * 9), (int) Math.round(Math.random() * 9), 3);
            }

            isCreated = false;
        }

        // create two-decker
        for (int i = 0; i < 3; i++) {
            while (!isCreated) {
                isCreated = createShip((int) Math.round(Math.random() * 9), (int) Math.round(Math.random() * 9), 2);
            }

            isCreated = false;
        }

        // create one-decker
        for (int i = 0; i < 4; i++) {
            while (!isCreated) {
                isCreated = createShip((int) Math.round(Math.random() * 9), (int) Math.round(Math.random() * 9), 1);
            }

            isCreated = false;
        }

        // clear cells near ships
        for (int i = 0; i < this.fieldSize; i++) {
            for (int j = 0; j < this.fieldSize; j++) {
                if (this.field[i][j] == WATER_NEAR_SHIP) {
                    updateCell(i, j, CLEAR_WATER);
                }
            }
        }

    }

    private boolean createShip(int letter, int digit, int decksNumber) {
        if (!isCellAvailable(letter, digit)) {
            return false;
        }

        //int direction = (int) Math.round(Math.random() * 3);

        if (digit + decksNumber - 1 < this.fieldSize) {
            boolean isDirectionAvailable = true;

            for (int i = digit; i < digit + decksNumber; i++) {
                if (!isCellAvailable(letter, i)) {
                    isDirectionAvailable = false;
                    break;
                }
            }

            if (isDirectionAvailable) {
                for (int i = digit; i < digit + decksNumber; i++) {
                    updateCell(letter, i, SHIP);
                    updateCellEnvironment(letter, i);
                }

                return true;
            }
        }

        if (letter + decksNumber - 1 < this.fieldSize) {
            boolean isDirectionAvailable = true;

            for (int i = letter; i < letter + decksNumber; i++) {
                if (!isCellAvailable(i, digit)) {
                    isDirectionAvailable = false;
                    break;
                }
            }

            if (isDirectionAvailable) {
                for (int i = letter; i < letter + decksNumber; i++) {
                    updateCell(i, digit, SHIP);
                    updateCellEnvironment(i, digit);
                }

                return true;
            }
        }

        if (digit - (decksNumber - 1) >= 0) {
            boolean isDirectionAvailable = true;

            for (int i = digit; i > digit - decksNumber; i--) {
                if (!isCellAvailable(letter, i)) {
                    isDirectionAvailable = false;
                    break;
                }
            }

            if (isDirectionAvailable) {
                for (int i = digit; i > digit - decksNumber; i--) {
                    updateCell(letter, i, SHIP);
                    updateCellEnvironment(letter, i);
                }

                return true;
            }
        }

        if (letter - (decksNumber - 1) >= 0) {
            boolean isDirectionAvailable = true;

            for (int i = letter; i > letter - decksNumber; i--) {
                if (!isCellAvailable(i, digit)) {
                    isDirectionAvailable = false;
                    break;
                }
            }

            if (isDirectionAvailable) {
                for (int i = letter; i > letter - decksNumber; i--) {
                    updateCell(i, digit, SHIP);
                    updateCellEnvironment(i, digit);
                }

                return true;
            }
        }

        return false;
    }

    private boolean isCellAvailable(int letter, int digit) {
        if (this.field[letter][digit] == SHIP || this.field[letter][digit] == WATER_NEAR_SHIP) {
            return false;
        }

        return true;
    }

    public void updateCell(int letter, int digit, char ch) {
        this.field[letter][digit] = ch;
    }

    public void updateCellEnvironment(int letter, int digit) {
        for (int i = letter - 1; i <= letter + 1; i++) {
            for (int j = digit - 1; j <= digit + 1; j++) {
                if (i >= 0 && i < this.field.length && j >= 0 && j < this.field.length) {
                    if (this.field[i][j] != SHIP && this.field[i][j] != DAMAGED_SHIP) {
                        this.field[i][j] = WATER_NEAR_SHIP;
                    }
                }
            }
        }
    }

    public char getCell(int letter, int digit) {
        return this.field[letter][digit];
    }
}
