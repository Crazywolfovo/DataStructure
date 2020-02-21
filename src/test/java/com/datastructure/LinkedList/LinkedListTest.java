package com.datastructure.LinkedList;

import org.junit.Test;

public class LinkedListTest {

    @Test
    public void test() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(666, 2);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

    @Test
    public void testSolutuion() {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        ListNode head2 = new ListNode(nums);
        ListNode head3 = new ListNode(nums);

        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head,1);
        System.out.println(res);
        ListNode res2 = (new Solution2()).removeElements(head2,1);
        System.out.println(res2);
        ListNode res3 = (new Solution3()).removeElements(head3,1);
        System.out.println(res3);

    }
}
