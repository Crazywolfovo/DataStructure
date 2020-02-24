package com.datastructure.Map;

public class BstMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BstMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(key, value, root);
    }


    /**
     * 向以node为根的二分搜索树中插入元素
     * 递归算法Recursion
     *
     * @param key   键
     * @param value 值
     * @param node  根
     * @return
     */
    private Node add(K key, V value, Node node) {
        // 递归结束条件
        if (null == node) {
            size++;
            return new Node(key, value);
        }
        // 递归触发条件
        if (key.compareTo(node.key) < 0)
            node.left = add(key, value, node.left);
        else if (key.compareTo(node.key) > 0)
            node.right = add(key, value, node.right);
        else //key.compareTo(node.key) == 0
            node.value = value;
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key, root);
        if (null != node) {
            root = remove(key, root);
            return node.value;
        }
        return null;
    }

    /**
     * 删除以node为根的二分搜索中的元素e的节点
     *
     * @param key  键
     * @param node 旧根
     * @return 新根
     */
    private Node remove(K key, Node node) {
        if (null == node) {
            return null;
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(key, node.left);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(key, node.right);
            return node;
        } else { //e.compareTo(node.e) == 0
            if (null == node.left) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (null == node.right) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                //null != node.left && null != node.right
                //找到 min(node.right)代替要删除的节点
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }

    /**
     * 获取node为根节点的二分搜索树最小元素
     *
     * @return 最小元素
     */
    private Node minimum(Node node) {
        if (null == node.left) return node;
        return minimum(node.left);
    }

    /**
     * 删除以node为根的二分搜索树的最小节点
     * 返回新的二分搜索树的根
     *
     * @param node 旧根
     * @return 新根
     */
    private Node removeMin(Node node) {
        if (null == node.left) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    @Override
    public boolean contains(K key) {
        return null != getNode(key, root);
    }

    @Override
    public V get(K key) {
        Node node = getNode(key, root);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key, root);
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

    private Node getNode(K key, Node node) {
        if (null == node) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return getNode(key, node.right);
        } else if (key.compareTo(node.key) < 0) {
            return getNode(key, node.left);
        } else
            return node;
    }
}
