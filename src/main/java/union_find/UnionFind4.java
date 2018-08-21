package union_find;

/**
 * 改进uf3，基于rank即高度，而不是元素个数
 * 引入一个新的数组，来存放两个节点树的高度，让矮的指向高的节点
 * Create By 曹通
 * 2018/8/8 15:26
 */
public class UnionFind4 {
    private int[] parent;
    private int count;
    private int[] rank;// sz[i]表示以i为根的集合中元素的个数

    public UnionFind4(int count) {
        this.count = count;
        parent = new int[count];
        rank = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p) {
        assert (p >= 0 && p < count);
        // 寻找p的根节点
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (rank[pRoot] < rank[qRoot]) {
            // 矮的树连接到高的
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            // 相等时被指向的那个树的高度加了1
            rank[pRoot] += 1;
        }
    }
}
