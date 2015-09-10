/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.hashtable;

/**
 *
 * @author mirash
 */
public interface HashTable<Key, Value> {

    public Value get(Key key);

    public void put(Key key, Value value);
    
    public void delete(Key key);
}
