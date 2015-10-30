/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.carcass;

import by.creepid.algorithms.basic.bags.LinkedListQueue;
import by.creepid.algorithms.sorting.priority.MinPriorityQueue;

/**
 *
 * @author rusakovich
 */
public class LazyPrimMST implements MST {

    private boolean[] marked;
    private double weight;
    private LinkedListQueue<Edge> mst;
    private MinPriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph g) {
        this.pq = new MinPriorityQueue<>(g.vertexCount());
        this.marked = new boolean[g.vertexCount()];
        this.mst = new LinkedListQueue<>();

        visit(g, 0);

        while (!pq.isEmpty()) {
            Edge minWeightEdge = pq.delMin();
            int v = minWeightEdge.either(), w = minWeightEdge.other(v);

            if (marked[v] && marked[w]) {
                continue;
            }

            mst.enqueue(minWeightEdge);
            weight += minWeightEdge.weight();

            if (!marked[v]) {
                visit(g, v);
            } else {
                visit(g, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        this.marked[v] = true;
        for (Edge e : g.adjacent(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return this.mst;
    }

    @Override
    public double weight() {
        return this.weight;
    }

}
