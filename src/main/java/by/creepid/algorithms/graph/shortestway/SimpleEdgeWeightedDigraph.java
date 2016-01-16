/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

import by.creepid.algorithms.basic.bags.BagSimple;
import by.creepid.algorithms.utils.DataInput;

/**
 *
 * @author rusakovich
 */
public class SimpleEdgeWeightedDigraph implements EdgeWeightedDigraph {

    //vertices count
    private final int v;
    //edges count
    private int e;
    //adjacency lists
    private BagSimple<DirectedEdge>[] adj;

    public SimpleEdgeWeightedDigraph(int v) {
        this.v = v;
        this.e = 0;
        this.adj = (BagSimple<DirectedEdge>[]) new BagSimple[v];
        for (int currV = 0; currV < this.v; currV++) {
            this.adj[currV] = new BagSimple<DirectedEdge>();
        }
    }

    public SimpleEdgeWeightedDigraph(DataInput in) {
        this(in.readInt());
        int edges = in.readInt();

        for (int i = 0; i < edges; i++) {
            int from = in.readInt();
            int to = in.readInt();
            double weight = in.readDouble();

            DirectedEdge edge = new StandardDirectedEdge(from, to, weight);
            addEdge(edge);
        }

    }

    @Override
    public int vertices() {
        return v;
    }

    @Override
    public int edgeCount() {
        return e;
    }

    @Override
    public void addEdge(DirectedEdge e) {
        this.adj[e.from()].add(e);
        this.e++;
    }

    @Override
    public Iterable<DirectedEdge> adjacent(int vertex) {
        return this.adj[vertex];
    }

    @Override
    public Iterable<DirectedEdge> edges() {
        BagSimple<DirectedEdge> bag = new BagSimple<DirectedEdge>();
        for (int currV = 0; currV < v; currV++) {
            for (DirectedEdge edge : adj[currV]) {
                bag.add(edge);
            }
        }
        return bag;
    }

}
