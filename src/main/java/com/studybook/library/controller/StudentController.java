package com.studybook.library.controller;

import com.studybook.library.model.Book;
import com.studybook.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    BookService bookService;
    @GetMapping("/")
    String _index(){
        return "homepage";
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

    @PostMapping("/additionbook")
    String additionBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/booklist";
    }
}
