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
public class CycleDepthSearch extends DepthSearch implements CycleSearch {
    
    private boolean hasCycle;
    
    public CycleDepthSearch(Graph g) {
        marked = new boolean[g.vertexCount()];
        for (int s = 0; s < g.vertexCount(); s++) {
            if (!marked[s]) {
                this.crawl(g, s, s);
            }
        }
    }
    
    void crawl(Graph g, int v, int u) {
        this.marked[v] = true;
        for (int w : g.adjacentVertices(v)) {
            if (!marked[w]) {
                crawl(g, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }
    
    @Override
    public boolean hasCycle() {
        return this.hasCycle;
    }
    
}
