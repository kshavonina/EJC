package task_07;

import java.util.ArrayList;
import java.util.List;

/**
 * Task: create 100 random numbers in a range of 0 to 1000
 * and then sort array of these numbers using insertion sort.
 * Also cover test coverage.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            list.add((int) (Math.random() * 500));
        }

        System.out.println(list);
        System.out.println(new InsertionSort().sort(list));
    }

    /**
     * Implementation of insertion sort.
     *
     * @param list is a list for sorting.
     * @return sorted list.
     */
    public List<Integer> sort(List<Integer> list) {
        int j;

        for (int i = 1; i < list.size(); i++) {
            int currValue = list.get(i);
            j = i;

            while (j > 0 && list.get(j - 1) > currValue) {
                list.set(j, list.get(j - 1));
                j--;
            }

            list.set(j, currValue);
        }

        return list;
    }
}
