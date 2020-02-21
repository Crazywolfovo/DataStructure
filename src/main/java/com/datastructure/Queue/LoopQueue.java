package com.datastructure.Queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;


    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) resize(2 * getCapacity());
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalArgumentException("Can not dequeue from an empty queue ~");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) throw new IllegalArgumentException("Can not dequeue from an empty queue ~");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) newData[i] = data[(i + front) % data.length];
        /*
        if (front < tail) System.arraycopy(data, front, newData, 0, tail - front + 1);
        if (front > tail) {
            System.arraycopy(data, front, newData, 0, size - front + 1);
            System.arraycopy(data, 0, newData, size - front + 1, tail);
        }*/
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            str.append(data[i]);
            if ((i + 1) % data.length != tail) str.append(", ");
        }
        str.append("] Tail");
        return "LoopQueue{" +
                "data=" + str +
                ", size=" + size +
                ", capacity=" + getCapacity() +
                '}';
    }
}
