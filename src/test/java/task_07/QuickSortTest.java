package java.task_07;

import org.junit.Assert;
import org.junit.Test;
import task_07.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class QuickSortTest {
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
        sortedList.add(90);

        QuickSort quickSort = new QuickSort();
        //Assert.assertEquals("msg", sortedList, quickSort.sort(list));
    }
}
