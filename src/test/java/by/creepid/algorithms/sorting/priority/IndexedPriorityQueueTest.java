/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
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

        List<String> m1al = new ArrayList<String>(Arrays.asList(m1));
        List<String> m2al = new ArrayList<String>(Arrays.asList(m2));
        List<String> m3al = new ArrayList<String>(Arrays.asList(m3));

        Iterator<String>[] iterators = new Iterator[3];
        iterators[0] = m1al.iterator();
        iterators[1] = m2al.iterator();
        iterators[2] = m3al.iterator();

        IndexedPriorityQueue<String> pq = new IndexedPriorityQueue<>(iterators.length);

        for (int i = 0; i < iterators.length; i++) {
            pq.insert(i, iterators[i].next());
        }

        List<String> actualList = new ArrayList<>();
        while (!pq.isEmpty()) {
            actualList.add(pq.min());
            int i = pq.deleteMin();
            if (iterators[i].hasNext()) {
                pq.insert(i, iterators[i].next());
            }
        }

        String[] expected = {"A", "A", "B", "B", "B", "C", "D", "E", "F", "F", "G", "H", "I", "I", "J", "N", "P", "Q", "Q", "Z"};
        String[] actual = actualList.toArray(new String[actualList.size()]);

        assertArrayEquals(expected, actual);

    }

}
