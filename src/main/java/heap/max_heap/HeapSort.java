package heap.max_heap;

import utils.SortTestHelper;

/**
 * Create By 曹通
 * 2018/7/27 15:52
 */
public class HeapSort {
    public static void sort(Comparable[] arr){
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i=arr.length-1;i>=0;i--)
            arr[i] = maxHeap.extractMax();
    }

    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(1000000, 1, 10000000);
        Integer[] integers1 = integers.clone();
        SortTestHelper.testSort("sort_nlogn.quick_sort.Quick3WaysSort",integers);
        System.out.println("============================");
        SortTestHelper.testSort("heap.max_heap.HeapSort",integers1);
    }
}
