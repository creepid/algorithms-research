/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic;

/**
 *
 * @author rusakovich
 */
public class Factorial {

    private long value = 1;

    private void calculate(int n) {
        if (n == 0) {
            return;
        }

        value = value * n;
        calculate(n - 1);
    }

    public Factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N must be more than zero");
        }

        calculate(n);
    }

    public long getValue() {
        return value;
    }
}
