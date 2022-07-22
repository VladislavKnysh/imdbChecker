package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineParser {


    public Film parse(String line) {
        String title = getData(line, FilmPart.TITLE);
        String[] genre = extractFromMultiple(getData(line, FilmPart.GENRE));
        String[] director = extractFromMultiple(getData(line, FilmPart.DIRECTOR));
        var year = Integer.parseInt(getData(line, FilmPart.YEAR));
        var mark = Integer.parseInt(getData(line, FilmPart.MARK));

        return new Film(title, genre, year, director, mark);

    }

    private String[] extractFromMultiple(String line) {
        ArrayList<String> genre = new ArrayList<>();
        Scanner sc = new Scanner(line);
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            genre.add(sc.next().replaceAll("\\s+", ""));
        }
        sc.close();
        return genre.toArray(String[]::new);
    }

    private String getData(String string, FilmPart dataPart) {

        Matcher matcher = dataPart.getPattern().matcher(string);
        boolean b = matcher.find();
        switch (dataPart) {
            case GENRE:
            case DIRECTOR:
                if (!b){
                    return "TV series";
                }
                return matcher.group().replaceAll("\"", "");

            default:
                return matcher.group();

        }


    }


    private enum FilmPart {
        TITLE("(?<=\\d-\\d{2},).+(?=,https)"),
        GENRE("(?<=\\d,)\\D+(?=,\\d)"),
        DIRECTOR("(?<=\\d,)\\D+$"),
        YEAR("(?<=,)\\d{4}(?=,\"{0,1}\\D)"),
        MARK("(?<=,)\\d{1,2}(?=,\\d+-)");
        private final String REGEX;

        FilmPart(String regex) {
            this.REGEX = regex;
        }

        Pattern getPattern() {
            return Pattern.compile(REGEX);

        }

    }
}