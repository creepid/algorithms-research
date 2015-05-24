/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

/**
 *
 * @author mirash
 */
public interface UnionFinding {

    /**
     * Add connection between p and q
     *
     * @param p first node to be connected
     * @param q second node to be connected
     */
    void union(int p, int q);

    /**
     * Return component id for p (must be between 0 and N-1)
     *
     * @param p - given node
     * @return component id
     */
    int find(int p);

    /**
     * Checks is given nodes belong the same component
     *
     * @param p - first node
     * @param q - second node
     * @return true, if p and q belongs the same component
     */
    boolean connected(int p, int q);

    /**
     * Getting components count
     *
     * @return components count
     */
    int count();
}
