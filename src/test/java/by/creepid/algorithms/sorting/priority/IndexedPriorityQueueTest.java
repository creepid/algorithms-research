/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.priority;

import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class IndexedPriorityQueueTest {

    public IndexedPriorityQueueTest() {
    }

    @Test
    public void test() {
        System.out.println("***** test *****");
        String[] m1 = {"A", "B", "C", "F", "G", "I", "I", "Z"};
        String[] m2 = {"B", "D", "H", "P", "Q", "Q"};
        String[] m3 = {"A", "B", "E", "F", "J", "N"};

        String[][] streams = new String[3][];
        streams[0] = m1;
        streams[1] = m2;
        streams[2] = m3;

        IndexedPriorityQueue<String> pq = new IndexedPriorityQueue<>(m1.length + m2.length + m3.length);

        for (int i = 0; i < streams.length; i++) {
            String[] strings = streams[i];
            for (int j = 0; j < strings.length; j++) {
                pq.insert(i, strings[j]);
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.deleteMin());
        }

    }

}
