package task_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Task: create a list, fill it with 25 numbers from the console. Print the list.
 * Sort the list using quick sort and print sorted list.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 25; i++) {
            System.out.println("Enter int number: ");
            try {
                list.add(Integer.parseInt(reader.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thanks");

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(list);

        QuickSort quickSort = new QuickSort();
        quickSort.sort(list);
        System.out.println(list);
    }

    /**
     * Initial method for quick sort.
     *
     * @param list is list for sorting.
     */
    public void sort(List<Integer> list) {
        qsort(list, 0, list.size() - 1);
    }

    /**
     * The main process of sorting.
     *
     * @param list is a sorting list.
     * @param fromIndex is an index of the first element of sorting part
     *                  of the list.
     * @param toIndex is an index of the last element of sorting part
     *                  of the list.
     */
    private void qsort(List<Integer> list, int fromIndex, int toIndex) {
        if (toIndex > fromIndex) {
            int currIndex = partition(list, fromIndex, toIndex);
            qsort(list, fromIndex, currIndex - 1);
            qsort(list, currIndex + 1, toIndex);
        }
    }

    /**
     * Makes a partition of a certain part of a sorting list.
     *
     * @param list is a sorting list.
     * @param fromIndex is an index of the first element of certain part
     *                  of the list.
     * @param toIndex is an index of the last element of certain part
     *                  of the list.
     * @return list with a certain partitioned part of it.
     */
    private int partition(List<Integer> list, int fromIndex, int toIndex) {
        int currIndex = fromIndex + new Random().nextInt(toIndex - fromIndex + 1);
        Object pivot = list.get(currIndex);
        swap(list, currIndex, toIndex);

        for (int i = currIndex = fromIndex; i < toIndex; ++i) {
            if (list.get(i) < (int) pivot) {
                swap(list, currIndex++, i);
            }
        }

        swap(list, currIndex, toIndex);
        return currIndex;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param list is a list in which a swap takes place.
     * @param firstIndex is an index of first element to swap.
     * @param secondIndex is an index of second element to swap.
     */
    private void swap(List<Integer> list, int firstIndex, int secondIndex) {
        int tmpValue = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tmpValue);
    }

}
