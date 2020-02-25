package com.datastructure.Tree;

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
}

