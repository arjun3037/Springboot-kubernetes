package com.singnjh.bookmarketapi.controller;

import com.singnjh.bookmarketapi.domain.BookMarkDTO;
import com.singnjh.bookmarketapi.domain.BookMarksDto;
import com.singnjh.bookmarketapi.service.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookMarkController {

    @Autowired
    private BookMarkService bookMarkService;

    @GetMapping("/api/bookmarks")
    public BookMarksDto getBookMarks(@RequestParam(name= "page" , defaultValue = "1") Integer page){
        return bookMarkService.getBookMarks(page);
    }



}
