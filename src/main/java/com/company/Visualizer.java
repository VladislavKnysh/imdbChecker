package com.company;

import java.util.*;

public class Visualizer {
    public void toVisualizeGenre(TreeMap<String, Integer> map, boolean b) {
        if (b) {
            visualizeByAlphabet(map);
        } else {
            visualizeByNumber(map);
        }
    }
    public void toVisualizeStringInt(TreeMap map, Analyzer.AnalysisType type) {
        switch (type){
            case GENRE:
                System.out.println("By genre:");
                visualizeByNumber(map);
                break;
            case DIRECTOR:
                System.out.println("By director:");
                visualizeByNumber(map);
                break;

            default:
                throw new IllegalStateException();
        }

    }

    private void visualizeByAlphabet(TreeMap<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
               for (Map.Entry<String, Integer> entry : map.entrySet())
            sb.append(entry.getKey() + ":" + entry.getValue() + "\n");
        System.out.println(sb);
    }

    private void visualizeByNumber(TreeMap<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> aa : list) {
            sb.append(aa.getKey() + ":" + aa.getValue() + "\n");
        }

        System.out.println(sb);

    }

    public void toVisualizeIntInt(TreeMap<Integer, Integer> map, Analyzer.AnalysisType type) {
        StringBuilder sb = new StringBuilder();
        switch (type) {
            case YEAR:
                System.out.println("By year:");
                break;
            case MARK:
                System.out.println("By rating:");
                break;
            default:
                throw new IllegalStateException();
        }
        for (Integer key : map.keySet()) {
            sb.append(key + ": " + map.get(key) + "\n");
        }
        System.out.println(sb);
    }


}
