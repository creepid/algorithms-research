/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

import by.creepid.algorithms.basic.bags.LinkedListQueue;
import java.util.Iterator;

/**
 *
 * @author mirash
 */
public class GraphPropertiesImpl implements GraphProperties {

    private final Graph g;
    private boolean[] marked;
    private int[] edgeTo;

    public GraphPropertiesImpl(Graph g) {
        this.g = g;
    }

    private boolean hasPathTo(int v) {
        return marked[v];
    }

    private int pathLength(int s, int v) {
        if (!hasPathTo(v)) {
            return Integer.MAX_VALUE;
        }

        int len = 0;
        for (int x = v; x != s; x = edgeTo[x]) {
            len++;
        }

        return len;
    }

    private void crawl(int v) {
        marked = new boolean[g.vertexCount()];
        edgeTo = new int[g.vertexCount()];

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        marked[v] = true;
        queue.enqueue(v);

        while (!queue.isEmpty()) {
            int currV = queue.dequeue();

            for (int w : g.adjacentVertices(currV)) {
                if (!marked[w]) {
                    edgeTo[w] = currV;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    @Override
    public int eccentricity(int v) {
        crawl(v);

        int maxPath = 0;

        Iterator<Integer> verts = g.vertices().iterator();
        while (verts.hasNext()) {
            int currV = verts.next();
            int pathLen = pathLength(v, currV);
            if (pathLen != Integer.MAX_VALUE) {
                if (pathLen > maxPath) {
                    maxPath = pathLen;
                }
            }
        }

        return maxPath;
    }

    @Override
    public int diameter() {
        int maxEccentr = Integer.MIN_VALUE;
        Iterator<Integer> verts = g.vertices().iterator();
        while (verts.hasNext()) {
            int eccentr = eccentricity(verts.next());
            if (eccentr > maxEccentr) {
                maxEccentr = eccentr;
            }
        }
        return maxEccentr;
    }

    @Override
    public int radius() {
        int minEccentr = Integer.MAX_VALUE;
        Iterator<Integer> verts = g.vertices().iterator();
        while (verts.hasNext()) {
            int eccentr = eccentricity(verts.next());
            if (eccentr < minEccentr) {
                minEccentr = eccentr;
            }
        }
        return minEccentr;
    }

    @Override
    public int center() {
        int radius = radius();
        Iterator<Integer> verts = g.vertices().iterator();
        while (verts.hasNext()) {
            int v = verts.next();
            int eccentr = eccentricity(v);
            if (eccentr == radius) {
                return v;
            }
        }
        throw new IllegalStateException("Certr not found");
    }
}
