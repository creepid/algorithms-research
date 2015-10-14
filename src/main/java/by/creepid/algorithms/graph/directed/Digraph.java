/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

import by.creepid.algorithms.graph.undirected.Graph;

/**
 *
 * @author rusakovich
 */
public interface Digraph extends Graph {

    public Digraph reverse();

}
