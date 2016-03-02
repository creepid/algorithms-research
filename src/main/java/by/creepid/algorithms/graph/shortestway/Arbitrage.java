/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.shortestway;

/**
 *
 * @author rusakovich
 */
public class Arbitrage {

    private int verticles;
    private EdgeWeightedDigraph g;

    public Arbitrage(int verticles) {
        this.verticles = verticles;
        this.g = new SimpleEdgeWeightedDigraph(verticles);
    }

    public void addCurrencyRate(int v, int w, double rate) {
        DirectedEdge e = new StandardDirectedEdge(v, w, -Math.log(rate));
        g.addEdge(e);
    }

    public boolean hasArbitrage() {
        BellmanFordShortestPath sp = new BellmanFordShortestPath(g, 0);
        return sp.hasNegativeCycle();
    }

    public double getProfit(double stake) {
        BellmanFordShortestPath sp = new BellmanFordShortestPath(g, 0);
        if (sp.hasNegativeCycle()) {
            double currStake = stake;
            for (DirectedEdge e : sp.negativeCycle()) {
                currStake *= Math.exp(-e.weight());
            }
            return (currStake - stake);
        } else {
            return Double.MIN_VALUE;
        }
    }

}
