package union_find;

/**
 * 并查集,下标是数据，数组中存储的是其所属类别
 * quickFind,查找非常快，合并比较慢
 * Create By 曹通
 * 2018/8/8 12:27
 */
public class UnionFind1 {
    private int[] ids;
    private int count;

    public UnionFind1(int n) {
        //初始化一个并查集，每个节点都指向自己
        count = n;
        ids = new int[n];
        for (int i = 0; i < count; i++)
            ids[i] = i;

    }

    // 查，只需O(1)的时间复杂度
    private int find(int p) {
        assert p >= 0 && p < count;
        return ids[p];
    }

    // 并
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;
        for (int i = 0; i < ids.length; i++) {
            // 将p和q归于一个类别
            if (ids[i] == pId)
                ids[i] = qId;
        }
    }

    // 看两个是否相连
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
