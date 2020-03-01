package com.datastructure.Map;

import com.datastructure.Tree.BST2;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private BST2<K, V> bst;

    public BSTMap() {
        this.bst = new BST2<>();
    }

    @Override
    public void add(K key, V value) {
        bst.add(key, value);
    }

    @Override
    public V remove(K key) {
        return bst.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return bst.contains(key);
    }

    @Override
    public V get(K key) {
        return bst.get(key);
    }

    @Override
    public void set(K key, V value) {
        bst.set(key, value);
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
