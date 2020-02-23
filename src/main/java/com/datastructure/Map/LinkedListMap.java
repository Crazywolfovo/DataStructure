package com.datastructure.Map;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        /**
         * 唯一
         */
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (null == node) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (null == node)
            throw new IllegalArgumentException(key + "is not existed ~ !");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    private Node getNode(K key) {
        Node current = dummyHead.next;
        while (null != current) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
