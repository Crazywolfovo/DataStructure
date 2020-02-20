package com.datastructure.Arrays;

import org.junit.Test;

public class ArrayTest {
    @Test
    public void test() {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        arr.removeElement(100);
        System.out.println(arr);

        arr.remove(5);
        System.out.println(arr);
    }

    @Test
    public void testByStudent() {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 66));
        arr.addLast(new Student("Charlie", 88));
        System.out.println(arr);
        arr.removeElement(new Student("Bob", 66));
        System.out.println(arr);
    }
}
