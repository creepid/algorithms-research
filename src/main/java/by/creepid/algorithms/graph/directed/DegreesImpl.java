/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.directed;

import by.creepid.algorithms.basic.bags.BagSimple;
import java.util.Iterator;

/**
 *
 * @author rusakovich
 */
public class DegreesImpl implements Degrees {

    private final Digraph g;

    public DegreesImpl(Digraph g) {
        this.g = g;
    }

    @Override
    public int indegree(int v) {
        //TODO do not observe all the graph
        int indegreeCount = 0;
        DirectedDepthSearch depthSearch = new DirectedDepthSearch(g.reverse(), v);
        for (int adjV : g.reverse().adjacentVertices(v)) {
            if (depthSearch.marked(adjV)) {
                indegreeCount++;
            }
        }

        return indegreeCount;
    }

    @Override
    public int outdegree(int v) {
        int outdegreeCount = 0;
        DirectedDepthSearch depthSearch = new DirectedDepthSearch(g, v);
        for (int adjV : g.adjacentVertices(v)) {
            if (depthSearch.marked(adjV)) {
                outdegreeCount++;
            }
        }
        return outdegreeCount;
    }

    @Override
    public Iterable<Integer> sources() {
        BagSimple<Integer> sources = new BagSimple<>();

        Iterator<Integer> vertIterator = g.vertices().iterator();
        while (vertIterator.hasNext()) {
            int v = vertIterator.next();
            if (indegree(v) == 0) {
                sources.add(v);
            }
        }

        return sources;
    }

    @Override
    public Iterable<Integer> sinks() {
        BagSimple<Integer> sinks = new BagSimple<>();

        Iterator<Integer> vertIterator = g.vertices().iterator();
        while (vertIterator.hasNext()) {
            int v = vertIterator.next();
            if (outdegree(v) == 0) {
                sinks.add(v);
            }
        }

        return sinks;
    }

    @Override
    public boolean isMap() {
        Iterator<Integer> vertIterator = g.vertices().iterator();
        while (vertIterator.hasNext()) {
            int v = vertIterator.next();
            if (outdegree(v) != 1) {
                return false;
            }
        }
        
        return true;
    }

}
