package graph.read_graph;

import java.util.Vector;

/**
 * 稀疏图用邻接表来表示
 * Create By 曹通
 * 2018/8/9 14:58
 */
public class SparseGraph implements Graph {
    private int v;
    private int e;
    private Vector<Integer>[] g;
    private boolean isDirected;

    @SuppressWarnings("unchecked")
    public SparseGraph(int v, boolean isDirected) {
        assert v >= 0;
        this.v = v;
        this.isDirected = isDirected;
        this.e = 0;
        g = (Vector<Integer>[]) new Vector[v];
        for (int i = 0; i < v; i++) {
            g[i] = new Vector<>();
        }
    }

    public int V() {
        return v;
    }

    public int E() {
        return e;
    }

    public void addEdge(int p, int q) {
        assert p >= 0 && p < v;
        assert q >= 0 && q < v;
        g[p].add(q);
        if (p != q && !isDirected)
            g[q].add(p);
        e++;
    }

    // 判断是否有边
    public boolean hasEdge(int p, int q) {
        assert p >= 0 && p < v;
        assert q >= 0 && q < v;
        for (int i = 0; i < g[p].size(); i++) {
            if (g[p].elementAt(i) == q)
                return true;
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < v; i++) {
            Vector<Integer> edges = g[i];
            System.out.printf("顶点%d的邻边为:", i);
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(edges.get(j)+" ");
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    public Iterable<Integer> adj(int p) {
        assert p >= 0 && p < v;
        return g[p];
    }
}
