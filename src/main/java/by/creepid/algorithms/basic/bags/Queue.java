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
 * Description: FIFO
 */
public interface Queue<Item> {
    
    public boolean isEmpty();
    
    public int size();
    
    public void enqueue(Item item);
    
    public Item dequeue();
    
}
