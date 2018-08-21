package sort.selectSort;

import org.junit.Test;
import utils.SortTestHelper;

/**
 * Create By 曹通
 * 2018/7/23 9:25
 */
public class SelectionSortTest {

    @Test
    public void sortArray() {
        int [] a = {2,3,1,3,6,7,4};
        Integer[] integers = SortTestHelper.generateRandomArray(10000, 1, 100000);
        SortTestHelper.testSort("sort.selectSort.SelectionSort",integers);
    }
}
