/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.searching.symboltable;

import java.util.Iterator;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author rusakovich
 */
public class LinkedListSymbolTableTest {

    private LinkedListSymbolTable<String, Integer> st = new LinkedListSymbolTable();

    public LinkedListSymbolTableTest() {
    }

    @Before
    public void beforeMethod() {
        st.put("S", 0);
        st.put("E", 1);
        st.put("A", 2);
        st.put("R", 3);
        st.put("C", 4);
        st.put("H", 5);
        st.put("E", 6);
        st.put("X", 7);
        st.put("A", 8);
        st.put("M", 9);
        st.put("P", 10);
        st.put("L", 11);
        st.put("E", 12);
    }

    @After
    public void afterMethod() {
        st.delete("S");
        st.delete("E");
        st.delete("A");
        st.delete("R");
        st.delete("C");
        st.delete("H");
        st.delete("E");
        st.delete("X");
        st.delete("A");
        st.delete("M");
        st.delete("P");
        st.delete("L");
        st.delete("E");
    }

    /**
     * Test of put method, of class LinkedListSymbolTable.
     */
    @Test
    public void testPut() {
        st.put("E", 13);
        long ret = st.get("E");
        assertEquals(13, ret);
    }

    /**
     * Test of get method, of class LinkedListSymbolTable.
     */
    @Test
    public void testGet() {
        long ret = st.get("E");
        assertEquals(12, ret);
    }

    /**
     * Test of size method, of class LinkedListSymbolTable.
     */
    @Test
    public void testSize() {
        assertEquals(10, st.size());
    }

    /**
     * Test of keys method, of class LinkedListSymbolTable.
     */
    @Test
    public void testKeys() {
        Iterable<String> keys = st.keys();
        assertNotNull(keys);

        Iterator<String> iterator = keys.iterator();
        assertNotNull(iterator);
        
        int actual = 0;
        while(iterator.hasNext()){
            assertNotNull(iterator.next());
            actual++;
        }
        assertEquals(10, actual);
    }

    /**
     * Test of delete method, of class LinkedListSymbolTable.
     */
    @Test
    public void testDelete() {
        st.delete("E");
        assertEquals(9, st.size());

        st.delete("T");
        assertEquals(9, st.size());
        
    }

}
