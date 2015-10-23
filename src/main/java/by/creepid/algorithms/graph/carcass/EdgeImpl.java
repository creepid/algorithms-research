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
public class EdgeImpl implements Edge {

    private final int v;
    private final int w;
    private final double weight;

    public EdgeImpl(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public int either() {
        return this.v;
    }

    @Override
    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else {
            throw new IllegalArgumentException("Unknown edge");
        }
    }

    @Override
    public int compareTo(Edge another) {
        if (this.weight() < another.weight()) {
            return -1;
        } else if (this.weight() > another.weight()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }

}
