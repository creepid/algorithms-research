/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

import by.creepid.algorithms.basic.bags.ResizedStack;

/**
 *
 * @author rusakovich
 */
public class DirectedCycleImpl implements DirectedCycle {

    private final boolean[] marked;
    private final int[] edgeTo;
    private ResizedStack<Integer> cycle;
    private boolean[] inRecursionStack;

    public DirectedCycleImpl(Digraph g) {
        this.inRecursionStack = new boolean[g.vertexCount()];
        this.edgeTo = new int[g.vertexCount()];
        this.marked = new boolean[g.vertexCount()];

        for (int v = 0; v < g.vertexCount(); v++) {
            if (!marked[v]) {
                crawl(g, v);
            }
        }
    }

    private void crawl(Digraph g, int v) {
        this.inRecursionStack[v] = true;
        this.marked[v] = true;

        for (int w : g.adjacentVertices(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                this.edgeTo[w] = v;
                crawl(g, w);
            } else if (this.inRecursionStack[w]) {
                this.cycle = new ResizedStack<>();

                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }

                cycle.push(w);
                cycle.push(v);
            }
            this.inRecursionStack[v] = false;

        }
    }

    @Override
    public Iterable<Integer> cycle() {
        return this.cycle;
    }

    @Override
    public boolean hasCycle() {
       return this.cycle != null;
    }

}
