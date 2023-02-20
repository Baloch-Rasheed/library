package com.studybook.library.model;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class User {
    private int id;
    private String name;
    private String username;
    private String password;

    public void setUserBooks(List<Book> userBooks) {
        this.userBooks = userBooks;
    }

    private List<Book> userBooks = new ArrayList<>();

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) { this.password = password;}

    public List<Book> getUserBooks() {
        return userBooks;
    }
}
