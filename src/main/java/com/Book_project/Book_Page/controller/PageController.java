package com.Book_project.Book_Page.controller;

import com.Book_project.Book_Page.entity.Page;
import com.Book_project.Book_Page.service.PageService;
import com.Book_project.Book_Page.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    @PostMapping("/page")
    public ResponseEntity<Object> savePage(@RequestBody Page page){
        Page page1 =pageService.savePage(page);
        return ResponseHandler.response(HttpStatus.CREATED,false,"page  detals saved",page1);
    }
    @GetMapping("/getpage/{number}")
    public ResponseEntity<Object> getById(@PathVariable("number") Long number){
         ResponseEntity<Object> page=pageService.getById(number);
      return page;
    }
    @PutMapping("/page/{id}")
    public ResponseEntity<Object> updateBYId(@PathVariable("id") Long id, @RequestBody Page page){
        Page page1= pageService.updatePage(id, page);
        return ResponseHandler.response(HttpStatus.OK,false,"page details update",page1);
    }


}
