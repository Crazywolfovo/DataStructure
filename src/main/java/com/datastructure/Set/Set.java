package com.datastructure.Set;

public interface Set<E> {
    /**
     * 添加元素，不能添加重复元素
     *
     * @param e 元素
     */
    void add(E e);

    /**
     * 删除元素 e
     *
     * @param e
     */
    void remove(E e);

    /**
     * 检查元素是否包含在集合内部
     *
     * @param e 元素
     * @return boolean
     */
    boolean contains(E e);

    /**
     * 返回集合实际元素个数
     *
     * @return 元素个数
     */
    int getSize();

    /**
     * 集合是否为空
     *
     * @return boolean
     */
    boolean isEmpty();
}
