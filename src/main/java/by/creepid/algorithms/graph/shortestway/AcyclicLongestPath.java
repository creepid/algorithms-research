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
public class AcyclicLongestPath extends ShortestPathBase {

    public AcyclicLongestPath(EdgeWeightedDigraph g, int s) {
        this.edgeTo = new StandardDirectedEdge[g.vertexes()];
        this.distTo = new double[g.vertexes()];

        for (int v = 0; v < g.vertexes(); v++) {
            distTo[v] = Double.NEGATIVE_INFINITY;
        }
        distTo[s] = 0.0;

        Topological top = new Topological(g);
        for (int v : top.order()) {
            relax(g, v);
        }
    }

    @Override
    protected void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adjacent(v)) {
            int w = e.to();
            if (distTo[w] < distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

}
