/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.priority;

/**
 *
 * @author rusakovich
 * @param <Key> - key parameter
 */
public interface PriorityQueue<Key extends Comparable<Key>> {

    public void insert(Key key);

    public Key max();

    public Key deleteMax();

    public boolean isEmpty();

    public int size();
    
    public Key[] getSorted();
}
