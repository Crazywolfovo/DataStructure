package com.datastructure.Arrays;

public class Array<E> {
    /**
     * 数据容器
     */
    private E[] data;
    /**
     * 标记符，指向数组中第一个没有内容的元素
     * size <= capacity
     */
    private int size;

    /**
     * 构造函数，控制容量
     *
     * @param capacity 数组容量 == data.length
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组尾部添加元素
     * O(1)
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组头部添加元素
     * O(n)
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在index的位置插入元素e
     * avg = O(n/2) fastest = O(1) slowest = O(n)
     *
     * @param index 要插入的位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Method:add() exec failed.index needs to be between 0 and index");
        if (size == getCapacity()) resize(2 * getCapacity());
        // for (int i = size - 1; i >= index; i--) data[i + 1] = data[i];
        // System.arraycopy 内存复制，高性能
        if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    /**
     * 获取数组最后一个元素
     *
     * @return 元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取数组第一个元素
     *
     * @return 元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取index索引对应的数组元素
     * O(1)
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Method:get() exec failed.index needs to be between 0 and index");
        return data[index];
    }

    /**
     * 设置index索引位置的数组元素，改变其值
     * O(1)
     *
     * @param index 索引
     * @param e     值
     */
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Method:get() exec failed.index needs to be between 0 and index");
        data[index] = e;
    }

    /**
     * 检查数组是否包含元素e
     * O(n)
     *
     * @param e 元素
     * @return 是否包含
     */
    public boolean containes(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    /**
     * 查找元素，返回索引
     * O(n)
     *
     * @param e 元素
     * @return 索引 ，找不到返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    /**
     * 移除数组尾部元素
     * O(1)
     *
     * @return 被移除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 移除数组头部元素
     * O(n)
     *
     * @return 被移除的元素
     */
    public E removeFirst() {
        return remove(0);
    }


    /**
     * 移除元素
     * avg = O(n/2) fastest = O(1) slowest = O(n)
     *
     * @param e 要移除的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (-1 != index) remove(index);
    }

    /**
     * 移除索引对应的元素，并返回
     * avg = O(n/2) fastest = O(1) slowest = O(n)
     *
     * @param index 索引
     * @return 被返回的元素
     */
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Method:get() exec failed.index needs to be between 0 and index");
        E ret = data[index];
        if (size - index + 1 >= 0) System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        data[size] = null;
        // lazy style ,减小震荡
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) resize(getCapacity() / 2);
        return ret;
    }

    /**
     * 动态扩容缩容
     * O(N)
     *
     * @param capacity
     */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append('[');
        for (int i = 0; i < size; i++) {
            str.append(data[i]);
            if (i != size - 1) str.append(", ");
        }
        str.append("]");
        return "Array{" +
                "data=" + str +
                ", size=" + size +
                ", capacity=" + getCapacity() +
                '}';
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("index is illegal ");
        E t = data[i];
        data[i] = data[j];
        data[j] = t;

    }
}

