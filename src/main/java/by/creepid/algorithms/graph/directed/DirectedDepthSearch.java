/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

import by.creepid.algorithms.graph.undirected.Search;

/**
 *
 * @author rusakovich
 */
public class DirectedDepthSearch implements Search {
    
    private final boolean[] marked;
    private int count;
    
    public DirectedDepthSearch(Digraph g, int start) {
        this.marked = new boolean[g.vertexCount()];
        this.crawl(g, start);
    }
    
    public DirectedDepthSearch(Digraph g, Iterable<Integer> sources) {
        this.marked = new boolean[g.vertexCount()];
        for (int s : sources) {
            if (!marked[s]) {
                this.crawl(g, s);
            }
        }
    }
    
    private void crawl(Digraph g, int v) {
        this.marked[v] = true;
        count++;
        
        for (int w : g.adjacentVertices(v)) {
            if (!marked[w]) {
                crawl(g, w);
            }
        }
    }
    
    @Override
    public boolean marked(int v) {
        return this.marked(v);
    }
    
    @Override
    public int count() {
        return count;
    }
    
}
