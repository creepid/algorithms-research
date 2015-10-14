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
public interface StrongConnection {

    boolean stronglyConnected(int v, int w);

    int count();

    int id(int v);

}
