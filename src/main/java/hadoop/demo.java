package hadoop;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Create By 曹通
 * 2018/8/1 11:14
 */
public class demo  {

    public static void strTest(){
        String line = "s s1 ssss2 sn";
        String[] arr = line.split(" ");
        byte[] b = line.getBytes();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(b));
//        StringBuffer stringBuffer = new StringBuffer(line);
//        StringBuilder builder = new StringBuilder(line);
    }

    public static void main(String[] args) {
        demo.strTest();
    }
}
