/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

import java.util.Iterator;

/**
 *
 * @author rusakovich
 */
public class LinkedListQueue<Item> implements Queue<Item>, Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;

    private int n;

    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void enqueue(Item item) {
        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if (this.isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        n++;
    }

    @Override
    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (this.isEmpty()) {
            last = null;
        }

        n--;

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListQueueIterator<Item>();
    }

    private class LinkedListQueueIterator<Item> implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public Item next() {
            Node<Item> ret = current;
            current = ret.next;
            return ret.item;
        }

        @Override
        public void remove() {
        }

    }

}
