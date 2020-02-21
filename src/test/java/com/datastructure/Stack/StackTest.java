package com.datastructure.Stack;

import org.junit.Test;

import java.util.Random;

public class StackTest {

    @Test
    public void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

    }

    @Test
    public void testLinkedListStack() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

    }

    private double doTestTime(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0;
    }

    @Test
    public void testTime() {
        int opCount = 10_0000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double arrayStackTime = doTestTime(arrayStack, opCount);
        System.out.println("ArrayStack time = " + arrayStackTime + "s");
        double linkedListStackTime = doTestTime(linkedListStack, opCount);
        System.out.println("LinkedListStack time = " + linkedListStackTime + "s");
    }
}
