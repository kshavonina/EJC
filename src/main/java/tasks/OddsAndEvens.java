package tasks;

public class OddsAndEvens {
    public static void main(String[] args) {
        OddsAndEvens solution = new OddsAndEvens();
        int[][] array = solution.createArray(10);
        solution.printArray(array);
    }

    public int[][] createArray(int size) {
        int[][] array = new int[size][size];

        int evenRow = 0;    // четные
        int oddRow = 1;     // нечетные
        int tens = 0;
        for (int i = 1; i <= (size % 2 == 1 ? size * (size + 1) : size * size); i++) {
            if (i % 2 == 0) {
                array[evenRow][(i - tens - 1) / 2] = i;
            } else {
                if (oddRow < size) {
                    array[oddRow][(i - tens) / 2] = i;
                }
            }

            if (i % (2 * size) == 0) {
                tens += (2 * size);
                evenRow += 2;
                oddRow += 2;
            }
        }

        return array;
    }

    public void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
