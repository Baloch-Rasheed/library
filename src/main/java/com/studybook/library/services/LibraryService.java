package com.studybook.library.services;

import com.studybook.library.model.Book;
import com.studybook.library.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryService {
    private int counter = 0;
    private int idSetter = 0;
    private User user;
    private List<User> users = new ArrayList<>();


    // book service
    public void addBook(Book book){
        book.setId(idSetter++);
        user.getUserBooks().add(book);
    }
    public List<Book> getBooks(){
        return user.getUserBooks();
    }
    public void deleteBook(int id){
        counter--;
        user.getUserBooks().remove(getBook(id));
    }
    public Book getBook(int id){
        for(Book book:getBooks()){
            if(book.getId() == id){
                System.out.println(book);
                return book;
            }
        }
        System.out.println("Book doesn't seems to be here");
        return null;
    }


    // Auth service
    public User login(String username, String password){
        for (User value : users) {
            if(value.getUsername().equals(username) && value.getPassword().equals(password)){
                user = value;
                return value;
            }
        }
        return null;
    }
    public void registerUser(User user){
        user.setId(counter++);
        users.add(user);
    }

}
