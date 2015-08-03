/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.searching.symboltable;

import java.util.Iterator;

/**
 *
 * @author rusakovich
 */
public class LinkedListSymbolTable<Key, Value> extends BaseSymbolTable<Key, Value> {

    private Node first;
    private int size = 0;

    private class Node {

        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void delete(Key key) {
        Node prev = null;
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.key = null;
                if (prev != null) {
                    prev.next = x.next;
                }
                size--;
                return;
            }
            prev = x;
        }
    }

    @Override
    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        //add first
        first = new Node(key, value, first);
        size++;
    }

    @Override
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                //success
                return x.value;
            }
        }
        //failture
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        return new Iterable<Key>() {

            @Override
            public Iterator<Key> iterator() {
                return new LinkedListSTIterator();
            }
        };
    }

    private class LinkedListSTIterator implements Iterator<Key> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public Key next() {
            Node ret = current;
            current = ret.next;
            return ret.key;
        }

        @Override
        public void remove() {
        }

    }

}
