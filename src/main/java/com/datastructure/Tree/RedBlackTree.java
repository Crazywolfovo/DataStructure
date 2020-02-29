package com.datastructure.Tree;

public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;
    private int size;

    public RedBlackTree() {
        this.root = null;
        this.size = 0;
    }

    // 判断节点node的颜色
    private boolean isRed(Node node) {
        if (node == null)
            return BLACK;
        return node.color;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //颜色翻转
    private void flipColor(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void add(K key, V value) {
        root = add(key, value, root);
        root.color = BLACK;
    }

    /**
     * 向以node为根的红黑树中插入元素
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

        if (isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);
        if (isRed(node.left) && isRed(node.right))
            flipColor(node);
        return node;
    }


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


    public boolean contains(K key) {
        return null != getNode(key, root);
    }


    public V get(K key) {
        Node node = getNode(key, root);
        return null == node ? null : node.value;
    }


    public void set(K key, V newValue) {
        Node node = getNode(key, root);
        if (null == node)
            throw new IllegalArgumentException(key + "is not existed ~ !");
        node.value = newValue;
    }


    public int getSize() {
        return size;
    }

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
