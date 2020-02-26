package com.datastructure.UnionFind;

/**
 * 并查集
 */
public interface UnionFind {

    /**
     * i两个元素是否能够相连
     * Quick Find :find(p) == find(q) O(1)
     *
     * @param p
     * @param q
     * @return boolean
     */
    boolean isConnected(int p, int q);

    /**
     * 链接元素
     *
     * @param p
     * @param q
     */
    void unionElement(int p, int q);

    /**
     * 获取并查集元素数量
     *
     * @return 数量
     */
    int getSize();
}
