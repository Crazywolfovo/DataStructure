package com.datastructure.Queue;

import com.datastructure.Heap.MaxHeap;

/**
 * 优先队列
 *
 * @param <E>
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> heap;

    public PriorityQueue() {
        heap = new MaxHeap<>();
    }


    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E dequeue() {
        return heap.extractMax();
    }

    @Override
    public E getFront() {
        return heap.findMax();
    }

    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
