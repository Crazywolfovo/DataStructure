package com.datastructure.UnionFind;

import org.junit.Test;

import java.util.Random;


public class UnionFindTest {

    private static double testUF(UnionFind uf, int m) {

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElement(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    @Test
    public void shouldAnswerWithTrue() {
        // UnionFind1 慢于 UnionFind2
        // int size = 100000;
        // int m = 10000;

        // UnionFind2 慢于 UnionFind1, 但UnionFind3最快
        int size = 10000000;
        int m = 10000000;

       /* UnionFindI uf1 = new UnionFindI(size);
        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");

        UnionFindII uf2 = new UnionFindII(size);
        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");

        UnionFindIII uf3 = new UnionFindIII(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");

        UnionFindIV uf4 = new UnionFindIV(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");

        UnionFindIV uf5 = new UnionFindIV(size);
        System.out.println("UnionFind5 : " + testUF(uf5, m) + " s");

        UnionFindIV uf6 = new UnionFindIV(size);
        System.out.println("UnionFind6 : " + testUF(uf6, m) + " s");*/
    }
}
