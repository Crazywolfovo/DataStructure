package com.datastructure.HashTable;

import java.util.TreeMap;

public class HashTable<K, V> {
    private TreeMap<K, V>[] hashtable;
    /**
     * 一个素数
     */
    private int M;
    private int size;

    public HashTable(int m) {
        this.M = m;
        this.size = 0;
        this.hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    /**
     * 核心
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if (!treeMap.containsKey(key)) size++;
        treeMap.put(key, value);
    }

    public V remove(K key) {
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        V ret = null;
        if (treeMap.containsKey(key)) {
            ret = treeMap.remove(key);
            size--;
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if (!treeMap.containsKey(key))
            throw new IllegalArgumentException(key + " doesn`t exist ~");
        treeMap.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }
}
