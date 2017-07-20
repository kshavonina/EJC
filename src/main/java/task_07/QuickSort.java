package task_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**\
 * Создать коллекцию, ввести с клавиатуры 25 чисел. Выводите коллекцию на экран без сортировки. Делаете
 * QuickSort и выводите после сортировки.
 */
public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
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

    public void sort(List<Integer> list) {
        qsort(list, 0, list.size() - 1);
    }

    private void qsort(List<Integer> list, int fromIndex, int toIndex) {
        if (toIndex > fromIndex) {
            int currIndex = partition(list, fromIndex, toIndex);
            qsort(list, fromIndex, currIndex - 1);
            qsort(list, currIndex + 1, toIndex);
        }
    }

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

    private void swap(List<Integer> list, int firstIndex, int secondIndex) {
        int tmpValue = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tmpValue);
    }

}
