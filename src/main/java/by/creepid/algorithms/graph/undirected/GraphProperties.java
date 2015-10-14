/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.graph.undirected;

/**
 *
 * @author mirash
 */
public interface GraphProperties {

    public int eccentricity(int v);

    public int diameter();

    public int radius();

    public int center();
}
