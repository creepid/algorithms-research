/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.application;

import by.creepid.algorithms.searching.hashtable.LinearProbingHashTable;

/**
 *
 * @author mirash
 */
public class LeastRecentlyUsedCache<Key, Value> implements Cache<Key, Value> {

    //least recent
    Node<Key, Value> head = null;
    //most recent
    Node<Key, Value> tail = null;
    private final int capacity;
    private LinearProbingHashTable<Key, Node> ht;

    class Node<Key, Value> {

        Key key;
        Value value;
        Node next;
        Node prev;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public LeastRecentlyUsedCache(int capacity) {
        this.capacity = capacity;
        this.ht = new LinearProbingHashTable<>(capacity);
    }

    @Override
    public void set(Key key, Value value) {
        Node targetNode = null;
        if (ht.contains(key)) {

            targetNode = ht.get(key);
            targetNode.value = value;

            remove(targetNode);
            setHead(targetNode);

        } else {
            targetNode = new Node(key, value);

            if (ht.size() >= capacity) {
                ht.delete(tail.key);
                remove(tail);
            }

            setHead(targetNode);
            ht.put(key, targetNode);
        }
    }

    @Override
    public Value get(Key key) {
        if (ht.contains(key)) {
            Node node = ht.get(key);

            remove(node);
            setHead(node);

            return (Value) node.value;
        }

        return null;

    }

    private void remove(Node node) {
        if (node == null) {
            return;
        }

        Node prev = node.prev;
        if (prev != null) {
            prev.next = node.next;
        } else {
            head = node.next;
        }

        Node next = node.next;
        if (next != null) {
            next.prev = node.prev;
        } else {
            tail = node.prev;
        }

    }

    private void setHead(Node node) {
        if (node == null) {
            return;
        }

        node.next = head;
        node.prev = null;

        Node headOld = head;

        if (headOld != null) {
            headOld.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }
}
