package com.datastructure.Queue;

public class LinkedListQueue<E> implements Queue<E> {

    /**
     * 节点结构
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟头节点指针
     */
    private Node head, tail;

    /**
     * 链表实际大小
     */
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (null == tail) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalArgumentException("Can not dequeue from an empty queue ~");
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (null == head) tail = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) throw new IllegalArgumentException("Can not get element from an empty queue ~");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("LinkedListQueue : Front [ ");
        for (Node current = head; current != null; current = current.next)
            str.append(current).append(" -> ");
        str.append("null ] Tail");
        return str.toString();
    }
}
