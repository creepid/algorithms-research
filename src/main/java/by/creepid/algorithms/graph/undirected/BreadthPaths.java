/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

import by.creepid.algorithms.basic.bags.LinkedListQueue;

/**
 *
 * @author rusakovich
 *
 * Search for shortest path
 */
public class BreadthPaths extends DepthPaths {

    public BreadthPaths(Graph g, int start) {
        super(g, start);
    }

    @Override
    void crawl(Graph g, int s) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        this.marked[s] = true;
        queue.enqueue(s);

        while (!queue.isEmpty()) {
            int v = queue.dequeue();

            for (int w : g.adjacentVertices(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }

    }

}
