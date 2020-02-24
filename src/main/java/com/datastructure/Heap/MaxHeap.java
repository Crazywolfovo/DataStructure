package com.datastructure.Heap;

import com.datastructure.Arrays.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr) {
        heapfiy(arr);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (0 == index)
            throw new IllegalArgumentException("index-0 donnot have parent ~");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素
     * O(logn)
     *
     * @param e 元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮元素到正确位置
     * 保持堆的性质
     *
     * @param k 元素的index
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (isEmpty())
            throw new IllegalArgumentException("Can not find a max element from an empty heap ~ ");
        return data.get(0);
    }

    /**
     * O(logn)
     *
     * @return 最大元素
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 下沉元素到正确位置
     * 保持堆的性质
     *
     * @param k 元素的index
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) j = rightChild(k);
            //此时，data[j] 是 leftChild 和 rightChild 中的较大值
            if (data.get(k).compareTo(data.get(j)) >= 0) break;
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆的最大值，并替换为一个新值
     * o(logn)
     *
     * @param e 被替换的新值
     * @return 堆的旧最大值
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        siftDown(0);
        return ret;
    }

    /**
     *  将一个数组格式化成堆
     * @param arr
     */
    private void heapfiy(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);

    }
}
