package task_07;

import org.junit.Assert;
import org.junit.Test;
import task_07.InsertionSort;
import task_07.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortTest {
    @Test
    public void testSort() {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(56);
        list.add(-90);
        list.add(70);
        list.add(43);

        List<Integer> sortedList = new ArrayList<>();

        sortedList.add(-90);
        sortedList.add(5);
        sortedList.add(43);
        sortedList.add(56);
        sortedList.add(70);

        InsertionSort insertionSort = new InsertionSort();
        Assert.assertEquals(sortedList, insertionSort.sort(list));
    }
}
