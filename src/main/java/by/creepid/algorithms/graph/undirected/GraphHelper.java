/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

/**
 *
 * @author rusakovich
 */
public class GraphHelper {

    private GraphHelper() {
    }

    /**
     * Degree of vertex
     *
     * @param g - graph
     * @param v - vertex
     * @return vertex count
     */
    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.adjacentVertices(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * Find max vertex degree
     *
     * @param g - graph
     * @return vertex degree
     */
    public static int maxDegree(Graph g) {
        int max = 0;

        for (int v = 0; v < g.vertexCount(); v++) {
            if (degree(g, v) > max) {
                max = degree(g, v);
            }
        }

        return max;
    }

    /**
     * Average degree of vertex
     *
     * @param g - graph
     * @return average degree
     */
    public static int avgDegree(Graph g) {
        return (2 * g.edgeCount()) / g.vertexCount();
    }

    /**
     * Self loops getting
     *
     * @param g - graph
     * @return count of self loops
     */
    public static int selfLoops(Graph g) {
        int count = 0;
        for (int v = 0; v < g.vertexCount(); v++) {
            for (int w : g.adjacentVertices(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        //cause every loops is counted twice
        return count / 2;
    }
    
}
