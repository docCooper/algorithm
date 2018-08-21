package sort.bubbleSort;

import utils.SwapUtils;

/**
 * Create By 曹通
 * 2018/7/23 16:00
 */
public class BubbleSort {
    public static void bubbleSort(int arr[]){
        int n = arr.length;
        boolean flag = true;
        while (flag){
            flag = false;
            int newn = 0;
            for(int i=1;i<n;i++){
                if(arr[i]<arr[i-1]){
                    SwapUtils.swap(arr,i,i-1);
                    flag = true;
                    newn = i;// 记录最后一个交换的位置，后面的不再考虑
                }
            }
            n = newn;
           // n--;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,42,4,3,5,3,16,7,554,44};
        BubbleSort.bubbleSort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
