package com.javatechie.aws;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }


    @SneakyThrows
    @GetMapping("/{id}")
    public Book findBook(@PathVariable int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not available"));
        return book;
    }
}
