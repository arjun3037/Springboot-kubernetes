package com.singnjh.bookmarketapi.repo;

import com.singnjh.bookmarketapi.domain.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMarkRepo extends JpaRepository<BookMark , Long> {




}
