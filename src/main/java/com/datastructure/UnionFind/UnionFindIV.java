package com.datastructure.UnionFind;

public class UnionFindIV implements UnionFind {
    private int[] parent;
    /**
     * 以i为根的集合所表示的树的层数
     */
    private int[] rank;

    public UnionFindIV(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[qRoot] = pRoot;
                rank[pRoot] += 1;
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

