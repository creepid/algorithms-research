/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.symboltable;

/**
 *
 * @author rusakovich
 */
public class SymbolTableUsage {

    private SymbolTableUsage() {
    }
    
    public static <Key> void fillTable(Key[] keys, SymbolTable<Key, Integer> st){
        for (int i = 0; i < keys.length; i++) {
            Key key = keys[i];
            st.put(key, i);
        }
    }    
    
    public static <Key> void fillFrequencyCounterTable(Key[] keys, int minlen, SymbolTable<Key, Integer> st){
        for (int i = 0; i < keys.length; i++) {
            Key key = keys[i];
            if (keys.length < minlen) continue;
            
            if (!st.contains(key)) st.put(key, 1);
            else st.put(key, st.get(key) + 1);
        }
    }
    
    public static <Key> int getMaxCountKey(SymbolTable<Key, Integer> st, Key maxDefault){
        Key max = maxDefault;
        st.put(max, 0);
        
        for (Key key : st.keys()) {
            if (st.get(key) > st.get(max)){
                max = key;
            }
        }
        
        return st.get(max);
    }

}
