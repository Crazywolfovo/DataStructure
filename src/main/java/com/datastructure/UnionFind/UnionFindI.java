package com.datastructure.UnionFind;

public class UnionFindI implements UnionFind {
    private int[] id;

    public UnionFindI(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) id[i] = i;
    }

    /**
     * 判断连个元素是否可连接
     * O(1)
     *
     * @param p 元素1
     * @param q 元素2
     * @return boolean
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并两个元素 == 两个元素可以连接，
     * 并且和p链接的元素，与和q链接的元素，
     * 也一并链接起来
     * O(n)
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElement(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId != qId) {
            for (int i = 0; i < getSize(); i++) {
                if (id[i] == pId)
                    id[i] = qId;
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p所对应的编号
     * O(1)
     *
     * @param p 元素
     * @return 编号
     */
    private int find(int p) {
        if (p < 0 || p >= getSize())
            throw new IllegalArgumentException(p + " is out of bound ~ ");
        return id[p];
    }
}
