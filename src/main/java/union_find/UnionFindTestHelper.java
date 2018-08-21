package union_find;

/**
 * Create By 曹通
 * 2018/8/8 14:22
 */
public class UnionFindTestHelper {
    public static void testUF1(int n) {
        UnionFind1 unionFind1 = new UnionFind1(n);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机合并两个
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind1.union(p, q);
        }
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机测试两个是否相连
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind1.isConnected(p, q);
        }
        long time3 = System.currentTimeMillis();

        System.out.printf("合并操作耗时%dms%n", (int) (time2 - time1));
        System.out.printf("查找操作耗时%dms%n", (int) (time3 - time2));
    }

    public static void testUF2(int n) {
        UnionFind2 unionFind2 = new UnionFind2(n);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机合并两个
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind2.unionElements(p, q);
        }
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机测试两个是否相连
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind2.isConnected(p, q);
        }
        long time3 = System.currentTimeMillis();

        System.out.printf("合并操作耗时%dms%n", (int) (time2 - time1));
        System.out.printf("查找操作耗时%dms%n", (int) (time3 - time2));
    }

    public static void testUF3(int n) {
        UnionFind3 unionFind3 = new UnionFind3(n);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机合并两个
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind3.unionElements(p, q);
        }
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机测试两个是否相连
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind3.isConnected(p, q);
        }
        long time3 = System.currentTimeMillis();

        System.out.printf("合并操作耗时%dms%n", (int) (time2 - time1));
        System.out.printf("查找操作耗时%dms%n", (int) (time3 - time2));
    }
    public static void testUF4(int n) {
        UnionFind4 unionFind4 = new UnionFind4(n);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机合并两个
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind4.unionElements(p, q);
        }
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机测试两个是否相连
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind4.isConnected(p, q);
        }
        long time3 = System.currentTimeMillis();

        System.out.printf("合并操作耗时%dms%n", (int) (time2 - time1));
        System.out.printf("查找操作耗时%dms%n", (int) (time3 - time2));
    }
    public static void testUF5(int n) {
        UnionFind5 unionFind4 = new UnionFind5(n);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机合并两个
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind4.unionElements(p, q);
        }
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            // 随机测试两个是否相连
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);
            unionFind4.isConnected(p, q);
        }
        long time3 = System.currentTimeMillis();

        System.out.printf("合并操作耗时%dms%n", (int) (time2 - time1));
        System.out.printf("查找操作耗时%dms%n", (int) (time3 - time2));
    }
    public static void main(String[] args) {
//        testUF3(1000000);
        testUF4(1000000);
        testUF5(1000000);
    }
}
