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
public interface ConnectedComponents {

    public boolean connected(int v, int w);

    public int count();

    public int component(int v);

}
