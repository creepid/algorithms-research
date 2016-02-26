/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

/**
 *
 * @author rusakovich
 *
 * Critical process management
 */
public class CPM {

    private final int jobsNumber;
    //start
    private final int source;
    //finish
    private final int sink;
    private final EdgeWeightedDigraph ewd;

    private int i = 0;

    public CPM(int jobsNumber) {
        this.jobsNumber = jobsNumber;
        this.source = 2 * jobsNumber;
        this.sink = 2 * jobsNumber + 1;
        this.ewd = new SimpleEdgeWeightedDigraph(2 * jobsNumber + 2);
    }

    public void addTask(double duration, int... successors) {
        ewd.addEdge(new StandardDirectedEdge(source, i, 0.0));
        ewd.addEdge(new StandardDirectedEdge(i, i + jobsNumber, duration));
        ewd.addEdge(new StandardDirectedEdge(i + jobsNumber, sink, 0.0));
        
        if (successors != null && successors.length > 0) {
            for (int j = 0; j < successors.length; j++) {
                int successor = successors[j];
                ewd.addEdge(new StandardDirectedEdge(i + jobsNumber, successor, 0.0));
            }
        }

        i++;
    }

    public double[] getStartMoments() {
        AcyclicLongestPath alp = new AcyclicLongestPath(ewd, source);
        double[] moments = new double[jobsNumber];
        for (int k = 0; k < jobsNumber; k++) {
            moments[k] = alp.distTo(k);
        }
        return moments;
    }

    public double getFinishMoment() {
        AcyclicLongestPath alp = new AcyclicLongestPath(ewd, source);
        return alp.distTo(sink);
    }

}
