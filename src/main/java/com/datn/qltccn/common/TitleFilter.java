package com.datn.qltccn.common;

import java.util.*;

public class TitleFilter {
    public static List<String> xauConChung(List<String> a, String b) {
        List<String> result = new ArrayList<>();
        Map<String, Double> listString_Tile = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            String strC = a.get(i).toUpperCase();
            String strD = b.toUpperCase();

            String strA[] = strC.split(" ");

            String strB[] = strD.split(" ");
            List<String> arrayA;
            List<String> arrayB;
            arrayA = Arrays.asList(strA);

            arrayB = Arrays.asList(strB);

            List<String> arrayMap = new ArrayList<>();

            for (int k = 0; k < arrayA.size(); k++) {
                for (int h = 0; h < arrayB.size(); h++) {
                    if (arrayA.get(k).equals(arrayB.get(h))) {
                        arrayMap.add(arrayA.get(k));
                    }
                }
            }
            double Tile = (double) Math.round(((Double.valueOf(arrayMap.size())) / arrayA.size()) * 100) / 100;
            listString_Tile.put(strC, Tile);
        }
        List<Map.Entry<String, Double>> list = new LinkedList<>(listString_Tile.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        for (int u = 0; u < list.size(); u++) {
            result.add(list.get(u).getKey());
        }
        return result;
    }
}
