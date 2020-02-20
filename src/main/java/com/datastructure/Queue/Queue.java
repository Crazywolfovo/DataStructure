package com.datastructure.Queue;

/**
 * FIFO
 */
public interface Queue<E> {
    /**
     * 入队
     * O(1)
     *
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 出队
     * O(n) -> o(1)
     *
     * @return 元素
     */
    E dequeue();

    /**
     * 检查队首元素
     * O(1)
     *
     * @return 元素
     */
    E getFront();

    /**
     * 获取队列长度
     * O(1)
     *
     * @return 长度
     */
    int getSize();

    /**
     * 是否为空
     * o(1)
     *
     * @return boolean
     */
    boolean isEmpty();
}
