/*
 * To change this template, choose Tools | Templates
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
 * @author mirash
 */
public class DijktrasShortestPathTest {

    public DijktrasShortestPathTest() {
    }
    private SimpleEdgeWeightedDigraph g;

    @Before
    public void setUp() {
        String urlName = "src/test/resources/tinyEWD.txt";
        DataInput input = new DataInput(urlName);

        this.g = new SimpleEdgeWeightedDigraph(input);
    }

    @After
    public void tearDown() {
        g = null;
    }

    @Test
    public void testDistTo() {
        System.out.println("***** distTo *****");
        DijktrasShortestPath sp = new DijktrasShortestPath(g, 0);
        double actual = sp.distTo(7);
        double expected = 0.60;
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testHasPathTo() {
        System.out.println("***** hasPathTo *****");
        DijktrasShortestPath sp = new DijktrasShortestPath(g, 0);
        boolean actual = sp.hasPathTo(1);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void testPathTo() {
        System.out.println("***** pathTo *****");
        DijktrasShortestPath sp = new DijktrasShortestPath(g, 0);
        Iterator<DirectedEdge> pathIterator  = sp.pathTo(3).iterator();
        
        assertEquals("0->2 0,26", pathIterator.next().toString());
        assertEquals("2->7 0,34", pathIterator.next().toString());
        assertEquals("7->3 0,39", pathIterator.next().toString());
    }
}