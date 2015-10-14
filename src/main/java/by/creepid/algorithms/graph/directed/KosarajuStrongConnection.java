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
public class KosarajuStrongConnection implements StrongConnection {

    private boolean[] marked;
    //id of components
    private int[] id;
    //count of strong components
    private int count;

    public KosarajuStrongConnection(Digraph d) {
        this.marked = new boolean[d.vertexCount()];
        this.id = new int[d.vertexCount()];
        
        DepthFirstOrder order = new DepthFirstOrder(d.reverse());
        
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                this.crawl(d, s);
                count++;
            }
        }
    }

    private void crawl(Digraph g, int v) {
        this.marked[v] = true;
        this.id[v] = count;
        for (int w : g.adjacentVertices(v)) {
            if (!marked[w]) {
                crawl(g, w);
            }
        }
    }

    @Override
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int id(int v) {
        return id[v];
    }

}
