/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

/**
 *
 * @author mirash
 */
public class DijktrasAllPairsShortestPath {

    private ShortestPath[] all;

    public DijktrasAllPairsShortestPath(EdgeWeightedDigraph g) {
        this.all = new ShortestPath[g.vertexes()];
        for (int v = 0; v < g.vertexes(); v++) {
            all[v] = new DijktrasShortestPath(g, v);
        }
    }

    public Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    public double dist(int s, int t) {
        return all[s].distTo(t);
    }
}
