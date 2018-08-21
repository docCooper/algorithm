package sort_nlogn.quick_sort;

import utils.GenRandomArrayUtil;
import utils.SortTestHelper;
import utils.SwapUtils;

/**
 * Create By 曹通
 * 2018/7/24 15:45
 */
public class QuickSort {
    // 找到基准元素应该在的位置
    public static int get_p(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                // 遇到比基准小的，i和j一起往前走，比基准大的，j停住，i往前走，j始终在比基准小的最后一个位置
                SwapUtils.swap(arr, j + 1, i);
                j++;
            }
        }
        SwapUtils.swap(arr, l, j);
        return j;
    }

    public static void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            // 递归终止条件
            return;
        }
        int p = get_p(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }
    public static void sort(Comparable arr[]){
        quickSort(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        Integer[] arrs = SortTestHelper.generateRandomArray(1000000, 1, 1000000);
        SortTestHelper.testSort("sort_nlogn.merge_sort.MergeSort1",arrs);
    }
}
