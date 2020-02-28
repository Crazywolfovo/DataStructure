package com.datastructure.Set;

import com.datastructure.Tree.BST;

public class BstSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BstSet() {
        bst = new BST<>();
    }

    /**
     * 底层二分搜索树会忽略重复元素
     * O(depth)
     * depth = log2(n+1) = O(log n)
     *
     * @param e 元素
     */
    @Override
    public void add(E e) {
        bst.add(e);
    }

    /**
     * O(depth)
     * O(log n)
     *
     * @param e 元素
     */
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    /**
     * O(depth)
     * O(log n)
     *
     * @param e 元素
     */
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
