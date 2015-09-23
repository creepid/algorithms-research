/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.application;

import by.creepid.algorithms.searching.hashtable.LinearProbingHashTable;

/**
 *
 * @author rusakovich
 */
public class SparseVector {

    private final LinearProbingHashTable<Integer, Double> symbolTable;

    public SparseVector() {
        this.symbolTable = new LinearProbingHashTable<Integer, Double>();
    }

    public int size() {
        return this.symbolTable.size();
    }

    public void put(int i, double x) {
        this.symbolTable.put(i, x);
    }

    public double get(int i) {
        if (!this.symbolTable.contains(i)) {
            return 0.0;
        } else {
            return this.symbolTable.get(i);
        }
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (Integer key : symbolTable.keys()) {
            if (key != null) {
                sum += that[key] * this.get(key);
            }
        }
        return sum;
    }

}
