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
public class StandardDirectedEdge implements DirectedEdge {

    private final int v;
    private final int w;

    private final double weight;

    public StandardDirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public int from() {
        return this.v;
    }

    @Override
    public int to() {
        return this.w;
    }

    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }

}
