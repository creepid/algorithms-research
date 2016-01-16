/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

import java.io.PrintStream;

/**
 *
 * @author rusakovich
 */
public class ShortestPathClient implements ShortestPathPrinter {

    private final EdgeWeightedDigraph digraph;
    private final int startVertex;
    private ShortestPath shortestPath;

    public ShortestPathClient(EdgeWeightedDigraph digraph, int startVertex) {
        this.digraph = digraph;
        this.startVertex = startVertex;
    }

    @Override
    public void print(PrintStream printStream) {
        for (int t = 0; t < digraph.vertexes(); t++) {

            printStream.print(startVertex + " to " + t);
            printStream.printf(" (%4.2f): ", shortestPath.distTo(t));

            if (this.shortestPath.hasPathTo(t)) {
                for (DirectedEdge e : shortestPath.pathTo(t)) {
                    printStream.print(e + " ");
                }
                printStream.println();
            }
        }
    }

}
