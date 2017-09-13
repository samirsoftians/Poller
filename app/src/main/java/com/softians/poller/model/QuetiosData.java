package com.softians.poller.model;

/**
 * Created by HP on 26-08-2017.
 */

public class QuetiosData {

    private String title, genre, year;

    public QuetiosData(String[] question, String[] answer, String[] m_name) {
    }

    public QuetiosData(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
