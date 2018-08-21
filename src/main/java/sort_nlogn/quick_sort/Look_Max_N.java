package sort_nlogn.quick_sort;

import utils.SwapUtils;

/**
 * 求解第N大的数
 * Create By 曹通
 * 2018/7/26 18:49
 */
public class  Look_Max_N {
    // 在快速排序中，v是排好序的，根据它的下标往前或者往后找
    public static int quick_sort(Comparable[] arr, int l, int r) {
        int i = l+1;
        int j = r;
        Comparable v = arr[l];
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) i++;
            while (j > l && arr[j].compareTo(v) > 0) j--;
            if (i > j) break;
            SwapUtils.swap(arr, i, j);
            i++;
            j--;
        }
        SwapUtils.swap(arr, l, j);// j所在的元素是第j大的
        return j;
    }

    public static int get_n_idx(Comparable[] arr, int l, int r, int n_idx) {
        int i = quick_sort(arr, l, r);
        if (i > n_idx) {
            i = get_n_idx(arr, l, i - 1, n_idx);
        } else if (i < n_idx) {
            i = get_n_idx(arr, i + 1, r, n_idx);
        }
        return i;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 3, 1, 4, 7, 6, 5,11,21,8};
        int n_idx = get_n_idx(arr, 0, arr.length - 1, 9);
        System.out.println(n_idx+"==="+arr[n_idx]);
    }
}
