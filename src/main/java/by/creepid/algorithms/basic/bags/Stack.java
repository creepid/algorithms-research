/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

/**
 *
 * @author rusakovich
 * 
 * Description: LIFO
 */
public interface Stack<Item> {

    public void push(Item item);

    public Item pop();

    public boolean isEmpty();

    public int size();

}
