package sort.insertSort;

import utils.GenRandomArrayUtil;
import utils.SortTestHelper;
import utils.SwapUtils;

/**
 * Create By 曹通
 * 2018/7/23 11:38
 */
public class InsertSort {
//        public static void sort(Comparable[] arr) {
//        int n = arr.length;
//        // 前i个是有序的
//        for (int i = 1; i < n; i++) {
//            // 在前i个中寻找放arr[j]的合适位置
//            for(int j=i;j>0;j--){
//                if (arr[j].compareTo(arr[j-1])<0)
//                    SwapUtils.swap(arr,j,j-1);
//                else
//                    break;
//            }
//        }
//    }
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 前i个是有序的
        for (int i = 1; i < n; i++) {
            // 在前i个中寻找放arr[j]的合适位置
            Comparable temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1].compareTo(temp)>0; j--) {
                    // 经过这层循环，j变成了temp要放的位置
                    arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
//        Integer [] a = {1,2,4,2,5,7,6};
        Integer[] integers = SortTestHelper.generateRandomArray(100000, 1, 100000);
        Integer[] integers1 = integers.clone();
        SortTestHelper.testSort("sort.selectSort.SelectionSort", integers);
        System.out.println("-----------------------------------");
        SortTestHelper.testSort("sort.insertSort.InsertSort", integers1);
//        InsertSort.sort(a);
//        for (int i=0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
    }
}
