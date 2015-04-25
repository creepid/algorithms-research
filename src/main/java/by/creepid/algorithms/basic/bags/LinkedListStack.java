/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

/**
 *
 * @author rusakovich
 */
public class LinkedListStack<Item> implements Stack<Item> {

    private Node<Item> first;
    private int n;

    @Override
    public void push(Item item) {
        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;

        n++;
    }

    @Override
    public Item pop() {
        Item item = first.item;
        first = first.next;

        n--;

        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return n;
    }

    public Item max() {
        if (this.isEmpty()) {
            return null;
        }

        Comparable max = (Comparable) first.item;
        for (Node<Item> curr = first.next; curr != null; curr = curr.next) {
            Comparable currItem = (Comparable) curr.item;

            if (currItem.compareTo(max) > 0) {
                max = currItem;
            }

        }

        return (Item) max;
    }

}
