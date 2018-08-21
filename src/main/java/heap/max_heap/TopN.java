package heap.max_heap;

import utils.SwapUtils;

import javax.xml.ws.Endpoint;

/**
 * 使用堆排序找出前N大的元素
 * Create By 曹通
 * 2018/7/30 16:04
 */
public class TopN {
    public static Comparable[] top_n(Comparable arr[], int n) {
        // 创建一个大小为n的堆
        MaxHeap maxHeap = new MaxHeap(n);
        assert arr.length > n;
        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = n; i < arr.length; i++) {
            // 找到堆中最小的元素的index,一定是叶子节点
            int j = n / 2 + 1;

            int minIndex = n / 2 + 1;
            for (; j <= n; j++) {
                if (maxHeap.data[minIndex].compareTo(maxHeap.data[j]) > 0) {
                    minIndex = j;
                }
            }
            // 将最小的替换掉
            maxHeap.data[minIndex] = arr[i];
            maxHeap.shiftUP(minIndex);
        }
        Comparable[] ret = new Comparable[n];
        for (int i = n - 1; i >= 0; i--) {
            ret[i] = maxHeap.extractMax();
        }
        return ret;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 4, 5, 6, 44, 24, 76, 43, 12,89,3,12,53};
        Comparable[] comparables = top_n(arr, 5);
        System.out.println("结束");
    }
}
