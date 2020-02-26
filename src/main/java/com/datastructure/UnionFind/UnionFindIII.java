package com.datastructure.UnionFind;

public class UnionFindIII implements UnionFind {
    private int[] parent;
    /**
     * 以i为根的集合中，元素的个数
     */
    private int[] sz;

    public UnionFindIII(int size) {
        this.parent = new int[size];
        this.sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并两个元素 == 两个元素可以连接，
     * 并且和p链接的元素，与和q链接的元素，
     * 也一并链接起来
     * O(h)
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            if (sz[pRoot] < sz[qRoot]) {
                parent[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            } else {//sz[pRoot] >= sz[qRoot]
                parent[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找元素p所对应的编号
     * O(h)
     *
     * @param p 元素
     * @return 编号
     */
    private int find(int p) {
        if (p < 0 || p >= getSize())
            throw new IllegalArgumentException(p + " is out of bound ~ ");
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}

