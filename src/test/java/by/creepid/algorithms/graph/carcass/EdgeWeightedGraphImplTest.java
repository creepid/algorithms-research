/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.carcass;

import by.creepid.algorithms.utils.DataInput;
import java.util.Iterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class EdgeWeightedGraphImplTest {

    public EdgeWeightedGraphImplTest() {
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
     * Test of vertexCount method, of class EdgeWeightedGraphImpl.
     */
    @Test
    public void testVertexCount() {
        System.out.println("*** vertexCount ****");
        int expResult = 8;
        int result = g.vertexCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of edgeCount method, of class EdgeWeightedGraphImpl.
     */
    @Test
    public void testEdgeCount() {
        System.out.println("**** edgeCount ****");
        int expResult = 16;
        int result = g.edgeCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of addEdge method, of class EdgeWeightedGraphImpl.
     */
    @Test
    public void testAddEdge() {
        System.out.println("*** addEdge ***");
        Edge edge = new EdgeImpl(6, 5, 0.45);
        g.addEdge(edge);
    }

    /**
     * Test of allEdges method, of class EdgeWeightedGraphImpl.
     */
    @Test
    public void testAllEdges() {
        System.out.println("**** allEdges ****");
        Iterator<Edge> result = g.allEdges().iterator();

        int edgesCount = 0;
        while (result.hasNext()) {
            result.next();
            edgesCount++;
        }
        assertEquals(16, edgesCount);
    }

}
