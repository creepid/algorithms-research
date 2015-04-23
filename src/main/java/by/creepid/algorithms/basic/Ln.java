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

    //ln(N!)
    public static double ln(Factorial factorial) {
        return Math.log(factorial.getValue());
    }
}
