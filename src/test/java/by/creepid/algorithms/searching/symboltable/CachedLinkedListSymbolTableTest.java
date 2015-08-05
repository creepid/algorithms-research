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
public class CachedLinkedListSymbolTableTest {

    public CachedLinkedListSymbolTableTest() {
    }

    @Test
    public void test() {
        CachedLinkedListSymbolTable<String, Integer> cllst = new CachedLinkedListSymbolTable();
        cllst.put("dfg", 4);
        cllst.put("4", 5);
        cllst.put("55", 6);
        cllst.put("g6", 4);
        cllst.put("6g", 6);

        if (cllst.contains("55")) {
            cllst.put("55", 344);
            assertEquals(344, (long) cllst.get("55"));
        }

        if (cllst.contains("55")) {
            long some = cllst.get("55") + 1;
            cllst.put("55", (int)some);
            assertEquals(345, (long) cllst.get("55"));
        }

    }

}
