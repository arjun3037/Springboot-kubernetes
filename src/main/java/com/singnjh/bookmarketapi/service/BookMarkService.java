package com.singnjh.bookmarketapi.service;

import com.singnjh.bookmarketapi.domain.BookMark;
import com.singnjh.bookmarketapi.domain.BookMarkDto;
import com.singnjh.bookmarketapi.repo.BookMarkRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookMarkService {

    @Autowired
    private BookMarkRepo bookMarkRepo;

    @Transactional(readOnly = true)
    public BookMarkDto getBookMarks(Integer page){
        int pageNo = page < 0 ? 0 : page-1;
        Pageable pageable = PageRequest.of(pageNo , 10 , Sort.Direction.DESC, "createdAt");
        return new BookMarkDto(bookMarkRepo.findAll(pageable));
    }


}
