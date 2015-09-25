/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.application;

import by.creepid.algorithms.searching.hashtable.LinearProbingHashTable;
import java.util.Iterator;

/**
 *
 * @author rusakovich
 */
public class SparseMatrix {

    private final LinearProbingHashTable<Integer, SparseVector> matrix;

    public SparseMatrix() {
        this.matrix = new LinearProbingHashTable<Integer, SparseVector>();
    }

    public void put(Integer i, SparseVector sv) {
        matrix.put(i, sv);
    }

    public SparseVector get(Integer i) {
        return matrix.get(i);
    }

    public int size() {
        return matrix.size();
    }

    public SparseMatrix sum(SparseMatrix another) {
        SparseMatrix result = new SparseMatrix();

        Iterator<Integer> thisKeys = matrix.keys().iterator();

        while (thisKeys.hasNext()) {
            Integer thisKey = thisKeys.next();

            SparseVector thisVector = matrix.get(thisKey);
            SparseVector anotherVector = another.matrix.get(thisKey);

            result.put(thisKey, thisVector.sum(anotherVector));
        }

        return result;
    }

    public SparseMatrix mult(SparseMatrix another) {

        int matrixSize = this.size();
        SparseMatrix result = new SparseMatrix();
        
        for (int i = 0; i < matrixSize; i++) {
            result.put(i, new SparseVector());
        }

        Iterator<Integer> thisKeys = matrix.keys().iterator();
        while (thisKeys.hasNext()) {
            Integer iKey = thisKeys.next();

            Iterator<Integer> anotherKeys = another.matrix.keys().iterator();
            while (anotherKeys.hasNext()) {
                Integer jKey = anotherKeys.next();

                Iterator<Integer> resultKeys = result.matrix.keys().iterator();
                while(resultKeys.hasNext()){
                    Integer kKey = resultKeys.next();
                    
                    double primary = result.get(iKey).get(jKey);
                    double after = primary + this.get(iKey).get(kKey) * another.get(kKey).get(jKey);
                    
                    result.get(iKey).put(jKey, after);
                }
            }

        }

        return result;
    }

}
