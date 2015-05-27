/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

/**
 *
 * @author mirash
 */
public class StandartUFPrinter implements UFPrinter {

    @Override
    public void printPairsCount(int count) {
        System.out.println("Pairs count: " + count);
    }

    @Override
    public void printPair(int p, int q) {
        System.out.println("[" + p + ", " + q + "]");
    }
}
