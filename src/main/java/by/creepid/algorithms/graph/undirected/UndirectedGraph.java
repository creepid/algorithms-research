/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

import by.creepid.algorithms.basic.bags.BagSimple;
import by.creepid.algorithms.utils.DataInput;

/**
 *
 * @author rusakovich
 */
public class UndirectedGraph extends AbstractGraph {

    private BagSimple<Integer>[] adj;

    public UndirectedGraph(int vertices) {
        super(vertices);
        this.adj = (BagSimple<Integer>[]) new BagSimple[vertices];

        for (int v = 0; v < this.vertices; v++) {
            adj[v] = new BagSimple<>();
        }
    }

    public UndirectedGraph(DataInput in) {
        //read vertices
        this(in.readInt());
        int edges = in.readInt();

        for (int i = 0; i < edges; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    @Override
    public Iterable<Integer> adjacentVertices(int v) {
        return this.adj[v];
    }

}
