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
 * @param <Item>
 *
 * Adventages: 1. Every operation has execution time, don't depend on collection
 * size 2. Memory consumption ~ collection size
 *
 * Lacks: 1. Some pop and push operation may require array capacity change 2.
 * Execution of array capacity changing ~ collection size
 */
public class ResizedStack<Item> extends FixedCapacitySimpleStack<Item> implements Iterable<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    public ResizedStack() {
        super(DEFAULT_CAPACITY);
    }

    private void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];
        for (int i = 0; i < n; i++) {
            temp[i] = this.arr[i];
        }
        this.arr = temp;
    }

    @Override
    public void push(Item item) {
        int actualLen = this.arr.length;

        if (n == actualLen) {
            resize(2 * actualLen);
        }

        super.push(item);
    }

    @Override
    public Item pop() {
        Item item = super.pop();
        this.arr[n] = null;//clean dangling pointer (висячая ссылка), gc don't know anout this unused object

        if (n > 0 && (n == this.arr.length / 4)) {
            resize(this.arr.length / 2);
        }

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<Item> {

        private int current = n;

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public Item next() {
            return arr[--current];
        }

        @Override
        public void remove() {
        }
    }
}
