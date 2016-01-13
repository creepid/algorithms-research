/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

/**
 *
 * @author rusakovich
 */
public interface DirectedEdge {

    /**
     * Weight of given edge
     *
     * @return weights
     */
    public double weight();

    /**
     * Start position for given edge
     *
     * @return position
     */
    public int from();

    /**
     * Final position for given edge
     *
     * @return
     */
    public int to();

}
