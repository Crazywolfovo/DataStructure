package com.datastructure.Queue;

import org.junit.Test;

import java.util.Random;

public class QueueTest {

    private void doTest(Queue<Integer> queue) {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    @Test
    public void testArrayQueue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        doTest(queue);
    }

    @Test
    public void testLoopQueue() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        doTest(queue);
    }

    @Test
    public void testLinkedListQueue() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        doTest(queue);
    }

    private double doTestTime(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0;
    }

    @Test
    public void testTime() {
        int opCount = 10_0000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double arrayQueueTime = doTestTime(arrayQueue, opCount);
        System.out.println("ArrayQueue time = " + arrayQueueTime + "s");
        double loopQueueTime = doTestTime(loopQueue, opCount);
        System.out.println("LoopQueue time = " + loopQueueTime + "s");
        double linkedListQueueTime = doTestTime(linkedListQueue, opCount);
        System.out.println("LinkedListQueue time = " + linkedListQueueTime + "s");
    }

}
