/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic;

/**
 *
 * @author mirash
 */
public class Ln {

    private Ln() {
    }

    public static class Factorial {

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

    //ln(N!)
    public static double ln(Factorial factorial) {
        return Math.log(factorial.getValue());
    }
}
