/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

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
public class AcyclicLongestPathTest {

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
     * Test of relax method, of class AcyclicLongestPath.
     */
    @Test
    public void testRelax() {
        System.out.println("***** relax *****");
        AcyclicLongestPath alp = new AcyclicLongestPath(g, 5);
        assertTrue(alp.hasPathTo(6));

        Iterator<DirectedEdge> edges = alp.pathTo(7).iterator();

        DirectedEdge edge = edges.next();
        assertEquals(5, edge.from());
        assertEquals(1, edge.to());

        edge = edges.next();
        assertEquals(1, edge.from());
        assertEquals(3, edge.to());

        edge = edges.next();
        assertEquals(3, edge.from());
        assertEquals(6, edge.to());

        edge = edges.next();
        assertEquals(6, edge.from());
        assertEquals(4, edge.to());

        edge = edges.next();
        assertEquals(4, edge.from());
        assertEquals(7, edge.to());
    }

}
