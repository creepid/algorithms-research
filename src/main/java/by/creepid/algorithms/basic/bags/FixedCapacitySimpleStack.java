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
public class FixedCapacitySimpleStack<Item> implements Stack<Item>{

    protected Item[] arr;
    protected int n;

    public FixedCapacitySimpleStack(int capacity) {
        this.arr = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return (n == 0);
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        arr[n++] = item;
    }

    public Item pop() {
        return arr[--n];
    }
    
    public boolean isFull(){
        return (arr.length == n);
    }
    
}
