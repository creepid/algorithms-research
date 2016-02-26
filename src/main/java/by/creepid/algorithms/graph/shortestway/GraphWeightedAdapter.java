/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

import by.creepid.algorithms.graph.directed.Digraph;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rusakovich
 */
public class GraphWeightedAdapter implements Digraph {

    private final EdgeWeightedDigraph ewd;

    public GraphWeightedAdapter(EdgeWeightedDigraph ewd) {
        this.ewd = ewd;
    }

    @Override
    public Digraph reverse() {
        //TODO reverse digraph
        return this;
    }

    @Override
    public int vertexCount() {
        return ewd.vertexes();
    }

    @Override
    public Iterable<Integer> vertices() {
        Set<Integer> vertices = new LinkedHashSet<>();
        Iterable<DirectedEdge> edges = ewd.edges();
        for (DirectedEdge edge : edges) {
            vertices.add(edge.from());
            vertices.add(edge.to());
        }
        return vertices;
    }

    @Override
    public int edgeCount() {
        return ewd.edgeCount();
    }

    @Override
    public void addEdge(int v, int w) {
        ewd.addEdge(new StandardDirectedEdge(v, w, Double.POSITIVE_INFINITY));
    }

    @Override
    public Iterable<Integer> adjacentVertices(int v) {
        Iterable<DirectedEdge> edges = ewd.adjacent(v);
        List<Integer> vertices = new ArrayList<>();
        for (DirectedEdge edge : edges) {
            vertices.add(edge.to());
        }
        return vertices;
    }

}
