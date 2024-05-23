package com.singnjh.bookmarketapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class BookMarksDto {
    private long totalElements;

    private int totalPages;

    private int currentPage;

    @JsonProperty("isFirst")
    private boolean isFirst;

    @JsonProperty("isLast")
    private boolean isLast;

    private boolean hasNext;

    private boolean hasPrevious;

    private List<BookMarkDTO> data;

    public BookMarksDto(Page<BookMarkDTO> bookMarkPage){
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
