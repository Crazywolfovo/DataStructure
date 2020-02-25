package com.datastructure.Tree;

import java.util.Stack;
import java.util.TreeMap;

public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 向trie中添加一个新的单词
     *
     * @param string 单词
     */
    public void add(String string) {
        Node current = root;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (null == current.next.get(c))
                current.next.put(c, new Node());
            current = current.next.get(c);
        }
        if (!current.isWord) {
            current.isWord = true;
            size++;
        }
    }

    public boolean contains(String string) {
        Node current = root;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (null == current.next.get(c)) return false;
            current = current.next.get(c);
        }
        return current.isWord;
    }

    /**
     * 是否有单词以prefix为前缀
     *
     * @param prefix 前缀
     * @return boolean
     */
    public boolean isPrefix(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (null == current.next.get(c)) return false;
            current = current.next.get(c);
        }
        return true;
    }

    /**
     * 删除word, 返回是否删除成功
     *
     * @param word 要删除测单词
     * @return 是否删除成功
     */
    public boolean remove(String word) {

        // 将搜索沿路的节点放入栈中
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        for (int i = 0; i < word.length(); i++) {
            if (!stack.peek().next.containsKey(word.charAt(i)))
                return false;
            stack.push(stack.peek().next.get(word.charAt(i)));
        }

        if (!stack.peek().isWord)
            return false;

        // 将该单词结尾isWord置空
        stack.peek().isWord = false;
        size--;

        // 如果单词最后一个字母的节点的next非空，
        // 说明trie中还存储了其他以该单词为前缀的单词，直接返回
        if (stack.peek().next.size() > 0)
            return true;
        else
            stack.pop();

        // 自底向上删除
        for (int i = word.length() - 1; i >= 0; i--) {
            stack.peek().next.remove(word.charAt(i));
            // 如果一个节点的isWord为true，或者是其他单词的前缀，则直接返回
            if (stack.peek().isWord || stack.peek().next.size() > 0)
                return true;
        }
        return true;
    }
}

