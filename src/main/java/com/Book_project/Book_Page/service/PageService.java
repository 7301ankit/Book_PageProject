package com.Book_project.Book_Page.service;

import com.Book_project.Book_Page.entity.Page;
import com.Book_project.Book_Page.exception.ResourceNotFoundException;
import com.Book_project.Book_Page.repo.PageRepository;
import com.Book_project.Book_Page.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    public Page savePage(Page page){
      return   pageRepository.save(page);
    }

    public ResponseEntity<Object> getById(Long number){
        if( Objects.isNull(number)){
            return ResponseHandler .response(HttpStatus.BAD_REQUEST,true,"number can not be null ");
        }
        Page page= pageRepository.findByNumber(number);
        if(Objects.nonNull(page)){
            return ResponseHandler.response(HttpStatus.OK,false,"number is found",page);
        }
      return ResponseHandler.response(HttpStatus.NOT_FOUND,true,"page not found");
    }

    public Page updatePage(Long id,Page page){

        Page page1= pageRepository.findById(id).orElse(null);
        page1.setChapter(page.getChapter());
        page1.setContent(page.getContent());
        page1.setNumber(page.getNumber());
        page1.setBook(page.getBook());
        return pageRepository.save(page1);
    }





}
