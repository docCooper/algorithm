package heap.max_heap;

import utils.SortTestHelper;
import utils.SwapUtils;

/**
 * 索引堆
 * Create By 曹通
 * 2018/7/30 13:38
 */
public class Heap_Idx<Item extends Comparable> {
    protected int count;
    protected Item[] data;
    protected int[] indexes;
    protected int capacity;

    // 构造函数，构造一个空堆,容量为capacity,从0开始存储
    public Heap_Idx(int capacity) {

        data = (Item[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 返回堆中元素的个数
    public int size() {
        return count;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向堆中插入一个新的元素，新插入元素的索引为i，数据为item
    // 对于用户来说，i是从0开始的
    public void insert(int i, Item item) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;
        i += 1;
        data[i] = item;
        indexes[count + 1] = i;
        count++;
        shiftUp(count);
    }

    // 向上调整，插入元素时用
    private void shiftUp(int k) {
        // 比较item的大小
        while (k / 2 >= 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            SwapUtils.swap(indexes, k, k / 2);
            k /= 2;
        }
    }

    // 取出堆顶元素
    public Item extractMax(){
        assert count>0;
        Item ret = data[indexes[1]];
        SwapUtils.swap(indexes,1,count);
        count--;
        shiftDown(1);
        return ret;
    }

    // 修改索引为i的元素，相当于调整优先级
    public void change(int i,Item newItem){
        i+=1;
        data[i] = newItem;
        // 在索引堆中找到i调整到合理位置
        for (int j =1;j<=count;j++)
            // 顺序查找，时间复杂度为O(n),可以再开辟一个数组，是索引的索引
            // 即存放索引在索引堆中的位置(索引) 可以直接根据rev[i]获取到i的索引
            // 将index_heap中的元素和和其对应的索引对调构造rev
            // rev[i] = j即说明在indexes中元素i对应的索引为j
            if (indexes[j] ==i){
                shiftUp(j);
                shiftDown(j);
                return;
            }
    }
    // 取出堆顶元素的索引
    public int extractIndex(){
        assert count>0;
        // 用户的角度，索引是从0开始的，而我们是从1开始存的，因此要减去一
        int ret = indexes[1]-1;
        SwapUtils.swap(indexes,1,count);
        count--;
        shiftDown(1);
        return ret;
    }
    // 向下调整，取元素时用
    private void shiftDown(int k) {
        while (k * 2 <= count) {
            int j = k * 2;
            if (j + 1 <= count && data[indexes[j]].compareTo(data[indexes[j + 1]]) < 0) {
                j += 1;
            }
            if (data[indexes[j]].compareTo(data[indexes[k]]) < 0) {
                break;
            }
            SwapUtils.swap(indexes, j, k);
            k = j;
        }
    }

    public static void sort(Comparable[] arr){
        int n =arr.length;
        Heap_Idx heap_idx = new Heap_Idx(n);
        for (int i = 0; i <n ; i++) {
            heap_idx.insert(i,arr[i]);
        }
        for (int i = n-1; i >=0 ; i--) {
            arr[i] = heap_idx.extractMax();
        }
    }
    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(100000, 1, 1000);
        SortTestHelper.testSort("heap.max_heap.Heap_Idx",integers);
    }
}
