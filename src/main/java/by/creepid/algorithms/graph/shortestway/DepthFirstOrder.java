/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

import by.creepid.algorithms.basic.bags.LinkedListQueue;
import by.creepid.algorithms.basic.bags.ResizedStack;
import by.creepid.algorithms.basic.bags.Stack;
import by.creepid.algorithms.graph.directed.Digraph;

/**
 *  The <tt>DepthFirstOrder</tt> class represents a data type for 
 *  determining depth-first search ordering of the vertices in a digraph
 *  or edge-weighted digraph, including preorder, postorder, and reverse postorder.
 *  <p>
 *  This implementation uses depth-first search.
 *  The constructor takes time proportional to <em>V</em> + <em>E</em>
 *  (in the worst case),
 *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 *  Afterwards, the <em>preorder</em>, <em>postorder</em>, and <em>reverse postorder</em>
 *  operation takes take time proportional to <em>V</em>.
 *  <p>
 *  <p>
 *  For additional documentation,
 *  see <a href="http://algs4.cs.princeton.edu/42digraph">Section 4.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class DepthFirstOrder {
    private boolean[] marked;          // marked[v] = has v been marked in dfs?
    private int[] pre;                 // pre[v]    = preorder  number of v
    private int[] post;                // post[v]   = postorder number of v
    private  LinkedListQueue<Integer> preorder;   // vertices in preorder
    private  LinkedListQueue<Integer> postorder;  // vertices in postorder
    private int preCounter;            // counter or preorder numbering
    private int postCounter;           // counter for postorder numbering

    /**
     * Determines a depth-first order for the digraph <tt>G</tt>.
     * @param G the digraph
     */
    public DepthFirstOrder(Digraph G) {
        pre    = new int[G.vertexCount()];
        post   = new int[G.vertexCount()];
        postorder = new  LinkedListQueue<Integer>();
        preorder  = new  LinkedListQueue<Integer>();
        marked    = new boolean[G.vertexCount()];
        for (int v = 0; v < G.vertexCount(); v++)
            if (!marked[v]) dfs(G, v);
    }

    /**
     * Determines a depth-first order for the edge-weighted digraph <tt>G</tt>.
     * @param G the edge-weighted digraph
     */
    public DepthFirstOrder(EdgeWeightedDigraph G) {
        pre    = new int[G.vertexes()];
        post   = new int[G.vertexes()];
        postorder = new LinkedListQueue<Integer>();
        preorder  = new LinkedListQueue<Integer>();
        marked    = new boolean[G.vertexes()];
        for (int v = 0; v < G.vertexes(); v++)
            if (!marked[v]) dfs(G, v);
    }

    // run DFS in digraph G from vertex v and compute preorder/postorder
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.enqueue(v);
        for (int w : G.adjacentVertices(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.enqueue(v);
        post[v] = postCounter++;
    }

    // run DFS in edge-weighted digraph G from vertex v and compute preorder/postorder
    private void dfs(EdgeWeightedDigraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.enqueue(v);
        for (DirectedEdge e : G.adjacent(v)) {
            int w = e.to();
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.enqueue(v);
        post[v] = postCounter++;
    }

    /**
     * Returns the preorder number of vertex <tt>v</tt>.
     * @param v the vertex
     * @return the preorder number of vertex <tt>v</tt>
     */
    public int pre(int v) {
        return pre[v];
    }

    /**
     * Returns the postorder number of vertex <tt>v</tt>.
     * @param v the vertex
     * @return the postorder number of vertex <tt>v</tt>
     */
    public int post(int v) {
        return post[v];
    }

    /**
     * Returns the vertices in postorder.
     * @return the vertices in postorder, as an iterable of vertices
     */
    public Iterable<Integer> post() {
        return postorder;
    }

    /**
     * Returns the vertices in preorder.
     * @return the vertices in preorder, as an iterable of vertices
     */
    public Iterable<Integer> pre() {
        return preorder;
    }

    /**
     * Returns the vertices in reverse postorder.
     * @return the vertices in reverse postorder, as an iterable of vertices
     */
    public Iterable<Integer> reversePost() {
        ResizedStack<Integer> reverse = new ResizedStack<Integer>();
        for (int v : postorder)
            reverse.push(v);
        return reverse;
    }

}
