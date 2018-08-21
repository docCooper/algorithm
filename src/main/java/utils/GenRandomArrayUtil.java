package utils;

/**
 * Create By 曹通
 * 2018/7/21 14:09
 */
public class GenRandomArrayUtil {
    /**
     *  生成随机数数组
     * Create By 曹通
     * 2018/7/21 14:19
     * @param [n, rangeL, rangeR]
     * @return int[]
     */
    public static int[] genRandomArray(int n,int rangeL,int rangeR){
        // 如果上限不大于下限就会抛出AssertionError
        assert rangeL<rangeR;
        int[] arr = new int[n];
        for (int j = 0;j<n;j++){
            int i = rangeL+(int)(Math.random()*(rangeR-rangeL+1));
            arr[j]=i;
        }
        return arr;
    }
}
