package binarySearch;

/**
 * 非递归实现二分查找
 * Create By 曹通
 * 2018/8/3 9:23
 */
public class BinarySearch2 {
    public static int binarySearch(Comparable[] arr, Comparable target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            }
            if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = binarySearch(arr, 10);
        System.out.println(i);
    }
}
