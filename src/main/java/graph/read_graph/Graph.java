package graph.read_graph;

/**
 * Create By 曹通
 * 2018/8/9 17:18
 */
public interface Graph {
    public int V();

    public int E();

    public void addEdge(int p, int q);

    boolean hasEdge(int p, int q);

    public void show();

    public Iterable<Integer> adj(int v);
}
