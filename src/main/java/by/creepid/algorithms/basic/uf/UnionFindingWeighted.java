/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

/**
 *
 * @author mirash
 *
 * Traces trees sizes to be connected and always bind small root to bigger one.
 *
 * Worst case - when trees sizes are always equal.
 *
 * Tree properties:
 * 1. Length of tree with 2^n nodes always equal n.
 * 2. Union of two trees with 2^n nodes gives a tree with 2^(n+1) nodes
 *
 * Concludes:
 * 1. Weighted union guarantee lg-performance
 * 2. Length of any tree in forest for N nodes is less then lg(N)
 * 3. The only construction for really big data solution 
 * (for example, 100 nodes, 88 operations union() gives in fast union case average deep: 5.11, 
 * weighted union - average deep - 1.52)
 * 4. Uses not more then Mlg(N)+C (C - small) appeals to id[] (M - connections, N - nodes)
 *
 */
public class UnionFindingWeighted extends UnionFindingFastUnion {

    protected int[] treeSize;//components size for roots (indexation by nodes)

    public UnionFindingWeighted(int n) {
        super(n);
        treeSize = new int[n];
        for (int i = 0; i < n; i++) {
            treeSize[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (treeSize[pRoot] < treeSize[qRoot]) {
            id[pRoot] = qRoot;
            treeSize[qRoot] += treeSize[pRoot];
        } else {
            id[qRoot] = pRoot;
            treeSize[pRoot] += treeSize[qRoot];
        }

        count--;
    }
}
