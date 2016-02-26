/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class CPMTest {

    private CPM instance;

    public CPMTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        instance = new CPM(10);

        instance.addTask(41.0, 1, 7, 9);
        instance.addTask(51.0, 2);
        instance.addTask(50.0);
        instance.addTask(36.0);
        instance.addTask(38.0);
        instance.addTask(45.0);
        instance.addTask(21.0, 3, 8);
        instance.addTask(32.0, 3, 8);
        instance.addTask(32.0, 2);
        instance.addTask(29.0, 4, 6);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getStartMoments method, of class CPM.
     */
    @Test
    public void testGetStartMoments() {
        System.out.println("**** getStartMoments *****");
        double[] expResult = {0.0, 41.0, 123.0, 91.0, 70.0, 0.0, 70.0, 41.0, 91.0, 41.0};
        double[] result = instance.getStartMoments();
        assertArrayEquals(expResult, result, 0.1);
    }

    /**
     * Test of getFinishMoment method, of class CPM.
     */
    @Test
    public void testGetFinishMoment() {
        System.out.println("**** getFinishMoment ****");
        double expResult = 173.0;
        double result = instance.getFinishMoment();
        assertEquals(expResult, result, 0.1);
    }

}
