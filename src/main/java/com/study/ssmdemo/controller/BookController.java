package com.study.ssmdemo.controller;

import com.study.ssmdemo.dao.BookDao;
import com.study.ssmdemo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(method = RequestMethod.GET)
    public String showBookList(Model model) {
        if (!model.containsAttribute("bookList")) {
            Iterable<Book> booksItes = bookDao.findAll();
            List<Book> books = new ArrayList<>();
            for (Book item :
                    booksItes) {
                books.add(item);
            }

            model.addAttribute("bookList", books);
        }

        return "book";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/search")
    public String searchBookList(Book book, RedirectAttributes model) {
        if (!book.getAuthor().equals("")) {
            List<Book> books = new ArrayList<>();
            books = bookDao.findByAuthor(book.getAuthor());
            model.addFlashAttribute("bookList", books);
        }

        return "redirect:/book";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/delete")
    public String deleteBook(@RequestParam String id) {
        Book book = new Book();
        book.setId(Integer.valueOf(id));
        bookDao.delete(book);

        return "redirect:/book";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/edit")
    public String editBook(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            Optional<Book> book = bookDao.findById(id);
            model.addAttribute("book", book.get());
        }

        return "bookEdit";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/edit")
    public String editBook(Book book, Model model) {
        Book rs = bookDao.save(book);

        return "redirect:/book";
    }
}
