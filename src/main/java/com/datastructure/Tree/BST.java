package com.datastructure.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * 深度优先遍历：前序遍历、中续遍历、后续遍历
 * 广度优先遍历：层序遍历
 *
 * @param <E> 二分搜索树的元素
 */
public class BST<E extends Comparable<E>> {
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
     * 二分搜索树的根节点
     */
    private Node root;

    /**
     * 二分搜索树已存储的数据量
     */
    private int size;

    /**
     * 构造函数
     */
    public BST() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 获取二分搜索树已存储的数据量
     *
     * @return 数据量
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断二分搜索树是否为空
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
     * 查看二分搜索树中是否包含元素e
     *
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e) {
        return contains(e, root);
    }

    /**
     * 查看以node为根的二分搜索树中是否包含元素e
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
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 已node为根节点的二分搜索树的前序遍历
     * 根 -> 左子树 -> 右子树
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

    /**
     * 二分搜索树的非递归前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.e);
            if (null != current.right)
                stack.push(current.right);
            if (null != current.left)
                stack.push(current.left);
        }
    }

    /**
     * 二分搜索树的非递归层序遍历
     * 更快的找到要查询的元素，搜索策略
     * 用于算法设计-无权图的最短路径问题
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.e);
            if (null != current.left)
                queue.add(current.left);
            if (null != current.right)
                queue.add(current.right);
        }

    }

    /**
     * 二分搜索树的中序遍历
     * 二分搜索树元素的排序结果
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 已node为根节点的二分搜索树的中序遍历
     * 左子树 -> 根 -> 右子树
     * 用于二分搜索树内元素的排序
     *
     * @param node 根
     */
    private void inOrder(Node node) {
        if (null != node) {
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }

    }

    /**
     * 二分搜索树的后续遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 已node为根节点的二分搜索树的后序遍历
     * 左子树 -> 右子树 -> 根
     * 用于释放二分搜索树的内存
     *
     * @param node 根
     */
    private void postOrder(Node node) {
        if (null != node) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        generateBSTString(root, 0, str);
        return str.toString();
    }

    /**
     * 生成以node为根节点，深度为deep的二分搜索树的描述字符串
     * 生成以node为根节点，深度为deep的二分搜索树的描述字符串
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

    /**
     * 获取二分搜索树最小元素
     *
     * @return 最小元素
     */
    public E minimum() {
        if (0 == size)
            throw new IllegalArgumentException("BST is empty ~");
        return minimum(root).e;
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
     * 移除二分搜索树的最小值
     *
     * @return 最小值
     */
    public E removeMin() {
        E res = minimum();
        root = removeMin(root);
        return res;
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

    /**
     * 移除二分搜索树的最大值
     *
     * @return 最大值
     */
    public E removeMax() {
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    /**
     * 删除以node为根的二分搜索树的最大节点
     * 返回新的二分搜索树的根
     *
     * @param node 旧根
     * @return 新根
     */
    private Node removeMax(Node node) {
        if (null == node.right) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 获取二分搜索树最小元素
     *
     * @return 最大元素
     */
    public E maximum() {
        if (0 == size)
            throw new IllegalArgumentException("BST is empty ~");
        return maximum(root).e;
    }

    /**
     * 获取node为根节点的二分搜索树最大元素
     *
     * @return 最大元素
     */
    private Node maximum(Node node) {
        if (null == node.right)
            return node;
        return maximum(node.right);
    }

    /**
     * 删除二分搜索中的元素e
     *
     * @param e 元素
     */
    public void remove(E e) {
        root = remove(e, root);
    }

    /**
     * 删除以node为根的二分搜索中的元素e的节点
     *
     * @param e    元素
     * @param node 旧根
     * @return 新根
     */
    private Node remove(E e, Node node) {
        if (null == node) {
            return null;
        } else if (e.compareTo(node.e) < 0) {
            node.left = remove(e, node.left);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(e, node.right);
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
}
