package com.singnjh.bookmarketapi.service;


import com.singnjh.bookmarketapi.domain.BookMarkDTO;
import com.singnjh.bookmarketapi.domain.BookMarkMapper;
import com.singnjh.bookmarketapi.domain.BookMarksDto;
import com.singnjh.bookmarketapi.repo.BookMarkRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookMarkService {

    @Autowired
    private BookMarkMapper bookMarkMapper;

    @Autowired
    private BookMarkRepo bookMarkRepo;

    @Transactional(readOnly = true)
    public BookMarksDto getBookMarks(Integer page){
        int pageNo = page < 0 ? 0 : page-1;
        Pageable pageable = PageRequest.of(pageNo , 10 , Sort.Direction.DESC, "createdAt");

        Page<BookMarkDTO> bookMarkDTO = bookMarkRepo.findBookmarks(pageable);

        return new BookMarksDto(bookMarkDTO);
    }


}
