package graph.basic;

/**
 * Create By 曹通
 * 2018/8/9 16:25
 */
public class Test {

    private static void testSparseGraph() {
        // N个节点，M条边
        int N = 20;
        int M = 100;
        SparseGraph graph = new SparseGraph(N, false);
        // 构建一个稀疏图
        for (int i = 0; i < M; i++) {
            int a = (int) (Math.random() * N);
            int b = (int) (Math.random() * N);
            graph.addEdge(a, b);
        }
        // 找出每个节点的邻边
        for (int i = 0; i < N; i++) {
            System.out.printf("节点%d的邻边:", i);
            Iterable<Integer> adj = graph.adj(i);
            for (Integer e : adj) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Test.testSparseGraph();
    }
}
