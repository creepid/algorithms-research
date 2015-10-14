/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

import by.creepid.algorithms.searching.symboltable.LinkedListSymbolTable;
import by.creepid.algorithms.utils.DataInput;

/**
 *
 * @author rusakovich
 */
public class SymbolGraphImpl implements SymbolGraph {

    private final LinkedListSymbolTable<String, Integer> st;
    private final String[] keys;
    private final Graph g;

    public SymbolGraphImpl(String stream, String separator) {
        this.st = new LinkedListSymbolTable<>();
        DataInput input = new DataInput(stream);

        //create the indexes
        while (input.hasNextLine()) {
            String[] a = input.readLine().split(separator);

            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }

        //invert index for getting string keys
        this.keys = new String[st.size()];
        for (String name : st.keys()) {
            this.keys[st.get(name)] = name;
        }

        //create the graph
        this.g = new UndirectedGraph(st.size());
        input = new DataInput(stream);

        while (input.hasNextLine()) {
            String[] a = input.readLine().split(separator);
            int v = st.get(a[0]);

            for (int i = 1; i < a.length; i++) {
                g.addEdge(v, st.get(a[i]));
            }
        }

    }

    @Override
    public boolean contains(String key) {
        return st.contains(key);
    }

    @Override
    public int index(String key) {
        return st.get(key);
    }

    @Override
    public String name(int v) {
        return keys[v];
    }

    @Override
    public int vertexCount() {
        return g.vertexCount();
    }

    @Override
    public int edgeCount() {
        return g.edgeCount();
    }

    @Override
    public void addEdge(int v, int w) {
        g.addEdge(v, w);
    }

    @Override
    public Iterable<Integer> adjacentVertices(int v) {
        return g.adjacentVertices(v);
    }

    @Override
    public Iterable<Integer> vertices() {
        return g.vertices();
    }
}
