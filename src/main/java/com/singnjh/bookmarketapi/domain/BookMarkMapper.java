package com.singnjh.bookmarketapi.domain;

import org.springframework.stereotype.Component;

@Component
public class BookMarkMapper {

    public BookMarkDTO toDto(BookMark bookMark){
        BookMarkDTO bookMarkDTO = new BookMarkDTO();
        bookMarkDTO.setId(bookMark.getId());
        bookMarkDTO.setTitle(bookMark.getTitle());
        bookMarkDTO.setUrl(bookMark.getUrl());
        bookMarkDTO.setCreatedAt(bookMark.getCreatedAt());
        return bookMarkDTO;
    }
}
