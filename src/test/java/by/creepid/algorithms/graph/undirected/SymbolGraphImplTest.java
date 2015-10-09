/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class SymbolGraphImplTest {

    private SymbolGraphImpl g;

    public SymbolGraphImplTest() {
    }

    @Before
    public void setUp() {
        String urlName = "src/test/resources/movies-small.txt";
        this.g = new SymbolGraphImpl(urlName, "/");
    }

    @After
    public void tearDown() {
        g = null;
    }

    /**
     * Test of contains method, of class SymbolGraphImpl.
     */
    @Test
    public void test() {
        System.out.println("**** test ****");
        String key = "Zombie, Rob";
        for (int w : g.adjacentVertices(g.index(key))) {
            assertEquals("Airheads (1994)", g.name(w));
        }
    }

}
