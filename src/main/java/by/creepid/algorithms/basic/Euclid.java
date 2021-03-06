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
public class Euclid {

    private Euclid() {
    }

    //Greatest common divisor calculation
    //1. if q == 0, p is answer
    //2. if q != 0, r = (p mod q)
    //3. do the same with q and r
    public static long gcd(long p, long q) {

        if (q == 0) {
            return p;
        }

        long r = p % q;

        return gcd(q, r);
    }

}
