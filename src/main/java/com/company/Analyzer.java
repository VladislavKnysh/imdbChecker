package com.company;


import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;


public class Analyzer {
    private Reader reader = new Reader();
    private List filmList;

    public Analyzer() {
        filmList = reader.getAllFilms();


    }

    public void toStartAnalysis(AnalysisType[] types){
        System.out.println("Total number of watched films:" + filmList.size());
        for (AnalysisType type: types) {
            toAnalyze(type);
        }
    }
    public void toStartAnalysis(AnalysisType type){
        System.out.println("Total number of watched films:" + filmList.size());
        toAnalyze(type);
    }

    private void toAnalyze(AnalysisType type) {
        Visualizer v = new Visualizer();
        switch (type) {
            case GENRE:
                v.toVisualizeStringInt(analyzeStringInt(AnalysisType.GENRE), AnalysisType.GENRE);
                break;
            case YEAR:
                v.toVisualizeIntInt(analyzeIntInt(AnalysisType.YEAR), AnalysisType.YEAR);
                break;
            case DIRECTOR:
                v.toVisualizeStringInt(analyzeStringInt(AnalysisType.DIRECTOR), AnalysisType.DIRECTOR);
                break;
            case MARK:
                v.toVisualizeIntInt(analyzeIntInt(AnalysisType.MARK), AnalysisType.MARK);
                break;
            case ALL:
                v.toVisualizeStringInt(analyzeStringInt(AnalysisType.GENRE), AnalysisType.GENRE);
                v.toVisualizeIntInt(analyzeIntInt(AnalysisType.YEAR), AnalysisType.YEAR);
                v.toVisualizeStringInt(analyzeStringInt(AnalysisType.DIRECTOR), AnalysisType.DIRECTOR);
                v.toVisualizeIntInt(analyzeIntInt(AnalysisType.MARK), AnalysisType.MARK);
                break;
        }
    }

    private TreeMap analyzeStringInt(AnalysisType type) {
        TreeMap<String, Integer> list = new TreeMap<>();
        switch (type) {
            case DIRECTOR:
                for (Film f : reader.getAllFilms()) {
                    for (String s : f.getDirector()) {
                        if (list.containsKey(s)) {
                            list.put(s, list.get(s) + 1);
                        } else {
                            list.put(s, 1);
                        }
                    }
                }
                return list;
            case GENRE:
                for (Film f : reader.getAllFilms()) {
                    for (String s : f.getGenre()) {
                        if (list.containsKey(s)) {
                            list.put(s, list.get(s) + 1);
                        } else {
                            list.put(s, 1);
                        }
                    }
                }
                return list;

            default:
                throw new IllegalStateException();
        }

    }

    private TreeMap analyzeIntInt(AnalysisType type) {
        TreeMap<Integer, Integer> list = new TreeMap<>();
        switch (type) {
            case MARK:
                for (Film f : reader.getAllFilms()) {
                    Integer s = f.getMark();
                    if (list.containsKey(s)) {
                        list.put(s, list.get(s) + 1);
                    } else {
                        list.put(s, 1);
                    }
                }
                return list;
            case YEAR:

                for (Film f : reader.getAllFilms()) {
                    Integer s = f.getYear();
                    if (list.containsKey(s)) {
                        list.put(s, list.get(s) + 1);
                    } else {
                        list.put(s, 1);
                    }
                }
                return list;
            default:
                throw new IllegalStateException();
        }

    }

    public enum AnalysisType {
        GENRE,
        YEAR,
        DIRECTOR,
        MARK,
        ALL;
    }
}
