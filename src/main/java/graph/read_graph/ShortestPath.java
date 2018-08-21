package graph.read_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * Create By 曹通
 * 2018/8/17 10:19
 */
public class ShortestPath {
    private Graph G;
    private int s; // 起始点
    private boolean[] visited;
    private int[] from;
    private int[] ord; // 记录路径中节点的次序，ord[i]表示i节点在路径中的次序，从0开始

    public ShortestPath(Graph g, int s) {
        G = g;
        assert s >= 0 && s < G.V();
        // 初始化
        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;
        // 从s开始广度优先遍历整张图
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int i : G.adj(v)) {
                if (!visited[i]) {
                    q.add(i);
                    from[i] = v;
                    visited[i] = true;
                    ord[i] = ord[v] + 1;
                }
            }
        }
    }

    // 查询从s点到w点是否有路径
    public boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 查询从s点到w点的路径，存放在vec中
    public Vector<Integer> path(int w) {
        assert hasPath(w);
        Stack<Integer> s = new Stack<>();
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }
        Vector<Integer> res = new Vector<>();
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }

    // 打印从s点到w点的路径
    public void showPath(int w) {
        assert hasPath(w);
        Vector<Integer> vec = path(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.elementAt(i));
            if (i == vec.size() - 1)
                System.out.println();
            else
                System.out.println(" -> ");
        }
    }

    // 查看最短路径的长度
    public int length(int w) {
        assert w >= 0 && w < G.V();
        return ord[w];
    }
}
