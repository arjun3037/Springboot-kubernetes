package com.singnjh.bookmarketapi;

import com.singnjh.bookmarketapi.domain.BookMark;
import com.singnjh.bookmarketapi.repo.BookMarkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitialize implements CommandLineRunner {

    @Autowired
    private final BookMarkRepo bookMarkRepo;

    @Override
    public void run(String... args) throws Exception {
            bookMarkRepo.save(new BookMark(null,"Spring Boot" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Spring Security" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Spring Batch" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Apache Camel" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Mongo DB" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"React Js" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Express JS" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Spring Boot" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Spring Security" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Spring Batch" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Apache Camel" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Mongo DB" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"React Js" ,"https://www.google.com" , Instant.now()));
        bookMarkRepo.save(new BookMark(null,"Express JS" ,"https://www.google.com" , Instant.now()));
    }
}
