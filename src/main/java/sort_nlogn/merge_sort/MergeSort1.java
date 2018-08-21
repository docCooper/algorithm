package sort_nlogn.merge_sort;

import sort.insertSort.InsertSort;
import utils.SortTestHelper;

/**
 * Create By 曹通
 * 2018/7/23 21:17
 */
public class MergeSort1 {
    public static void sort(Comparable arr[]) {
        mergeSort2(arr);
    }

    /**
     * 自顶向下的思想
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void mergeSort(Comparable arr[], int l, int r) {
        int n = arr.length;
        // 设置终止条件
        if (l >= r) {
            return;
        }
//        if (r-l<=15){// 当小于一定的元素数目时，采用插入排序，优化
//            InsertSort.sort(arr[l...r);
//        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        if (arr[m + 1].compareTo(arr[m]) < 0)
            merge(arr, l, m, r);
    }

    /**
     * 自底向上的思想
     * Create By 曹通
     * 2018/7/23 22:20
     *
     * @param [arr]
     * @return void
     */
    public static void mergeSort2(Comparable[] arr) {
        int n = arr.length;
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    private static void merge(Comparable[] arr, int l, int m, int r) {
        // 首先开辟一个临时空间
        Comparable[] temp = new Comparable[r - l + 1];
        for (int i = l; i <= r; i++) {
            temp[i - l] = arr[i];
        }
        int i = l, j = m + 1;
        // 将临时空间的值返回到arr中
        for (int k = l; k <= r; k++) {
            // 左边的已经处理完了
            if (i > m) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                // 只剩左边的了
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                // 左边的比较小
                arr[k] = temp[i - l];
                i++;
            } else {
                // 右边的比较小
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = SortTestHelper.generateRandomArray(10000, 1, 100000);
        Integer[] array2 = SortTestHelper.generateRandomArray(10000, 1, 100000);

        SortTestHelper.testSort("sort_nlogn.merge_sort.MergeSort1", array);
        System.out.println("------------------------");
        SortTestHelper.testSort("sort.insertSort.InsertSort", array2);
    }
}
