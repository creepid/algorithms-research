/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.symboltable;

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

    /**
     * Test of delete method, of class BinarySearchSymbolTable.
     */
    @Test
    public void testDelete() {
        Integer val = st.get("9");
        assertNotNull(val);

        st.delete("9");

        assertNull(st.get("9"));

        st.put("9", 5);
    }

    @Test
    public void testFloorAndCeiling() {
        BinarySearchSymbolTable<Integer, String> sbst = new BinarySearchSymbolTable<Integer, String>(10);
        sbst.put(3, "d");
        sbst.put(7, "d");
        sbst.put(9, "d");
        sbst.put(10, "d");
        sbst.put(15, "d");

        int x = 2;
        assertEquals(null, sbst.floor(x));
        assertEquals(3, (int) sbst.ceiling(x));

        x = 3;
        assertEquals(3, (int) sbst.floor(x));
        assertEquals(3, (int) sbst.ceiling(x));

        x = 4;
        assertEquals(3, (int) sbst.floor(x));
        assertEquals(7, (int) sbst.ceiling(x));

        x = 16;
        assertEquals(15, (int) sbst.floor(x));
        assertEquals(null, sbst.ceiling(x));

    }

}
