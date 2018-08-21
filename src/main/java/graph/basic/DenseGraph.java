package graph.basic;

import java.util.Vector;

/**
 * 稠密图 - 用邻接矩阵实现
 * Create By 曹通
 * 2018/8/9 14:43
 */
public class DenseGraph {
    // 定点数
    private int v;
    // 边数
    private int e;
    // 图的具体内容
    private boolean[][] g;
    // 是否为有向图
    private boolean isDirected;

    // 通过指定定点数和isDirected构造一个空图
    public DenseGraph(int v, boolean isDirected) {
        assert v >= 0;
        this.v = v;
        this.isDirected = isDirected;
        v = 0;
        g = new boolean[v][v];
    }

    // 返回图的定点数
    public int V() {
        return v;
    }

    // 返回图的边数
    public int E() {
        return e;
    }

    // 添加一条边
    public void addEdge(int p, int q) {
        assert p >= 0 && p < v;
        assert q >= 0 && q < v;
        if (hasEdge(p, q))
            return;
        g[p][q] = true;
        if (!isDirected)
            g[q][p] = true;
        // 要记得边数加一
        e++;
    }

    // 判断两个定点之间是否有边
    boolean hasEdge(int p, int q) {
        assert p >= 0 && p < v;
        assert q >= 0 && q < v;
        return g[p][q];
    }

    // 返回图中一个顶点的所有邻边
    public Iterable<Integer> adj(int p) {
        assert p >= 0 && p < v;
        Vector<Integer> adjP = new Vector<>();
        for (int i = 0; i < v; i++) {
            if (g[p][i])
                adjP.add(i);
        }
        return adjP;
    }
}
