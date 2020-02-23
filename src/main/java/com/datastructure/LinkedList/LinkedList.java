package com.datastructure.LinkedList;

public class LinkedList<E> {

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
    private Node dummyHead;

    /**
     * 链表实际大小
     */
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表实际大小票
     *
     * @return 大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素
     * O(1)
     *
     * @param e 元素
     */
    public void addFirst(E e) {
       /* Node node = new Node(e);
        node.next = head;
        head = node;*/
        add(e, 0);
    }

    /**
     * 向链表尾添加元素
     * O(n)
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(e, size);
    }

    /**
     * 在链表的索引位置添加新的元素
     * 链表基本不用索引，因此并不常用
     * O(n)
     *
     * @param e     元素
     * @param index 索引
     */
    public void add(E e, int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Add failed.Illegal index ~");
        //初始位置在dummyHead的位置指针
        Node prev = dummyHead;
        //推动指针向后移动
        for (int i = 0; i < index; i++) prev = prev.next;
        /*Node newNode = new Node(e);
        newNode.next = prev.next;
        prev.next = newNode;*/
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 获取链表头元素
     * O(1)
     *
     * @return 元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表尾元素
     * O(n)
     *
     * @return 元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取链表中某个索引位置的元素
     * 链表基本不用索引，因此并不常用
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Get failed.Illegal index ~");
        //初始位置在dummyHead.next的位置指针
        Node current = dummyHead.next;
        //推动指针向后移动
        for (int i = 0; i < index; i++) current = current.next;
        return current.e;
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            } else {
                //推动指针向后移动
                current = current.next;
            }
        }
        return false;
    }

    /**
     * 更新链表中某个索引位置的元素
     * 链表基本不用索引，因此并不常用
     * O(n)
     *
     * @param e     元素
     * @param index 索引
     */
    public void set(E e, int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Set failed.Illegal index ~");
        //初始位置在dummyHead.next的位置指针
        Node current = dummyHead.next;
        //推动指针向后移动
        for (int i = 0; i < index; i++) current = current.next;
        current.e = e;
    }

    /**
     * 删除链表的第一个元素
     * O(1)
     *
     * @return 元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表的最后一个元素
     * O(n)
     *
     * @return 元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定索引的元素
     * 链表基本不用索引，因此并不常用
     * O(n)
     *
     * @param index 索引
     * @return 元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Set failed.Illegal index ~");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) prev = prev.next;
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 从链表中删除元素e
     *
     * @param e 元素e
     */
    public void removeElement(E e) {

        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
       /* Node current = dummyHead.next
       while (current != null) {
            s
            current = current.next;
        }*/
        for (Node current = dummyHead.next; current != null; current = current.next) str.append(current).append(" -> ");
        str.append("null");
        return str.toString();
    }
}
