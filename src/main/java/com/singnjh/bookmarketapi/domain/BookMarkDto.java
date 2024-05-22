package com.singnjh.bookmarketapi.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class BookMarkDto {

    private List<BookMark> data;

    private long totalElements;
    private int totalPages;
    private int currentPage;

    private boolean isFirst;

    private boolean isLast;

    private boolean hasNext;

    private boolean hasPrevious;

    public BookMarkDto(Page<BookMark> bookMarkPage){
        this.setData(bookMarkPage.getContent());
        this.setTotalElements(bookMarkPage.getTotalElements());
        this.setTotalPages(bookMarkPage.getTotalPages());
        this.setFirst(bookMarkPage.isFirst());
        this.setLast(bookMarkPage.isLast());
        this.setHasNext(bookMarkPage.hasNext());
        this.setHasPrevious(bookMarkPage.hasPrevious());
        this.setCurrentPage(bookMarkPage.getNumber()+1);

    }
}
