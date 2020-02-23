package com.datastructure.LinkedList;/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/

class Solution4 {

    ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        ListNode res = removeElements(head.next, val);
        if (head.val == val)
            return res;
        else {
            head.next = res;
            return head;
        }
    }

}