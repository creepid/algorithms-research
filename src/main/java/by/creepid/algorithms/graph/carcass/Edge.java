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
public interface Edge extends Comparable<Edge> {

    /**
     * Weight of given edge
     *
     * @return weight
     */
    public double weight();

    /**
     * One of the vertexes of the edge
     *
     * @return vertex
     */
    public int either();

    /**
     * The other vertex
     *
     * @param v - vertex
     * @return vertex
     */
    public int other(int v);

}
