/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.common;

/**
 *
 * @author rusakovich
 */
public class Primitive {
    
    private Primitive(){
    }

    public static double[] copyFromIntArray(int[] source) {
        double[] dest = new double[source.length];
        
        for (int i = 0; i < source.length; i++) {
            dest[i] = source[i];
        }
        
        return dest;
    }

}
