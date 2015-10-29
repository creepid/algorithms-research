/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.carcass;

import by.creepid.algorithms.basic.bags.LinkedListQueue;
import by.creepid.algorithms.basic.bags.Queue;
import by.creepid.algorithms.basic.uf.UnionFinding;
import by.creepid.algorithms.basic.uf.UnionFindingFastSearch;
import by.creepid.algorithms.sorting.priority.MinPriorityQueue;

/**
 *
 * @author rusakovich
 */
public class KruskalMST implements MST {

    private final LinkedListQueue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph g) {
        this.mst = new LinkedListQueue<>();

        MinPriorityQueue<Edge> pq = new MinPriorityQueue<>(g.edgeCount());
        for (Edge e : g.allEdges()) {
            pq.insert(e);
        }

        UnionFinding uf = new UnionFindingFastSearch(g.vertexCount());

        while (!pq.isEmpty() && mst.size() < g.vertexCount() - 1) {
            Edge e = pq.delMin();

            int v = e.either(), w = e.other(v);

            if (uf.connected(v, w)) {
                continue;
            }

            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return this.mst;
    }

    @Override
    public double weight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
