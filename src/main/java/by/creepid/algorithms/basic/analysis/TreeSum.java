/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.analysis;

/**
 *
 * @author mirash
 */
public class TreeSum {

    private TreeSum() {
    }

    public static int countSimple(int[] arr) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (arr[i] + arr[j] + arr[k] == 0) {
                        cnt++;
                    }

                }
            }
        }

        return cnt;
    }
}
