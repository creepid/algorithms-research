/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

import by.creepid.algorithms.basic.bags.ResizedStack;

/**
 *
 * @author mirash
 */
public abstract class ShortestPathBase implements ShortestPath {

    protected DirectedEdge[] edgeTo;
    protected double[] distTo;

    @Override
    public double distTo(int v) {
        return distTo[v];
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        ResizedStack<DirectedEdge> path = new ResizedStack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }

        return path;
    }

    protected void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adjacent(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }
}
