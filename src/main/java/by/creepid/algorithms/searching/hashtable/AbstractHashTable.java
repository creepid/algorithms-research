/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.hashtable;

/**
 *
 * @author mirash
 */
abstract class AbstractHashTable<Key, Value> implements HashTable<Key, Value> {

    //number of pairs key-value
    protected int n;
    //hash table size
    protected int m;

    protected int hash(Key key) {
        //mask sign bit (converts 32-bit number to positive 31-bit number)
        //and calc remainder (cause we want use all elements of our array)
        return (key.hashCode() & 0x7fffffff) % m;
    }
}
