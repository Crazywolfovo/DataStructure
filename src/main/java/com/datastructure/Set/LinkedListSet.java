package com.datastructure.Set;

import com.datastructure.LinkedList.LinkedList;

public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    /**
     * O(n)
     *
     * @param e 元素
     */
    @Override
    public void add(E e) {
        // 去重
        if (!list.contains(e))
            list.addFirst(e);
    }

    /**
     * O(n)
     *
     * @param e 元素
     */
    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    /**
     * O(n)
     *
     * @param e 元素
     * @return
     */
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
