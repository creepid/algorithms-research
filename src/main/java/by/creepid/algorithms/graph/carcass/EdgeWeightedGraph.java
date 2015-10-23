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
public interface EdgeWeightedGraph {

    public int vertexCount();

    public int edgeCount();

    public void addEdge(Edge edge);
    
    public Iterable<Edge> adjacent(int vertex);
    
    public Iterable<Edge> allEdges();
}
