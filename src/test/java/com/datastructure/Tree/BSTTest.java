package com.datastructure.Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

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

        bst.levelOrder();

        System.out.println();

        bst.preOrder();

        System.out.println();

        bst.preOrderNR();

        System.out.println();
        /* System.out.println(bst);*/

        bst.inOrder();

        System.out.println();

        bst.postOrder();

        bst.remove(8);
    }

    @Test
    public void testBstRemoveMin() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int n = 1000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10_000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }
        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("Error ~ ");
            }
        }
        System.out.println("RemoveMin test completed");
    }

    @Test
    public void testBstRemoveMax() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int n = 1000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10_000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }
        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                throw new IllegalArgumentException("Error ~ ");
            }
        }
        System.out.println("RemoveMax test completed");
    }
}
