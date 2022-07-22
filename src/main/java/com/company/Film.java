package com.company;

public class Film {
    private String title;
    private String[] genre;
    private int year;
    private String[] director;
    private int mark;

    public Film(String title, String[] genre, int year, String[] director, int mark) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.director = director;
        this.mark = mark;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String[] getDirector() {
        return director;
    }

    public void setDirector(String[] director) {
        this.director = director;
    }
}
