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
public class TwoColorDepthSearch extends DepthSearch implements TwoColorSearch {

    private final boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColorDepthSearch(Graph g) {
        this.marked = new boolean[g.vertexCount()];
        this.color = new boolean[g.vertexCount()];

        for (int s = 0; s < g.vertexCount(); s++) {
            if (!this.marked[s]) {
                this.crawl(g, s);
            }
        }
    }

    @Override
    void crawl(Graph g, int v) {
        this.marked[v] = true;

        for (int w : g.adjacentVertices(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                crawl(g, w);
            } else if (color[w] == color[v]) {
                this.isTwoColorable = false;
            }
        }
    }

    @Override
    public boolean isBipartite() {
        return isTwoColorable;
    }

}
