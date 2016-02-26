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
public class AcyclicShortestPath extends ShortestPathBase {

    public AcyclicShortestPath(EdgeWeightedDigraph g, int s) {
        this.edgeTo = new StandardDirectedEdge[g.vertexes()];
        this.distTo = new double[g.vertexes()];

        for (int v = 0; v < g.vertexes(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        Topological top = new Topological(g);
        for (int v : top.order()) {
            relax(g, v);
        }
    }

}
