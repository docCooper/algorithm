package binarySearch;

/**
 * Create By 曹通
 * 2018/8/7 13:42
 */
public class Recursion {
    private static void hanoi(int count, String t1, String t2, String t3) {
        if (count == 1) {
            System.out.println(t1 + "===>" + t3);
            return;
        }
        hanoi(count - 1, t1, t3, t2);
        hanoi(1, t1, t2, t3);
        hanoi(count - 1, t2, t1, t3);
    }

    //    int [] row = new int[8];
//    int eightQueen(){
//
//    }
//    public int[] twoSum(int[] nums, int target) {
//    }

    public static void main(String[] args) {
        Recursion.hanoi(4, "a", "b", "c");
        char s = 'a';
    }
}
