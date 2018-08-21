package heap.max_heap;

import utils.SortTestHelper;
import utils.SwapUtils;

/**
 * 原地堆排序
 * Create By 曹通
 * 2018/7/30 9:47
 */
public class HeapSort2 {
    public static void sort(Comparable[] arr) {
        // n是数组最后一个元素的下标
        int n = arr.length - 1;
        // 使用heapify 将数组构建成堆,从0开始了，最后一个非叶子节点为(n-1)/2
        for (int i = (n - 1) / 2; i >= 0; i--)
            shiftDown(arr, n, i);
        // 使用堆进行原地排序,注意这里的n一律是下标而不是元素的个数
        for (int i = n; i > 0; i--) {
            // 将第一个和最后一个进行交换
            SwapUtils.swap(arr, 0, i);
            shiftDown(arr, i-1, 0);
        }
    }

    private static void shiftDown(Comparable[] arr, int n, int i) {
        // 左孩子没有越界
        while ((2 * i + 1) <= n) {
            int j = i * 2+1;
            // 右孩子没有越界
            if (j + 1 < n && arr[j].compareTo(arr[j + 1]) < 0)
                j++;
            if (arr[i].compareTo(arr[j]) > 0)
                break;
            SwapUtils.swap(arr, i, j);
            i = j;
        }

    }
    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(1000000, 1, 10000000);
//        Integer[] integers = {28,15,16,14,7,3};
        System.out.println("11");
        SortTestHelper.testSort("heap.max_heap.HeapSort2",integers);
    }
}
