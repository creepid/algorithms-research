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
public class CachedLinkedListSymbolTable<Key, Value> extends LinkedListSymbolTable<Key, Value> {

    private Node lastUsed = first;

    @Override
    public synchronized void put(Key key, Value value) {
        if (lastUsed != null && key.equals(lastUsed.key)) {
            lastUsed.value = value;
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                lastUsed = x;
                x.value = value;
                return;
            }
        }
        //add first
        first = new Node(key, value, first);
        lastUsed = first;
        size++;
    }

    @Override
    public synchronized Value get(Key key) {
        if (lastUsed != null && key.equals(lastUsed.key)) {
            return lastUsed.value;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                //success
                lastUsed = x;
                return x.value;
            }
        }
        //failture
        return null;
    }
    
}
