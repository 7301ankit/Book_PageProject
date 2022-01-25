package com.Book_project.Book_Page.controller;

import com.Book_project.Book_Page.entity.Book;
import com.Book_project.Book_Page.service.BookService;
import com.Book_project.Book_Page.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<Object> saveBook(@RequestBody Book book){
         Book book1= bookService.savebook(book);
         return ResponseHandler.response(HttpStatus.CREATED,false,"Book detals saved",book1);
    }

    @GetMapping("/book/{bookName}")
    public ResponseEntity<Object> getById(@PathVariable("bookName") String bookName){
     ResponseEntity<Object> book= bookService.getByBookName(bookName);
     return book;

    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Object> updateBYId(@PathVariable("id") Long id,@RequestBody Book book){
      Book book1= bookService.updateBook(id, book);
      return ResponseHandler.response(HttpStatus.OK,false,"Book details update by id",book1);
    }


}
