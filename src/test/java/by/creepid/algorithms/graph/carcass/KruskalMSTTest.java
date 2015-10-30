/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.carcass;

import by.creepid.algorithms.utils.DataInput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class KruskalMSTTest {

    public KruskalMSTTest() {
    }

    private EdgeWeightedGraph g;

    @Before
    public void setUp() {
        String urlName = "http://algs4.cs.princeton.edu/43mst/tinyEWG.txt";
        DataInput input = new DataInput(urlName);

        this.g = new EdgeWeightedGraphImpl(input);
    }

    @After
    public void tearDown() {
        g = null;
    }

    /**
     * Test of edges method, of class LazyPrimMST.
     */
    @Test
    public void testEdges() {
        System.out.println("**** edges ****");
        KruskalMST instance = new KruskalMST(g);
        Iterator<Edge> result = instance.edges().iterator();

        String[] expected = new String[7];
        expected[0] = "0-7 0,16";
        expected[1] = "2-3 0,17";
        expected[2] = "1-7 0,19";
        expected[3] = "0-2 0,26";
        expected[4] = "5-7 0,28";
        expected[5] = "4-5 0,35";
        expected[6] = "6-2 0,40";

        List<String> actualList = new ArrayList<>();

        while (result.hasNext()) {
            actualList.add(result.next().toString());
        }

        assertArrayEquals(expected, actualList.toArray());
    }

    /**
     * Test of weight method, of class EagerPrimMST.
     */
    @Test
    public void testWeight() {
        System.out.println("***** weight *****");
        KruskalMST instance = new KruskalMST(g);
        double expResult = 1.81;
        double result = instance.weight();
        assertEquals(expResult, result, 0.00001);
    }

}
