/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

import by.creepid.algorithms.basic.bags.LinkedListQueue;

/**
 *
 * @author rusakovich
 */
public class BellmanFordShortestPath extends ShortestPathBase implements NegativeCycleable {

    private boolean[] isOnQueue;
    //vertices for which relaxation is applied
    private LinkedListQueue<Integer> queue;
    //number of relax() invocations
    private int cost;
    //is there negative cycle in edgeTo[]?
    private Iterable<DirectedEdge> сycle;

    public BellmanFordShortestPath(EdgeWeightedDigraph g, int s) {
        this.distTo = new double[g.vertexes()];
        this.edgeTo = new DirectedEdge[g.vertexes()];
        this.isOnQueue = new boolean[g.vertexes()];
        this.queue = new LinkedListQueue<Integer>();

        for (int v = 0; v < g.vertexes(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        queue.enqueue(s);
        isOnQueue[s] = true;

        while (!queue.isEmpty() && !this.hasNegativeCycle()) {
            int v = queue.dequeue();
            isOnQueue[v] = false;
            relax(g, v);
        }

    }

    @Override
    public boolean hasNegativeCycle() {
        return сycle != null;
    }

    private void findNegativeCycle() {
        int v = edgeTo.length;
        EdgeWeightedDigraph spt = new SimpleEdgeWeightedDigraph(v);
        for (int curr = 0; curr < v; curr++) {
            if (edgeTo[curr] != null) {
                spt.addEdge(edgeTo[v]);
            }
        }
        EdgeWeightedDirectedCycle cf = new EdgeWeightedDirectedCycle(spt);
        сycle = cf.cycle();
    }

    @Override
    protected void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adjacent(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;

                if (!isOnQueue[w]) {
                    queue.enqueue(w);
                    isOnQueue[w] = true;
                }

                if (cost++ % g.vertexes() == 0) {
                    findNegativeCycle();
                }
            }
        }
    }

    @Override
    public Iterable<DirectedEdge> negativeCycle() {
        return this.сycle;
    }

}
