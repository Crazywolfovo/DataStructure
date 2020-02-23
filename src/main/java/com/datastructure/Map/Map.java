package com.datastructure.Map;

public interface Map<K, V> {
    /**
     * 添加字典
     *
     * @param key   键
     * @param value 值
     */
    void add(K key, V value);

    /**
     * 移除字典中的键值对
     *
     * @param key 键
     * @return 值
     */
    V remove(K key);

    /**
     * 检查字典中是否包含键
     *
     * @param key 键
     * @return boolean
     */
    boolean contains(K key);

    /**
     * 获取键对应的值
     *
     * @param key 键
     * @return 值
     */
    V get(K key);

    /**
     * 修改键对应的值
     *
     * @param key   键
     * @param value 值
     */
    void set(K key, V value);

    /**
     * 获取字典实际数据量
     *
     * @return 数据量
     */
    int getSize();

    /**
     * 字典是否为空
     *
     * @return boolean
     */
    boolean isEmpty();
}
