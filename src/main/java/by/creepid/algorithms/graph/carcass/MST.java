/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.carcass;

/**
 *
 * @author rusakovich
 */
public interface MST {

    public Iterable<Edge> edges();

    public double weight();
    
}
