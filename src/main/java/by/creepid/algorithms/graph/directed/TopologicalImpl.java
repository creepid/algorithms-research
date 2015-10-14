/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

/**
 *
 * @author rusakovich
 */
public class TopologicalImpl implements Topological {

    private Iterable<Integer> order;

    public TopologicalImpl(Digraph g) {
        DirectedCycle cyclefinder = new DirectedCycleImpl(g);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(g);
            this.order = dfs.reversePost();
        }
    }

    @Override
    public boolean isAcyclic() {
        return (order == null);
    }

    @Override
    public Iterable<Integer> order() {
        return this.order;
    }

}
