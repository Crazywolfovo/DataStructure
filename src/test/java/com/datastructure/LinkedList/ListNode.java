package com.datastructure.LinkedList;

//Definition for singly-linked list.
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (null == arr || 0 == arr.length)
            throw new IllegalArgumentException("Array cannot be empty");
        this.val = arr[0];
        ListNode current = this;
        for (int i = 0; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode current = this;
        while (null != current) {
            str.append(current.val).append(" -> ");
            current = current.next;
        }
        str.append("null");
        return str.toString();
    }
}