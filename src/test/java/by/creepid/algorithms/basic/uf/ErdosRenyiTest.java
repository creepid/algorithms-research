/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirash
 */
public class ErdosRenyiTest {
    
    private static final int SIZE = 1000;
    
    private ErdosRenyi er;
    
    public ErdosRenyiTest() {
    }
        
    @Before
    public void setUp() {
        er = new ErdosRenyi(new UnionFindingWeighted(SIZE), SIZE);
        er.setPrinter(new StandartUFPrinter());
    }
    
    /**
     * Test of getCount method, of class ErdosRenyi.
     */
    @Test
    public void testGetCount() {
        System.out.println("**** getCount *****");
       
        assertTrue(er.getCount() > 0);
    }
}