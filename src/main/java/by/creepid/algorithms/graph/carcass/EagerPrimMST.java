/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.carcass;

import by.creepid.algorithms.sorting.priority.IndexedMinPriorityQueue;
import java.util.Arrays;

/**
 *
 * @author rusakovich
 */
public class EagerPrimMST implements MST {

    //shortest edge from root of tree 
    private Edge[] edgeTo;
    //distTo[w] = edgeTo[w].weight()
    private double[] distTo;
    //true if v already in tree
    private boolean[] marked;
    private IndexedMinPriorityQueue<Double> pq;

    public EagerPrimMST(EdgeWeightedGraph g) {
        this.edgeTo = new Edge[g.vertexCount()];
        this.distTo = new double[g.vertexCount()];
        this.marked = new boolean[g.vertexCount()];

        for (int v = 0; v < g.vertexCount(); v++) {
            this.distTo[v] = Double.POSITIVE_INFINITY;
        }

        this.pq = new IndexedMinPriorityQueue<Double>(g.vertexCount());
        this.distTo[0] = 0.0;

        pq.insert(0, 0.0);

        while (!pq.isEmpty()) {
            //add to tree nearest v
            visit(g, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        this.marked[v] = true;
        for (Edge e : g.adjacent(v)) {

            int w = e.other(v);
            if (marked[w]) {
                continue;
            }

            if (e.weight() < distTo[w]) {
                this.edgeTo[w] = e;
                this.distTo[w] = e.weight();

                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }

            }

        }
    }

    @Override
    public Iterable<Edge> edges() {
        return Arrays.asList(Arrays.copyOfRange(edgeTo, 1, edgeTo.length));
    }

    @Override
    public double weight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
