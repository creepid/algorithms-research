/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

import by.creepid.algorithms.utils.DataInput;
import java.util.Iterator;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author rusakovich
 */
public class AcyclicShortestPathTest {

    private SimpleEdgeWeightedDigraph g;

    @Before
    public void setUp() {
        String urlName = "http://algs4.cs.princeton.edu/44sp/tinyEWDAG.txt";
        DataInput input = new DataInput(urlName);

        this.g = new SimpleEdgeWeightedDigraph(input);
    }

    @After
    public void tearDown() {
        g = null;
    }

    /**
     * Test GraphWeightedAdapter.
     */
    @Test
    public void testAdapter() {
        AcyclicShortestPath asp = new AcyclicShortestPath(g, 5);
        assertTrue(asp.hasPathTo(6));

        Iterator<DirectedEdge> edges = asp.pathTo(6).iterator();

        DirectedEdge edge = edges.next();
        assertEquals(5, edge.from());
        assertEquals(1, edge.to());

        edge = edges.next();
        assertEquals(1, edge.from());
        assertEquals(3, edge.to());

        edge = edges.next();
        assertEquals(3, edge.from());
        assertEquals(6, edge.to());
        
        edges = asp.pathTo(7).iterator();
        edge = edges.next();
        assertEquals(5, edge.from());
        assertEquals(7, edge.to());        
    }

}
