package task_07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Вводить 100 чисел через рандом, 0..1000, InsertionSort.
 * Покрыть Юнит тестами.
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

    public List<Integer> sort(List<Integer> list) {
        int j = 0;

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
