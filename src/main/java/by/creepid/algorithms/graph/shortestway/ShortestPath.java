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
public interface ShortestPath {

    /**
     * Distance from current vertex to v
     *
     * @param v - destination vertex
     * @return distance length
     */
    public double distTo(int v);

    /**
     * Defines if the path exists in general
     *
     * @param v - destination vertex
     * @return path existence result
     */
    public boolean hasPathTo(int v);

    /**
     * Returns path to destination vertex
     *
     * @param v - destination vertex
     * @return path to destination vertex
     */
    public Iterable<DirectedEdge> pathTo(int v);

}
