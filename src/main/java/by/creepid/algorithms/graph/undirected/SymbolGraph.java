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
public interface SymbolGraph extends Graph {

    public boolean contains(String key);

    public int index(String key);

    public String name(int v);

}
