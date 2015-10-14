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
public class TransitiveClosureImpl implements TransitiveClosure {

    private final DirectedDepthSearch[] all;

    public TransitiveClosureImpl(Digraph d) {
        this.all = new DirectedDepthSearch[d.vertexCount()];
        for (int v = 0; v < d.vertexCount(); v++) {
            this.all[v] = new DirectedDepthSearch(d, v);
        }
    }

    @Override
    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }

}
