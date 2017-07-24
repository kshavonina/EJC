package task_08;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortingsZlatopolskyTest {
    @Test
    public void testBubbleSort() {
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

        SortingsZlatopolsky sortingsZlatopolsky = new SortingsZlatopolsky();
        Assert.assertEquals("msg", sortedList, sortingsZlatopolsky.bubbleSort(list));
    }

    @Test
    public void testMergeSort() {
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

        SortingsZlatopolsky sortingsZlatopolsky = new SortingsZlatopolsky();
        Assert.assertEquals("msg", sortedList, sortingsZlatopolsky.mergeSort(list));
    }
}
