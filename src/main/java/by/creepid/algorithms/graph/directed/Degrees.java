/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.creepid.algorithms.graph.directed;

/**
 *
 * @author rusakovich
 */
public interface Degrees {
    
    public int indegree(int v);
    
    public int outdegree(int v);
    
    public Iterable<Integer> sources();
    
    public Iterable<Integer> sinks();
    
    public boolean isMap();
    
}
