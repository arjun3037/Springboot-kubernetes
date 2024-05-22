package com.singnjh.bookmarketapi.controller;

import com.singnjh.bookmarketapi.domain.BookMark;
import com.singnjh.bookmarketapi.domain.BookMarkDto;
import com.singnjh.bookmarketapi.service.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookMarkController {

    @Autowired
    private BookMarkService bookMarkService;

    @GetMapping("/api/bookmarks")
    public BookMarkDto getBookMarks(@RequestParam(name= "page" , defaultValue = "1") Integer page){
        return bookMarkService.getBookMarks(page);
    }



}
