package com.datastructure.LinkedList;

import org.junit.Test;

public class SumTest {

    private int sum(int[] arr){
        return sum(arr, 0);
    }

    // 计算arr[l...n)这个区间内所有数字的和
    private int sum(int[] arr, int l){
        if(l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
