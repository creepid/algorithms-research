/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mirash
 */
public class DataHelper {
    
    private static final String BASE_FOLDER = "src/test/resources/";

    private DataHelper() {
    }

    public static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        
        return ret;
    }

    public static int[] getIntArray(String dataFileName) {
        File dataFile = new File(BASE_FOLDER + dataFileName);
        if (!dataFile.exists()) {
            throw new RuntimeException("No such file: " + dataFileName);
        }

        try {
            FileReader fileReader = new FileReader(dataFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Integer> data = new ArrayList<Integer>();

            String temp = "";
            while ((temp = bufferedReader.readLine()) != null) {
                if (!temp.trim().isEmpty()) {
                    data.add(Integer.parseInt(temp.trim()));
                }
            }

            bufferedReader.close();

            return toIntArray(data);
        } catch (IOException ie) {
            throw new RuntimeException(ie);
        }
    }
}
