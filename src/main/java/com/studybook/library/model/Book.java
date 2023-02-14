package com.studybook.library.model;

import org.springframework.stereotype.Component;

@Component
public class Book {

    //Fields
    private int id;
    public String name;
    public String author;
    public int prize;
    public String category;
    public String publishedIn;

    //Methods


    //constructors


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishedIn() {
        return publishedIn;
    }

    public void setPublishedIn(String publishedIn) {
        this.publishedIn = publishedIn;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){return this.id;}


}
