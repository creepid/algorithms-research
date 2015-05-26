/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

/**
 *
 * @author mirash
 *
 * find() - 1 appeal to id array union() - appeal to id in interval [N+3; 2N+1]
 *
 * One component last: need at least (N-1) union() method execution and
 * (N+3)(N-1) ~ N^2 id[] appeal
 */
public class UnionFindingFastSearch implements UnionFinding {

    protected int[] id;
    protected int count;

    public UnionFindingFastSearch(int n) {
        count = n;
        id = new int[n];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            //p and q already belong the same set
            return;
        }

        //component p rename to q
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
