package sort_nlogn.quick_sort;

import utils.SwapUtils;

/**
 * Create By 曹通
 * 2018/7/25 16:38
 */
public  class QuickSort2 {
    private static void quickSort2(Comparable arr[], int l, int r) {
        if (l > r) {
            return;
        }
        Comparable v = arr[l];
        int i = l ;
        int j = r;// arr[j+1,r]
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) i++;
            while (j > l && arr[j].compareTo(v) > 0) j--;
            if (i > j) break;
            SwapUtils.swap(arr, i, j);
            i++;
            j--;
        }
        // j是最后一个小于v的，当j<v时跳出 ，i是第一个大于v的
        SwapUtils.swap(arr, l, j);

        quickSort2(arr, l, j-1);
        quickSort2(arr, j + 1, r);
    }

    private static void sort(Comparable[] arr) {
        quickSort2(arr, 0, arr.length - 1);
    }
}
