package com.singnjh.bookmarketapi.repo;

import com.singnjh.bookmarketapi.domain.BookMark;
import com.singnjh.bookmarketapi.domain.BookMarkDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMarkRepo extends JpaRepository<BookMark , Long> {

    @Query("select new com.singnjh.bookmarketapi.domain.BookMarkDTO(b.id,b.title,b.url,b.createdAt) b from BookMark b")
    Page<BookMarkDTO> findBookmarks(Pageable pageable);


}
