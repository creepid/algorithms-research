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
public class ConnectedComponentsDepthSearch extends DepthSearch implements ConnectedComponents {

    private int[] component;
    private int count;

    public ConnectedComponentsDepthSearch(Graph g) {
        this.marked = new boolean[g.vertexCount()];
        this.component = new int[g.vertexCount()];

        for (int s = 0; s < g.vertexCount(); s++) {
            if (!this.marked[s]) {
                this.crawl(g, s);
                count++;
            }
        }
    }

    @Override
    void crawl(Graph g, int v) {
        this.component[v] = count;
        super.crawl(g, v);
    }

    @Override
    public boolean connected(int v, int w) {
        return (this.component[v] == this.component[w]);
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int component(int v) {
        return this.component[v];
    }

}
