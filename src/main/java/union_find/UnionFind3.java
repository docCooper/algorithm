package union_find;

/**
 * 改进uf2，让生成的树尽可能的矮
 * 引入一个新的数组，来存放两个节点树的高度，让矮的指向高的节点
 * Create By 曹通
 * 2018/8/8 15:26
 */
public class UnionFind3 {
    private int[] parent;
    private int count;
    private int[] sz;// sz[i]表示以i为根的集合中元素的个数

    public UnionFind3(int count) {
        this.count = count;
        parent = new int[count];
        sz = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
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
        if (sz[pRoot] < sz[qRoot]) {
            // 矮的树连接到高的
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
