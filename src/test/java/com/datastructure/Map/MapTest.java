package com.datastructure.Map;

import com.datastructure.Set.FileOperation;
import com.datastructure.Tree.AVLTree;
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

            if (map instanceof AVLTree) {
                System.out.println("is BST ? " + ((AVLTree<String, Integer>) map).isBST());
                System.out.println("is Balance ? " + ((AVLTree<String, Integer>) map).isBalanced());
            }

            for (String word : words) {
                map.remove(word);
               /* if (map instanceof AVLTree
                        && (!((AVLTree<String, Integer>) map).isBST() || !((AVLTree<String, Integer>) map).isBalanced())) {
                    throw new RuntimeException("Error ~");
                }*/
            }

        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void testTime() {
        String filename = "pride-and-prejudice.txt";

        BstMap<String, Integer> bstMap = new BstMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

         /*System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");*/

        System.out.println();

        AVLTreeMap<String, Integer> avlTreeMap = new AVLTreeMap<>();
        double time3 = testMap(avlTreeMap, filename);
        System.out.println("AVL Tree Map: " + time3 + " s");
    }
}
