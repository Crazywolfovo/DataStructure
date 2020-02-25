package com.datastructure.Tree;

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    @SuppressWarnings("unchecked")
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在rootIndex的位置创建表示区间[l,r]的线段树
     *
     * @param rootIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int rootIndex, int l, int r) {
        if (l == r) {
            tree[rootIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(rootIndex);
        int rightTreeIndex = rightChild(rootIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[rootIndex] = merger.apply(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @return
     * @Param index
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @return
     * @Param index
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }


    public E get(int index) {
        if (index < 0 || index >= getSize())
            throw new IllegalArgumentException("Index is illegal ~ ");
        return data[index];
    }

    /**
     * 查询区间[l,r]线段树所存储的值
     *
     * @param l
     * @param r
     * @return 值
     */
    public E query(int l, int r) {
        if (l < 0 || l > getSize() || r < 0 || r > getSize() || l > r)
            throw new IllegalArgumentException("Index is illegal");
        return query(0, 0, getSize() - 1, l, r);
    }

    /**
     * 在[l,r]的范围中搜索[queryL,query]的值
     *
     * @param rootIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int rootIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR)
            return tree[rootIndex];
        int leftTreeIndex = leftChild(rootIndex);
        int rightTreeIndex = rightChild(rootIndex);
        int mid = l + (r - l) / 2;
        if (queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);
        else {
            E lResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.apply(lResult, rResult);
        }
    }

    /**
     * 更新线段树的某个所索引所对应的元素
     *
     * @param e     元素
     * @param index 索引
     */
    public void set(E e, int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal ~ ");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * O(longn)，后续遍历的思想
     *
     * @param rootIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int rootIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[rootIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(rootIndex);
        int rightTreeIndex = rightChild(rootIndex);
        if (index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else
            set(leftTreeIndex, l, mid, index, e);
        tree[rootIndex] = merger.apply(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
