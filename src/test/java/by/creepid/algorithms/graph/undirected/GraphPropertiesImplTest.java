/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

import by.creepid.algorithms.utils.DataInput;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author mirash
 */
public class GraphPropertiesImplTest {

    private UndirectedGraph g;

    public GraphPropertiesImplTest() {
    }

    @Before
    public void setUp() {
        String urlName = "src/test/resources/tinyG_1.txt";
        DataInput input = new DataInput(urlName);

        this.g = new UndirectedGraph(input);
    }

    @After
    public void tearDown() {
        g = null;
    }

    /**
     * Test of eccentricity method, of class GraphPropertiesImpl.
     */
    @Test
    public void testEccentricity() {
        System.out.println("**** eccentricity ****");
        int v = 2;
        GraphPropertiesImpl instance = new GraphPropertiesImpl(g);
        int expResult = 5;
        int result = instance.eccentricity(v);
        assertEquals(expResult, result);
    }

    /**
     * Test of diameter method, of class GraphPropertiesImpl.
     */
    @Test
    public void testDiameter() {
        System.out.println("**** diameter *****");
        GraphPropertiesImpl instance = new GraphPropertiesImpl(g);
        int expResult = 5;
        int result = instance.diameter();
        assertEquals(expResult, result);
    }

    /**
     * Test of radius method, of class GraphPropertiesImpl.
     */
    @Test
    public void testRadius() {
        System.out.println("**** radius ****");
        GraphPropertiesImpl instance = new GraphPropertiesImpl(g);
        int expResult = 1;
        int result = instance.radius();
        assertEquals(expResult, result);
    }

    /**
     * Test of center method, of class GraphPropertiesImpl.
     */
    @Test
    public void testCenter() {
        System.out.println("**** center ****");
        GraphPropertiesImpl instance = new GraphPropertiesImpl(g);
        int expResult = 9;
        int result = instance.center();
        assertEquals(expResult, result);
    }
}