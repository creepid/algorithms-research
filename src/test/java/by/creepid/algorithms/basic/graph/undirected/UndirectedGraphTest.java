/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.graph.undirected;

import by.creepid.algorithms.utils.DataInput;
import java.util.Iterator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class UndirectedGraphTest {

    private UndirectedGraph instance;

    public UndirectedGraphTest() {
    }

    @Before
    public void setUp() {
        String urlName = "http://algs4.cs.princeton.edu/41graph/tinyG.txt";
        DataInput input = new DataInput(urlName);

        this.instance = new UndirectedGraph(input);
    }

    @After
    public void tearDown() {
        this.instance = null;
    }

    /**
     * Test of addEdge method, of class UndirectedGraph.
     */
    @Test
    public void testAddEdge() {
        System.out.println("**** addEdge ****");
        int v = 6;
        int w = 3;
        instance.addEdge(v, w);

        Iterator<Integer> iterator = instance.adjacentVertices(v).iterator();

        int[] actual = new int[3];
        int i = 0;
        while (iterator.hasNext()) {
            int ver = iterator.next();
            actual[i++] = ver;
        }

        int[] expected = {3, 0, 4};
        Assert.assertArrayEquals(expected, actual);
    }

    /**
     * Test of adjacentVertices method, of class UndirectedGraph.
     */
    @Test
    public void testAdjacentVertices() {
        System.out.println("**** adjacentVertices ****");
        int v = 6;
        Iterator<Integer> iterator = instance.adjacentVertices(v).iterator();

        int[] actual = new int[2];
        int i = 0;
        while (iterator.hasNext()) {
            int ver = iterator.next();
            actual[i++] = ver;
        }

        int[] expected = {0, 4};
        Assert.assertArrayEquals(expected, actual);
    }

}
