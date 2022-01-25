package com.Book_project.Book_Page.service;

import com.Book_project.Book_Page.entity.Book;
import com.Book_project.Book_Page.exception.ResourceNotFoundException;
import com.Book_project.Book_Page.repo.BookRepository;
import com.Book_project.Book_Page.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public  Book savebook(Book book){
      return   bookRepository.save(book);
    }

    public ResponseEntity<Object> getByBookName(String bookName){
        if(bookName.isEmpty() || Objects.isNull(bookName)){
            return ResponseHandler.response(HttpStatus.BAD_REQUEST,true,"bookName can't be null");
        }
        Book book=bookRepository.findByBookName(bookName);

        if(Objects.nonNull(book)){
            return ResponseHandler.response(HttpStatus.OK,false,"Book details found by BookName",book);
        }
        return ResponseHandler.response(HttpStatus.NOT_FOUND,true,"Book not found");
    }

    public Book updateBook(Long id,Book book){
          Book book1=bookRepository.findById(id).orElse(null);
          book1.setBookName(book.getBookName());
          book1.setAuthor(book.getAuthor());
          book1.setPage(book.getPage());
          book1.setPrice(book.getPrice());
          book1.setNumberOfPage(book.getNumberOfPage());
          book1.setPublishedDate(book.getPublishedDate());

          return bookRepository.save(book1);
    }


}
