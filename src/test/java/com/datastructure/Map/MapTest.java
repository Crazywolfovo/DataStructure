package com.datastructure.Map;

import com.datastructure.Set.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

public class MapTest {

    private static double testMap(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void testTime() {
        String filename = "pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");
        System.out.println(bstMap);

         /*System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");

        System.out.println();

        AVLTreeMap<String, Integer> avlTreeMap = new AVLTreeMap<>();
        double time3 = testMap(avlTreeMap, filename);
        System.out.println("AVL Tree Map: " + time3 + " s");

        System.out.println();

        RedBlackTreeMap<String, Integer> redBlackTreeMap = new RedBlackTreeMap<>();
        double time4 = testMap(redBlackTreeMap, filename);
        System.out.println("RedBlack Tree Map: " + time4 + " s");*/

        System.out.println();

        HashMap<String, Integer> hashMap = new HashMap<>();
        double time5 = testMap(hashMap, filename);
        System.out.println("Hash Map: " + time5 + " s");
    }
}
