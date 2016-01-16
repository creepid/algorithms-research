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
public interface EdgeWeightedDigraph {

    public int vertexes();

    public int edgeCount();

    public void addEdge(DirectedEdge e);

    public Iterable<DirectedEdge> adjacent(int vertex);

    public Iterable<DirectedEdge> edges();

}
