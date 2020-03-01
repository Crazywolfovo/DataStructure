package com.datastructure.HashTable;

import java.util.TreeMap;

public class HashTable<K, V> {

    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private static final int upperTol = 10;

    private static final int lowerTol = 2;

    private int capacityIndex = 0;

    private TreeMap<K, V>[] hashtable;
    /**
     * 一个素数
     */
    private int M;
    private int size;

    public HashTable() {
        this.M = capacity[capacityIndex];
        this.size = 0;
        this.hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
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
        if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
            capacityIndex++;
            resize(capacity[capacityIndex]);
        }
    }

    public V remove(K key) {
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        V ret = null;
        if (treeMap.containsKey(key)) {
            ret = treeMap.remove(key);
            size--;
            if (size < lowerTol * M && capacityIndex - 1 > 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
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

    /**
     * 自动扩缩容机制
     *
     * @param newM 新的M
     */
    private void resize(int newM) {
        TreeMap<K, V>[] newHashtable = new TreeMap[newM];
        for (int i = 0; i < newM; i++)
            newHashtable[i] = new TreeMap<>();
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet())
                newHashtable[hash(key)].put(key, map.get(key));

        }
        this.hashtable = newHashtable;
    }
}
