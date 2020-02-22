package com.datastructure.Tree;

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 树的根节点
     */
    private Node root;

    /**
     * 树已存储的数据量
     */
    private int size;

    /**
     * 构造函数
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 获取树已存储的数据量
     *
     * @return 数据量
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断树是否为空
     *
     * @return boolean
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素
     * 并且维护类私有变量root的值
     * 如果root一开始为空，则第一个插入的元素为跟节点
     *
     * @param e 元素
     */
    public void add(E e) {

        root = add(e, root);
    }

    /**
     * 向以node为根的二分搜索树中插入元素
     * 递归算法Recursion
     *
     * @param e    元素
     * @param node 根节点
     * @return 根节点
     */
    private Node add(E e, Node node) {

        // 递归结束条件
        if (null == node) {
            size++;
            return new Node(e);
        }

        // 递归触发条件
        if (e.compareTo(node.e) < 0)
            node.left = add(e, node.left);
        else if (e.compareTo(node.e) > 0)
            node.right = add(e, node.right);

        return node;
    }

    /**
     * 查看以node为根的树中是否包含元素e
     *
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e) {
        return contains(e, root);
    }

    /**
     * 查看以node为根的树中是否包含元素e
     *
     * @param e    元素
     * @param node 根节点
     * @return boolean
     */
    private boolean contains(E e, Node node) {

        //递归结束条件
        if (null == node)
            return false;

        //递归触发条件
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(e, node.left);
        else
            return contains(e, node.right);
    }

    /**
     * 树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 已node为根节点的树的前序遍历
     *
     * @param node 根节点
     */
    private void preOrder(Node node) {
        if (null != node) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        generateBSTString(root, 0, str);
        return str.toString();
    }

    /**
     * 生成以node为根节点，深度为deep的树的描述字符串
     *
     * @param node  根节点
     * @param depth 深度
     * @param str   结果字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder str) {
        if (null == node) {
            str.append(generateDepthString(depth)).append("null\n");
            return;
        }
        str.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, str);
        generateBSTString(node.right, depth + 1, str);
    }

    private String generateDepthString(int depth) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < depth; i++) str.append("-");
        return str.toString();
    }
}
