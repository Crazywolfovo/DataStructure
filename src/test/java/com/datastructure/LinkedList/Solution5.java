package com.datastructure.LinkedList;/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/

class Solution5 {

    ListNode removeElements(ListNode head, int val) {

        if(head == null)
            return null;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

}