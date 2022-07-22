package com.company;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Analyzer a = new Analyzer();
        a.toStartAnalysis(new Analyzer.AnalysisType[]{Analyzer.AnalysisType.YEAR, Analyzer.AnalysisType.MARK, Analyzer.AnalysisType.GENRE});

    }
}
