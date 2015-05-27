/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

/**
 *
 * @author mirash
 *
 * Ideal case: when every node linked with root of tree Leakage: too many link
 * to be modified
 *
 * Suitable solution: link with root all looked through nodes
 *
 */
public class UnionFindingWeightedWrappedPath extends UnionFindingWeighted {

    public UnionFindingWeightedWrappedPath(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        int pRoot = super.find(p);

        //link all nodes with root of branch
        int temp;
        while (p != id[p]) {
            temp = p;
            p = id[p];
            id[temp] = pRoot;
        }

        return pRoot;
    }
}
