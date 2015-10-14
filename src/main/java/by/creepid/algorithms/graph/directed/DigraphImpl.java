/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

import by.creepid.algorithms.basic.bags.BagSimple;
import by.creepid.algorithms.utils.DataInput;
import java.util.Iterator;

/**
 *
 * @author rusakovich
 */
public class DigraphImpl implements Digraph {

    private final int vertexes;
    private int edges;
    private BagSimple<Integer>[] adj;

    public DigraphImpl(int vertexes) {
        this.adj = new BagSimple[vertexes];
        this.vertexes = vertexes;
        this.edges = 0;
        for (int v = 0; v < vertexes; v++) {
            this.adj[v] = new BagSimple<>();
        }
    }

    public DigraphImpl(DataInput in) {
        //read vertices
        this(in.readInt());
        int edges = in.readInt();

        for (int i = 0; i < edges; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    @Override
    public Digraph reverse() {
        Digraph reversed = new DigraphImpl(this.vertexes);
        for (int v = 0; v < this.vertexes; v++) {
            for (int w : adj[v]) {
                reversed.addEdge(w, v);
            }
        }
        return reversed;
    }

    @Override
    public int vertexCount() {
        return this.vertexes;
    }

    @Override
    public int edgeCount() {
        return this.edges;
    }

    @Override
    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.edges++;
    }

    @Override
    public Iterable<Integer> adjacentVertices(final int v) {
        return new Iterable<Integer>() {

            @Override
            public Iterator<Integer> iterator() {
                return adj[v].iterator();
            }

        };
    }

}
