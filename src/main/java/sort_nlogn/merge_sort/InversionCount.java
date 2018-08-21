package sort_nlogn.merge_sort;

import utils.SortTestHelper;

import java.util.Arrays;

/**
 * 使用归并排序求序列中的逆序数对
 * Create By 曹通
 * 2018/7/26 15:52
 */
public class InversionCount {

    public static long merge(Comparable[] arr, int l, int mid, int r) {
// 新开辟的空间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化逆序数对个数 res = 0
        long res = 0L;
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];
                j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l];
                i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) <= 0 ){  // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i-l];
                i ++;
            }
            else{   // 右半部分所指元素 < 左半部分所指元素
                arr[k] = aux[j-l];
                j ++;
                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - j + 1
                res += (long)(mid - i + 1);
            }
        }
        return res;
    }

    public static long solve(Comparable[] arr, int l, int r) {
        if (l >= r)
            return 0L;

        int mid = l + (r-l)/2;
        // 求出 arr[l...mid] 范围的逆序数
        long res1 = solve(arr, l, mid);
        // 求出 arr[mid+1...r] 范围的逆序数
        long res2 = solve(arr, mid + 1, r);

        return res1 + res2 + merge(arr, l, mid, r);

    }

    public static long solve(Comparable[] arr){

        int n = arr.length;
        return solve(arr, 0, n-1);
    }


    public static void main(String[] args) {
//        Integer[] integers = SortTestHelper.generateRandomArray(10, 1, 10);
        Integer[] integers = {5,2,4,3,1,9};
        SortTestHelper.printArray(integers);
        long count = solve(integers);
        System.out.println(count);
    }
}
