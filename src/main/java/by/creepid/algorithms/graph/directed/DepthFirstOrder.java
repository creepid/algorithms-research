/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

import by.creepid.algorithms.basic.bags.LinkedListQueue;
import by.creepid.algorithms.basic.bags.ResizedStack;
import by.creepid.algorithms.graph.undirected.DepthSearch;
import by.creepid.algorithms.graph.undirected.Graph;

/**
 *
 * @author rusakovich
 */
public class DepthFirstOrder extends DepthSearch {

    private LinkedListQueue<Integer> pre;
    private LinkedListQueue<Integer> post;
    private ResizedStack<Integer> reversePost;

    public DepthFirstOrder(Digraph g) {
        this.pre = new LinkedListQueue<Integer>();
        this.post = new LinkedListQueue<Integer>();
        this.reversePost = new ResizedStack<Integer>();
        marked = new boolean[g.vertexCount()];
        for (int v = 0; v < g.vertexCount(); v++) {
            if (!marked[v]) {
                this.crawl(g, v);
            }
        }
    }

    @Override
    protected void crawl(Graph g, int v) {
        pre.enqueue(v);
        super.crawl(g, v);
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return this.pre;
    }

    public Iterable<Integer> reversePost() {
        return this.reversePost;
    }

    public Iterable<Integer> post() {
        return this.post;
    }

}
