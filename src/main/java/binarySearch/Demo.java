package binarySearch;


import java.math.BigDecimal;
import java.util.*;

/**
 * Create By 曹通
 * 2018/8/7 21:03
 */
public class Demo {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = numsCopy[i] + numsCopy[j];
            if (sum == target) {
                result[0] = numsCopy[i];
                result[1] = numsCopy[j];
                break;
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        int k1 = result[0];
        int k2 = result[1];
        for (int m = 0; m < nums.length; m++) {
            if (k1 == nums[m]) {
                result[0] = m;
                break;
            }
        }
        for (int n = nums.length; n >= 0; n--) {
            if (k2 == nums[n]) {
                result[1] = n;
                break;
            }
        }
        return result;
    }

    public static int reverse(int x) {
        String xStr = String.valueOf(x);
        char[] chars = xStr.toCharArray();
        char[] clone = new char[chars.length];
        if (xStr.startsWith("-")) {
            int i = 1, j = chars.length - 1;
            while (i <= j) {
                clone[i] = chars[j];
                clone[j] = chars[i];
                i++;
                j--;
            }
            clone[0] = '-';
        } else {
            int i = 0, j = chars.length - 1;
            while (i <= j) {
                clone[i] = chars[j];
                clone[j] = chars[i];
                i++;
                j--;
            }
        }
        String string = new String(clone);
        int result = 0;
        try {
            result = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() < 1)
//            return 0;
//        HashSet<Character> set = new HashSet<Character>();
//        int pre = 0;
//        int max_str = Integer.MIN_VALUE;
//        int i = 0;
//        int len = s.length();
//        while (i < len) {
//            if (set.contains(s.charAt(i))) {
//                max_str = Math.max(max_str, i - pre);
//                while (s.charAt(pre) != s.charAt(i)) {
//                    set.remove(s.charAt(pre));
//                    pre++;
//                }
//                pre++;
//            } else
//                set.add(s.charAt(i));
//            i++;
//        }
//        max_str = Math.max(max_str, i - pre); // i一直向后，直到超出s的长度，此时也要计算窗口的大小
//        return max_str;
        // 下面的比较牛逼
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[count]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder v1 = new StringBuilder();
        StringBuilder v2 = new StringBuilder();
        while (l1 != null) {
            v1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            v2.append(l2.val);
            l2 = l2.next;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();
        // 把两个倒过来了
        for (int i = v1.length() - 1; i >= 0; i--) {
            sb1.append(v1.charAt(i));
        }
        for (int i = v2.length() - 1; i >= 0; i--) {
            sb2.append(v2.charAt(i));
        }
        int jinwei = 0;
        for (int i = 0, j = 0; i < sb1.length() && j < sb2.length(); i++, j++) {
            int iNum = sb1.charAt(i) - '0';
            int jNum = sb1.charAt(j) - '0';
            int add = iNum + jNum + jinwei;
            if (add < 0) {
                resultBuilder.append(add);
                jinwei = 0;
            } else {
                resultBuilder.append(add - 10);
                jinwei = 1;
            }
        }
        if (sb1.length() < sb2.length()) {
            for (int i = sb1.length(); i < sb2.length(); i++) {
                int num = sb2.charAt(i) - '0';

            }
        }
        return null;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        // index设置为-1是因为有可能输入只有一个0的数组
        int index = -1;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, i - index - 1);
                index = i;
            }
            // 等于1的话就继续往后走
        }
        max = Math.max(max, i - index - 1);

        return max;
    }

    public static int findlength() {
        int n = 1, t = 0;
        int count = 0;
        while (n <= 1000) {
            if (t % 2 == 0 && 1000 % (1 + t) == 0) {
                count++;
            }
            n++;
            t++;
        }
        return count;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x >= 0 && x <= 9)
            return true;
        // 首先得到一共有多少位
        int count = 0;
        int xCopy = x;
        while (xCopy > 0) {
            xCopy = xCopy / 10;
            count++;
        }
        while (count > 0) {
            int i = x % 10;
            int pow = (int) Math.pow(10, (count - 1));
            int j = x / pow;
            if (i != j) {
                return false;
            } else {
                x = (x - i * pow) / 10;
                count -= 2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(4);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(7);
//        ListNode listNode = Demo.addTwoNumbers(l1, l2);
//        System.out.println(listNode.val);
//        int[] a = {1,0,1,1,0,1};
//        int maxConsecutiveOnes = Demo.findMaxConsecutiveOnes(a);
//        System.out.println(maxConsecutiveOnes);
//        Demo demo = new Demo();
//        demo.getClass().getName()
//        int count = 0;
//        int i = 1;
//        while (count != 1500) {
//            i++;
//            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
//                count++;
//            }
//        }
//        System.out.println(i);
//        Stack s = new Stack();
        boolean palindrome = Demo.isPalindrome(2332);
        System.out.println(palindrome);
    }
}

