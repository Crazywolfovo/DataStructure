package com.datastructure.LinkedList;

//Definition for singly-linked list.
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] arr) {
        if (null == arr || 0 == arr.length)
            throw new IllegalArgumentException("Array cannot be empty");
        this.val = arr[0];
        ListNode current = this;
        for (int anArr : arr) {
            current.next = new ListNode(anArr);
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