package com.example.qoutes;

public class FavoriteData {

    public String qoute,author,date;

    public FavoriteData(String qoute, String author, String date) {
        this.qoute = qoute;
        this.author = author;
        this.date = date;
    }

    public String getQoute() {
        return qoute;
    }

    public void setQoute(String qoute) {
        this.qoute = qoute;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
