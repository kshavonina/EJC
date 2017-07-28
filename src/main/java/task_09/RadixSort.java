package task_09;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int listLength = (int) (Math.random() * 30 + 20);
        System.out.println(listLength);

        for (int i = 0; i < listLength; i++) {
            list.add((int) (Math.random() * 99));
        }

        System.out.println("List for sorting:");
        System.out.println(list);

        RadixSort radixSort = new RadixSort();
        System.out.println("List sorted by Radix Sort:");
        System.out.println(radixSort.radixSortLSD(list));
    }

    /**
     * Radix sort.
     * Complexity: O(m(n + k)).
     * n - number of elements,
     * m - bit number of max value in sorting list,
     * k - bit number of data (number of possible key bit values; for example, with russian words k = 33,
     * since the letter can take no more than 33 values).
     * LSD - Least Significant Digit. In this implementation of the algorithm, we begin with the lowest digit.
     */
    public List<Integer> radixSortLSD(List<Integer> list) {
        List<Integer> tempList = new ArrayList<>(list);
        List<Integer> resultList = new ArrayList<>(list);

        int maxValue = list.get(0);
        for (int value : list) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        int exp = 1;

        while (maxValue / exp > 0) {
            int[] bucket = new int[10];

            for (int i = 0; i < resultList.size(); i++) {
                bucket[resultList.get(i) / exp % 10]++;
            }

            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = tempList.size() - 1; i >= 0; i--) {
                bucket[resultList.get(i) / exp % 10]--;
                tempList.set(bucket[resultList.get(i) / exp % 10], resultList.get(i));
            }

            for (int i = 0; i < resultList.size(); i++) {
                resultList.set(i, tempList.get(i));
            }

            exp *= 10;
        }

        return resultList;
    }
}
