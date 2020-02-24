package com.datastructure.Tree;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeTest {
    @Test
    public void test() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segTree);
        Assert.assertEquals(Integer.valueOf(1), segTree.query(0, 2));
        Assert.assertEquals(Integer.valueOf(-1), segTree.query(2, 5));
        Assert.assertEquals(Integer.valueOf(-3), segTree.query(0, 5));
    }
}
