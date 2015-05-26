/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

/**
 *
 * @author mirash
 *
 * Result structure - tree (id[] - forest trees, binding by parent links) NB:
 * faster than fast search algorithm fast() - best case: 1 appeal to id[], worst
 * case - (2N-1) appeal
 *
 * Improvement: faster then linear union() execution of FastSearch.
 *
 * Common array appeals count while find execution(): for N pairs (p, q) is
 * 2(1+2+...+N) ~ N^2
 */
public class UnionFindingFastUnion extends UnionFindingFastSearch {

    public UnionFindingFastUnion(int n) {
        super(n);
    }

    /**
     * Searching for root of p, for example find(5) -> id[id[id[5]]] in [1 1 1 8
     * 3 0 5 1 8 8]
     *
     * @param p component
     * @return root name of p
     */
    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * Fast union method
     *
     * @param p component
     * @param q component
     */
    @Override
    public void union(int p, int q) {

        //bring p and q to a common root
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;

        count--;

    }
}
