/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.carcass;

import by.creepid.algorithms.basic.bags.BagSimple;

/**
 *
 * @author rusakovich
 */
public class EdgeWeightedGraphImpl implements EdgeWeightedGraph {

    private final int vertexes;
    private int edges;
    private final BagSimple<Edge>[] adjEdges;

    public EdgeWeightedGraphImpl(int vertexes) {
        this.vertexes = vertexes;
        this.edges = 0;
        this.adjEdges = (BagSimple<Edge>[]) new BagSimple[vertexes];

        for (int v = 0; v < this.vertexes; v++) {
            this.adjEdges[v] = new BagSimple<Edge>();
        }
    }

    @Override
    public int vertexCount() {
        return this.vertexes;
    }

    @Override
    public int edgeCount() {
        return this.edges;
    }

    @Override
    public void addEdge(Edge edge) {
        int v = edge.either(), w = edge.other(v);
        this.adjEdges[v].add(edge);
        this.adjEdges[w].add(edge);
        this.edges++;
    }

    @Override
    public Iterable<Edge> adjacent(int vertex) {
        return this.adjEdges[vertex];
    }

    @Override
    public Iterable<Edge> allEdges() {
        BagSimple<Edge> edges = new BagSimple<Edge>();

        for (int v = 0; v < this.vertexes; v++) {
            for (Edge edge : this.adjacent(v)) {
                if (edge.other(v) > v) {
                    edges.add(edge);
                }
            }
        }

        return edges;
    }

}
