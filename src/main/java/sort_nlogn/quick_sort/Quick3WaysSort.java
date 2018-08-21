package sort_nlogn.quick_sort;

import utils.SortTestHelper;
import utils.SwapUtils;

import java.util.HashSet;

/**
 * 处理有重复键值的数据优势很大
 * Create By 曹通
 * 2018/7/25 16:07
 */
public class Quick3WaysSort {
    public static void sort(Comparable arr[]){
        quick3WaysSort(arr,0,arr.length-1);
    }
    public static void quick3WaysSort(Comparable arr[],int l,int r){
        if (l>r){
            return;
        }
        Comparable v = arr[l];
        int lt = l; // 比v小的最后一个 arr[l+1,lt]<v
        int gt = r+1; // 比v大的第一个 arr[gt,r] >v
        int i = l+1; //当前正在比较的  arr[lt+1,i)==v
        // 当i和gt碰头了，说明这趟排序完成
        while (i<gt){
            if(arr[i].compareTo(v)<0){
                // 当前比较的比v小，维护lt
                SwapUtils.swap(arr,i,++lt);
                i++;
            }else if(arr[i].compareTo(v)>0){
                SwapUtils.swap(arr,i,--gt);
                // 注意，此时i不用动，因为i指向的仍然是个未处理的元素(从后面换过来的)
            }else {
                i++;
            }
        }
        // 将基准元素与比v小的最后一个元素交换
        SwapUtils.swap(arr,l,lt);
        quick3WaysSort(arr,l,lt-1);
        // 中间相等的就不用处理了
        quick3WaysSort(arr,gt,l);
    }

    public static void main(String[] args) {
        Integer[] array = SortTestHelper.generateRandomArray(1000000, 1, 10000000);
        Integer[] array2 = array.clone();
        Integer[] array3 = array.clone();
        SortTestHelper.testSort("sort_nlogn.quick_sort.Quick3WaysSort",array);
        SortTestHelper.testSort("sort_nlogn.quick_sort.QuickSort",array2);
//        SortTestHelper.testSort("sort_nlogn.quick_sort.QuickSort2",array3);
        QuickSort2 quickSort2 = new QuickSort2();
    }

}

