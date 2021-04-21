package com.limouren.common;

import com.limouren.everyday.Solution992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Common {

    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(Solution992.class.getClassLoader().getResourceAsStream(fileName)));
            String a;
            while ((a = br.readLine()) != null) {
                sb.append(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String readFile() {
        return readFile("array.txt");
    }

    public static int[] readArray() {
        String[] as = Common.readFile().split(",");
        int[] A = new int[as.length];
        for (int i = 0; i < as.length; i++) {
            A[i] = Integer.parseInt(as[i]);
        }
        return A;
    }

}
