/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.creepid.algorithms.sorting.priority;

/**
 *
 * @author rusakovich
 */
public interface Indexed<Key extends Comparable<Key>> {
    
    boolean contains(int k);
    
    void insert(int k, Key key);
    
    Key min();
    
    int deleteMin();
    
}
