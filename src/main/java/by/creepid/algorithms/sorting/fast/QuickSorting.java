/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.creepid.algorithms.sorting.fast;

import by.creepid.algorithms.sorting.BaseSorting;
import by.creepid.algorithms.utils.StdRandom;

/**
 *
 * @author rusakovich
 * 
 * - Very little comparison number
 * - In worst case: ~N^2/2 compare operation
 */
public class QuickSorting extends BaseSorting {
    
    protected QuickSorting(){
    }
    
    public static void sort(Comparable[] a){
        // for performance garantee
        StdRandom.shuffle(a);
        sort(a,0,a.length - 1);
    }
    
    //division method
    static int partition(Comparable[] a, int lo, int hi){
        int i =lo, j = hi+1;
        Comparable v = a[lo];
        
        while(true){
            //browse right side
            while(less(a[++i],v)) if (i == hi) break;
            //browse left side
            while(less(v,a[--j])) if (j == lo) break;
            //checking if the end
            if (i>=j)break;
            //exchanging
            exch(a,i,j);
        }
        //Put v = a[j] on his own place
        exch(a, lo, j);
        
        return j;
    }
    
    static void sort(Comparable[] a, int lo, int hi){
        if (hi<=lo)return;
        //dividing
        int j = partition(a, lo, hi);
        //left side sorting
        sort(a, lo, j-1);
        //rignt side sorting
        sort(a, j+1, hi);
    }
    
    
}
