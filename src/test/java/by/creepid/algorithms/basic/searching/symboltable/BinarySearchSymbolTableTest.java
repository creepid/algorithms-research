/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.searching.symboltable;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class BinarySearchSymbolTableTest {

    private BinarySearchSymbolTable<String, Integer> st = new BinarySearchSymbolTable<String, Integer>(10);

    public BinarySearchSymbolTableTest() {
        st.put("12", 3);
        st.put("dfg", 4);
        st.put("dg", 334);
        st.put("9", 5);
        st.put("54", 8);
    }

    /**
     * Test of put method, of class BinarySearchSymbolTable.
     */
    @Test
    public void testPut() {
        st.put("nn", 17);

        long expected = 17;
        assertEquals(expected, (long) st.get("nn"));
    }

    /**
     * Test of get method, of class BinarySearchSymbolTable.
     */
    @Test
    public void testGet() {
        long expected = 3;
        assertEquals(expected, (long) st.get("12"));
    }

}
