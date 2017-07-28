package task_09;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int listLength = (int) (Math.random() * 30 + 20);
        System.out.println(listLength);

        for (int i = 0; i < listLength; i++) {
            list.add((int) (Math.random() * 99));
        }

        System.out.println("List for sorting:");
        System.out.println(list);

        SelectionSort selectionSort = new SelectionSort();
        System.out.println("List sorted by Selection Sort:");
        System.out.println(selectionSort.selectionSort(list));
    }

    /**
     * Selection sort.
     * Complexity: O(n^2).
     * Can be both stable and unstable. Stable realization - we insert min element on the first unsorted position,
     * unstable - we swap min element with element on the first unsorted position.
     */
    public List<Integer> selectionSort(List<Integer> list) {
        List<Integer> listCopy = new ArrayList<>(list);

        for (int i = 0; i < listCopy.size(); i++) {
            int min = listCopy.get(i);
            int minIndex = i;

            for (int j = i + 1; j < listCopy.size(); j++) {
                if (min > listCopy.get(j)) {
                    min = listCopy.get(j);
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                //Collections.swap(listCopy, i, minIndex);  // unstable realization

                listCopy.remove(minIndex);                  // stable realization
                listCopy.add(i, min);
            }
        }

        return listCopy;
    }
}
