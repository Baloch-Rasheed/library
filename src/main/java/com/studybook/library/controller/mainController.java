package com.studybook.library.controller;

import com.studybook.library.model.Book;
import com.studybook.library.model.User;
import com.studybook.library.services.AuthService;
import com.studybook.library.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class mainController {

    User user;
    AuthService userAuth;
    BookService bookService;
    mainController(BookService service, AuthService auth, User user){
        bookService = service;
        userAuth = auth;
        this.user = user;
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
        List<Book> books = bookService.getBooks();
        mav.addObject("books",books);
        return mav;
    }

    @GetMapping("/homepage")
    public String home(){
        return "homepage";
    }

    @PostMapping("/additionbook")
    String additionBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/booklist";
    }
    @PostMapping("/deletion")
    String deletionBook(@ModelAttribute Book book){
        bookService.deleteBook(book.getId());
        return "redirect:/booklist";
    }
    @PostMapping("/login-process")
    String userLogin(@ModelAttribute User user,Model model){
        this.user = user;
        if(userAuth.login(user.getUsername(),user.getPassword()) != null){
            return "homepage";
        }
        userAuth.registerUser(user);
        model.addAttribute("user",user);
        return "createprofile";
    }
    @PostMapping("/welcome-user")
    String welcomePage(@ModelAttribute User user){
        this.user.setName(user.getName());
        return "homepage";
    }
}
