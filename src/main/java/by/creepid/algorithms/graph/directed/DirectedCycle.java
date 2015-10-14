/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

import by.creepid.algorithms.graph.undirected.CycleSearch;

/**
 *
 * @author rusakovich
 */
public interface DirectedCycle extends CycleSearch {

    Iterable<Integer> cycle();

}
