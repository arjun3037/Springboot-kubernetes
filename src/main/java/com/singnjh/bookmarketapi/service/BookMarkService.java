package com.singnjh.bookmarketapi.service;

import com.singnjh.bookmarketapi.domain.BookMark;
import com.singnjh.bookmarketapi.repo.BookMarkRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookMarkService {

    @Autowired
    private BookMarkRepo bookMarkRepo;

    @Transactional()
    public List<BookMark> getBookMarks(){
        return bookMarkRepo.findAll();
    }


}
