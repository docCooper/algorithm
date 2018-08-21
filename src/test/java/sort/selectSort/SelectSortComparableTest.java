package sort.selectSort;

import org.junit.Test;
import sort.selectSort.domin.Student;

import java.util.Arrays;

/**
 * Create By 曹通
 * 2018/7/23 9:49
 */
public class SelectSortComparableTest {

    @Test
    public void sort() {
        Student [] arr = new Student[5];
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setAge(18+i);
            student.setScore(87+i);
            student.setName("张三"+i);
            arr[i] = student;
        }
        for (int j = 0;j<arr.length;j++){
            System.out.println(arr[j].toString());
        }
        SelectSortComparable.sort(arr);
//        Arrays.sort(arr);
        System.out.println("--------------------------------");
        for (int j = 0;j<arr.length;j++){
            System.out.println(arr[j].toString());
        }
    }
}
