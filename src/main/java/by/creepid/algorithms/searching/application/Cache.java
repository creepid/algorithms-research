/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.application;

/**
 *
 * @author mirash
 */
public interface Cache<Key, Value> {

    public void set(Key key, Value value);

    public Value get(Key key);
}
