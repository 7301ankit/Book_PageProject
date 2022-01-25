package com.Book_project.Book_Page.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String bookName;
    private String author;
    private Long numberOfPage;
    private Long price;
    private Date publishedDate =new Date();

   // @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="book")
    @JsonIgnoreProperties("book")
    private List<Page> page;

    public List<Page> getPage() {
        return page;
    }

    public void setPage(List<Page> page) {
        this.page = page;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(Long numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
