package com.datastructure.Queue;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class QueueTest {
    private String doTest(Queue<Integer> queue) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            str.append(queue.toString());
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
                str.append(queue.toString());
            }
        }
        return str.toString();
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
    public void testQueal() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        assertEquals(doTest(arrayQueue), doTest(loopQueue));
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
        double arrayQueueTime = doTestTime(arrayQueue, opCount);
        System.out.println("ArrayQueue time = " + arrayQueueTime + "s");
        double loopQueueTime = doTestTime(loopQueue, opCount);
        System.out.println("LoopQueue time = " + loopQueueTime + "s");
    }

}
