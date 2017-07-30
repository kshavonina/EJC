package task_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Task: implement bubble sort and merge sort
 * (in accordance with a task from Zlatopolsky textbook).
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class SortingsZlatopolsky {
    public static void main(String[] args) {
        Integer[] array = new Integer[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }

        SortingsZlatopolsky sortingsZlatopolsky = new SortingsZlatopolsky();
        List<Integer> list = Arrays.asList(array);
        System.out.println(Arrays.toString(array));
        System.out.println(sortingsZlatopolsky.bubbleSort(list));
        System.out.println(sortingsZlatopolsky.mergeSort(list));
    }

    /**
     * Implementation of a bubble sort.
     *
     * @param list is a sorting list.
     * @return a sorted copy of original list.
     */
    public List<Integer> bubbleSort(List<Integer> list) {
        List<Integer> listCopy = new ArrayList<>(list);

        for (int i = 0; i < listCopy.size() - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < listCopy.size() - 1 - i; j++) {
                if (listCopy.get(j) > listCopy.get(j + 1)) {
                    Collections.swap(listCopy, j, j + 1);
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }

        return listCopy;
    }

    /**
     * Implementation of a merge sort.
     * The main process.
     *
     * @param list is a sorting list.
     * @return a sorted copy of original list.
     */
    public List<Integer> mergeSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }

        int middle = list.size() / 2;

        SortingsZlatopolsky algorithms = new SortingsZlatopolsky();

        return merge(algorithms.mergeSort(list.subList(0, middle)),
                algorithms.mergeSort(list.subList(middle, list.size())));
    }

    /**
     * Merges two sorted list into one.
     *
     * @param firstList is the first sorted list.
     * @param secondList is the second sorted list.
     * @return sorted list composed of elements from the first
     * and the second original lists.
     */
    private List<Integer> merge(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> resultList = new ArrayList<>();

        if (firstList.size() == 1 && secondList.size() == 1) {
            resultList.add(Math.min(firstList.get(0), secondList.get(0)));
            resultList.add(Math.max(firstList.get(0), secondList.get(0)));
            return resultList;
        }

        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstList.size() && secondIndex < secondList.size()) {
            if (firstList.get(firstIndex) < secondList.get(secondIndex)) {
                resultList.add(firstList.get(firstIndex));
                firstIndex++;
            } else {
                resultList.add(secondList.get(secondIndex));
                secondIndex++;
            }
        }

        if (firstIndex < firstList.size()) {
            for (int i = firstIndex; i < firstList.size(); i++) {
                resultList.add(firstList.get(i));
            }
        }

        if (secondIndex < secondList.size()) {
            for (int i = secondIndex; i < secondList.size(); i++) {
                resultList.add(secondList.get(i));
            }
        }

        return resultList;
    }
}
