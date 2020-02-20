package com.datastructure.Stack;

/**
 * LIFO
 */
public interface Stack<E> {
    /**
     * 入栈
     * O(1)
     *
     * @param e 入栈元素
     */
    void push(E e);

    /**
     * 出栈
     * O(1)
     *
     * @return 出栈元素
     */
    E pop();

    /**
     * 检查栈顶元素
     * O(1)
     *
     * @return 栈顶元素
     */
    E peek();

    /**
     * 检查栈的大小
     * O(1)
     *
     * @return 大小
     */
    int getSize();

    /**
     * 是否为空
     * O(1)
     *
     * @return boolean
     */
    boolean isEmpty();
}
