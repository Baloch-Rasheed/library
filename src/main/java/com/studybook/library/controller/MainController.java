package com.studybook.library.controller;

import com.studybook.library.model.Book;
import com.studybook.library.model.User;
import com.studybook.library.services.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    public User getUser() {
        return user;
    }

    User user;
    LibraryService userAuth;
    MainController(LibraryService auth, User user){
        userAuth = auth;
        this.user = user;
        dummyUsers();
    }
    @GetMapping("/")
    String _index(Model model){
        model.addAttribute("user",user);
        return "login";
    }

    @GetMapping("/add-book")
    public String addBook(Model model){
        model.addAttribute("book",new Book());
        return "add_book";
    }
    @GetMapping("/booklist")
    public ModelAndView addBook(){
        ModelAndView mav = new ModelAndView("booklist");
        List<Book> books = userAuth.getBooks();
        mav.addObject("books",books);
        return mav;
    }

    @GetMapping("/homepage")
    public String home(){
        return "homepage";
    }

    @PostMapping("/additionbook")
    String additionBook(@ModelAttribute Book book){
        userAuth.addBook(book);
        return "redirect:/booklist";
    }
    @PostMapping("/deletion")
    String deletionBook(@ModelAttribute Book book){
        userAuth.deleteBook(book.getId());
        return "redirect:/booklist";
    }

    @PostMapping("/edition")
    String editionBook(@ModelAttribute Book book, Model model){
        Book editableBook = userAuth.getBook(book.getId());
        userAuth.deleteBook(book.getId());
        model.addAttribute("book",editableBook);
        return "add_book";
    }

    @PostMapping("/login-process")
    String userLogin(@ModelAttribute User user,Model model){
        this.user = user;
        if(userAuth.login(user.getUsername(),user.getPassword()) != null){
            return "homepage";
        }
        return "redirect:/";
    }
    @PostMapping("/welcome-user")
    String welcomePage(@ModelAttribute User user){
        this.user.setName(user.getName());
        return "homepage";
    }

    void dummyUsers(){
        User u1 = new User();
        u1.setUsername("baloch@email.com");
        u1.setPassword("123");
        u1.setName("Baloch");
        userAuth.registerUser(u1);

        User u2 = new User();
        u2.setUsername("example@email.com");
        u2.setPassword("1234");
        u2.setName("Shadad");
        userAuth.registerUser(u2);

        User u3 = new User();
        u3.setUsername("nobody@email.com");
        u3.setPassword("12345");
        u3.setName("Laddad");
        userAuth.registerUser(u3);
    }
}
