package graph.read_graph;

/**
 * 图的深度优先和计算连通分量
 * Create By 曹通
 * 2018/8/10 11:08
 */
public class Components {
    // 记录每个节点所在的连通分量
    private int[] id;
    // 连通分量的个数
    private int account;
    private Graph g;
    private boolean[] isVisited;

    public Components(Graph g) {
        this.g = g;
        // 对变量进行一些初始化
        account = 0;
        isVisited = new boolean[g.V()];
        id = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            isVisited[i] = false;
            id[i] = -1;
        }
        // 求连通分量的个数
        for (int i = 0; i < g.V(); i++) {
            if (!isVisited[i]) {
                dfs(i);
                // 遍历完一次，就多一个连通分量
                account++;
            }
        }
    }

    public boolean isConnected(int p, int q) {
        assert p >= 0 && p < g.V();
        assert q >= 0 && q < g.V();
        return id[p] == id[q];
    }

    private void dfs(int v) {
        isVisited[v] = true;
        id[v] = account;
        for (int i : g.adj(v)) {
            if (!isVisited[i])
                dfs(i);
        }
    }

    public int getAccount() {
        return account;
    }
}
