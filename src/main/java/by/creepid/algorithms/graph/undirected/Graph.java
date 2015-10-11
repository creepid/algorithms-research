/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

/**
 *
 * @author rusakovich
 */
public interface Graph {

    public int vertexCount();

    public Iterable<Integer> vertices();

    public int edgeCount();

    public void addEdge(int v, int w);

    public Iterable<Integer> adjacentVertices(int v);
    
}
