package sort.selectSort.domin;

/**
 * Create By 曹通
 * 2018/7/23 9:44
 */
public class Student implements Comparable<Student> {
    private int score;
    private int age;
    private String name;

    public void setScore(int score) {
        this.score = score;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {

        return score;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student that) {
        //成绩倒序
        if (this.score<that.score){
            return -1;
        }else if (this.score>that.score){
            return 1;
        }else {
            // 年龄正序
            if (this.age>that.age){
                return 1;
            }else if (this.age<that.age){
                return -1;
            }else {
                // 否则按名字的字母排序
                return this.name.compareTo(that.name);
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
