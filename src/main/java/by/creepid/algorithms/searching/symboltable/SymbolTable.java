/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.creepid.algorithms.searching.symboltable;

/**
 *
 * @author rusakovich
 * 
 * Duplicate keys are not allowed
 */
public interface SymbolTable<Key, Value> {
    
    void put(Key key, Value val);
    
    Value get(Key key);
    
    void delete(Key key);
    
    boolean contains(Key key);
    
    boolean isEmpty();
    
    int size();
    
    Iterable<Key> keys();
    
}
