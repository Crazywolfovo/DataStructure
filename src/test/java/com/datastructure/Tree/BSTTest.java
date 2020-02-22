package com.datastructure.Tree;

import org.junit.Test;

public class BSTTest {
    @Test
    public void testBst() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();

        System.out.println();
        System.out.println(bst);
    }
}
