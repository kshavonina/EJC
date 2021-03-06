package task_08;

import java.util.ArrayList;
import java.util.List;

/**
 * Task: implement binary search.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int listLength = (int) (Math.random() * 30 + 20);
        System.out.println(listLength);

        for (int i = 0; i < listLength; i++) {
            list.add((int) (Math.random() * 99));
        }

        System.out.println(new SortingsZlatopolsky().mergeSort(list));
        System.out.println("Index of element " + 98 + " is: " +
                new BinarySearch().binarySearch(new SortingsZlatopolsky().mergeSort(list), 98));
    }

    /**
     * Binary search.
     * Complexity: O(log(n)).
     * Also known as half-interval search, logarithmic search, or binary chop.
     * Classic search algorithm that finds the position of a target value within a sorted array.
     * Runs in at worst logarithmic time, making O(log n) comparisons.
     *
     * @param list is a list in which search takes place.
     * @param value is a value to search.
     * @return index of needed value or -1 if the value is not in the list.
     */
    public int binarySearch(List<Integer> list, int value) {
        int fromIndex = 0;
        int toIndex = list.size() - 1;

        while (fromIndex <= toIndex) {
            int middleIndex = fromIndex + (toIndex - fromIndex) / 2;

            if (list.get(middleIndex) == value) {
                return middleIndex;
            } else if (list.get(middleIndex) > value) {
                toIndex = middleIndex - 1;
            } else {
                fromIndex = middleIndex + 1;
            }
        }

        return -1;
    }
}
