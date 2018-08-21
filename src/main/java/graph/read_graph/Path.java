package graph.read_graph;

import java.util.Stack;
import java.util.Vector;

/**
 * Create By 曹通
 * 2018/8/16 19:07
 */
public class Path {
    private Graph G;
    private int s; // 起始点
    private boolean[] visited; // 记录dfs过程中节点是否被访问
    private int[] from; // from[i]表示i的上一个节点

    // 图的深度优先遍历
    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.adj(v)) {
            if (!visited[i]) {
                // i是从v来的
                from[i] = v;
                dfs(i);
            }
        }
    }

    // 构造函数，寻路算法，寻找图graph从s点到其他点的路径
    public Path(Graph graph, int s) {
        G = graph;
        assert s >= 0 && s < G.V();
        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;
        // 寻路算法
        dfs(s);
    }

    // 查询从s点到w点是否有路径
    boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 查询从s点到w点的路径，存放在vec中
    Vector<Integer> path(int w) {
        assert hasPath(w);
        Stack<Integer> s = new Stack<>();
        // 通过from数组逆向查找从s到w的路径，存放在栈中
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }
        // 从栈中一次取出元素，获得顺序的从s到w的路径
        Vector<Integer> res = new Vector<>();
        while (!s.empty())
            res.add(s.pop());
        return res;
    }

    void showPath(int w) {
        assert hasPath(w);
        Vector<Integer> vector = path(w);
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.elementAt(i));
            if (i == vector.size() - 1)
                System.out.print("");
            else
                System.out.print(" -> ");
        }
    }
}
