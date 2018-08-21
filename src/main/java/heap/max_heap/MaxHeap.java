package heap.max_heap;

import utils.SwapUtils;

/**
 * 使用数组构造一个最大堆
 * Create By 曹通
 * 2018/7/27 10:55
 */
public class MaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造一个课容纳capacity个元素的空堆
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(Item[] arr){
        // 元素的个数
        int n = arr.length;
        // 第一个不存东西所以要多开辟一个
        data = (Item[]) new Comparable[n+1];
        capacity = n;
        for (int i=0;i<n;i++)
            data[i+1] = arr[i];
        count = n;
        for (int i =count/2;i>=1;i--)
            shiftDown(i);
    }

    // 返回堆中元素个数
    public int size() {
        return count;
    }

    // 返回是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(Item item) {

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUP(count);
    }

    /**
     * 从堆中取元素
     * Create By 曹通
     * 2018/7/27 14:47
     *
     * @param []
     * @return Item
     */
    public Item extractMax() {
        assert count > 0;
        Item item = data[1];
        SwapUtils.swap(data, 1, count);
        count--;
        shiftDown(1);
        return item;
    }

    private void shiftDown(int k) {

        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j].compareTo(data[j + 1]) < 0)
                j ++;
            if (data[k].compareTo(data[j]) >= 0)
                break;
            SwapUtils.swap(data, k, j);
            k = j;
        }
    }

    /**
     * 将新加入的元素放到合适的位置
     * Create By 曹通
     * 2018/7/27 11:03
     *
     * @param []
     * @return void
     */
    public  void shiftUP(int k) {
        while (k > 1 && (data[k].compareTo(data[k / 2]) > 0)) {
            SwapUtils.swap(data, k, k / 2);
            k = k / 2;
        }
    }

    public static void main(String[] args) {
        Integer[] integer = {2,3,14,32,21,5,11};
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(integer);
//        int N = 50; // 堆中元素个数
//        int M = 100; // 堆中元素取值范围[0, M)
//        for (int i = 0; i < N; i++)
//            maxHeap.insert(new Integer((int) (Math.random() * M)));
        System.out.println("size="+maxHeap.size());
        for (int j = 0; j < integer.length; j++) {
            Integer data = maxHeap.extractMax();
            System.out.println("max="+ data);
        }

    }
}
