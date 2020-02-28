package com.datastructure.Set;

import org.junit.Test;

import java.util.ArrayList;

public class SetTest {

    private double testSet(Set<String> set, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    private void doTest(Set<String> set1, Set<String> set2) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }

    @Test
    public void testBstSet() {
        BstSet<String> set1 = new BstSet<>();
        BstSet<String> set2 = new BstSet<>();
        doTest(set1, set2);
    }

    @Test
    public void testLinkedListSet() {
        LinkedListSet<String> set1 = new LinkedListSet<>();
        LinkedListSet<String> set2 = new LinkedListSet<>();
        doTest(set1, set2);
    }

    @Test
    public void testTime() {

        String filename = "pride-and-prejudice.txt";

        BstSet<String> bstSet = new BstSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");

        System.out.println();

        AVLTreeSet<String> avlTreeSet = new AVLTreeSet<>();
        double time3 = testSet(avlTreeSet, filename);
        System.out.println("AVL Tree Set: " + time3 + " s");

    }
}

