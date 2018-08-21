package binarySearch;

/**
 * 递归实现二分查找
 * Create By 曹通
 * 2018/8/3 9:17
 */
public class BinarySearch {
    public static int binarySearch(Comparable[] arr, Comparable target, int l, int r) {
        int idx = -1;
        if (l > r) {
            return idx;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target.compareTo(arr[mid]) < 0)
            // 在左半部分
            idx = binarySearch(arr, target, l, mid - 1);
        if (target.compareTo(arr[mid]) > 0)
            idx = binarySearch(arr, target, mid + 1, r);
        return idx;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = binarySearch(arr, 10, 0, arr.length - 1);
        System.out.println(i);
    }
}
