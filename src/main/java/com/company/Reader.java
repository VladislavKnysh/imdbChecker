package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Reader {
    Path path = Paths.get("ratings.csv");

        public List<Film> getAllFilms(){
            List<Film> filmList = new ArrayList<>();
            try {
                List<String> lines = Files.readAllLines(path);
                LineParser parser = new LineParser();
                int i = 0;
                for (String line : lines) {
                    if(i==0){i++;}else {
                    i++;
                    filmList.add(parser.parse(line));
                }}

            } catch (Exception e) {
                e.printStackTrace();
            }
            return filmList;
        }

}
