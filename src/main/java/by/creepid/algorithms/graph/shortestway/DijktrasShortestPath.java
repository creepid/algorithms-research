/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

import by.creepid.algorithms.sorting.priority.IndexedMinPriorityQueue;

/**
 *
 * @author mirash
 */
public class DijktrasShortestPath extends ShortestPathBase {

    private IndexedMinPriorityQueue<Double> pq;

    public DijktrasShortestPath(EdgeWeightedDigraph g, int source) {
        this.edgeTo = new DirectedEdge[g.vertexes()];
        this.distTo = new double[g.vertexes()];
        this.pq = new IndexedMinPriorityQueue<Double>(g.vertexes());

        for (int v = 0; v < g.vertexes(); v++) {
            this.distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[source] = 0.0;

        pq.insert(source, 0.0);
        while (!pq.isEmpty()) {
            relax(g, pq.delMin());
        }

    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adjacent(v)) {
            int w = e.to();

            if (distTo[w] > distTo[v] + e.weight()) {
                this.distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;

                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }

            }
        }
    }
}
