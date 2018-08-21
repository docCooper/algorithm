package sort.selectSort;

/**
 * Create By 曹通
 * 2018/7/23 8:53
 */
public class SelectionSort {
    // 不能产生实例
    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIdx]) < 0)
                    minIdx = j;
            }
            swap(arr, i, minIdx);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
