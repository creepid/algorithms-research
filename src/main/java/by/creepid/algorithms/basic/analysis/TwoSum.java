/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.analysis;

import java.util.Arrays;
import static by.creepid.algorithms.common.Arrays.*;

/**
 *
 * @author rusakovich
 */
public class TwoSum {

    private TwoSum() {
    }

    public static int countFast(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {

            if (binarySearchRank(-arr[i], arr) > i) {
                cnt++;
            }

        }

        return cnt;
    }

}
