package com.studybook.library.services;

import com.studybook.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private int idSetter = 0;

    public List<Book> getBooks(){
        return this.books;
    }

    public List<String> tooString(){
        List<String> list = new ArrayList<>();
        for (Book b : books) {
            list.add("Name: " + b.name + " Author: " + b.author + " Prize: " + b.prize + " Category: " + b.category + " Published in: " + b.publishedIn);
        }
        return list;
    }

    public void addBook(Book book){
        book.setId(idSetter++);
        books.add(book);
    }

    public void deleteBook(int id){
        books.remove(id);
    }

}
