package com.Book_project.Book_Page.repo;

import com.Book_project.Book_Page.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


   Book findByBookName(String bookName);
}
