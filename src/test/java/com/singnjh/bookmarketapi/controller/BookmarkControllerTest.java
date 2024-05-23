package com.singnjh.bookmarketapi.controller;

import com.singnjh.bookmarketapi.domain.BookMark;
import com.singnjh.bookmarketapi.repo.BookMarkRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///demo"
})
public class BookmarkControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookMarkRepo  bookMarkRepo;

    private List<BookMark> bookmarks;

    @BeforeEach
    void setUp(){
        bookMarkRepo.deleteAllInBatch();
        bookmarks = new ArrayList<>();
        bookmarks.add(new BookMark(null, "SivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarks.add(new BookMark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarks.add(new BookMark(null, "Quarkus", "https://quarkus.io/", Instant.now()));
        bookmarks.add(new BookMark(null, "Micronaut", "https://micronaut.io/", Instant.now()));
        bookmarks.add(new BookMark(null, "JOOQ", "https://www.jooq.org/", Instant.now()));
        bookmarks.add(new BookMark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        bookmarks.add(new BookMark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        bookmarks.add(new BookMark(null, "DZone", "https://dzone.com/", Instant.now()));
        bookmarks.add(new BookMark(null, "DevOpsBookmarks", "http://www.devopsbookmarks.com/", Instant.now()));
        bookmarks.add(new BookMark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        bookmarks.add(new BookMark(null, "Expressjs", "https://expressjs.com/", Instant.now()));
        bookmarks.add(new BookMark(null, "Marcobehler", "https://www.marcobehler.com", Instant.now()));
        bookmarks.add(new BookMark(null, "baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarks.add(new BookMark(null, "devglan", "https://www.devglan.com", Instant.now()));
        bookmarks.add(new BookMark(null, "linuxize", "https://linuxize.com", Instant.now()));

        bookMarkRepo.saveAll(bookmarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1,15,2,1,true,false,true,false",
            "2,15,2,2,false,true,false,true"
    })
    void shouldGetBookmarks(int page , int totalElements ,int totalPages , int currentPage, boolean isFirst, boolean isLast, boolean hasNext, boolean hasPrevious) throws Exception {

        ResultActions resultActions = mockMvc.perform(get("/api/bookmarks?page="+page))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(totalElements))
                .andExpect(jsonPath("$.totalPages").value(totalPages))
                .andExpect(jsonPath("$.currentPage").value(currentPage))
                .andExpect(jsonPath("$.isFirst").value(isFirst))
                .andExpect(jsonPath("$.isLast").value(isLast))
                .andExpect(jsonPath("$.hasNext").value(hasNext))
                .andExpect(jsonPath("$.hasPrevious").value(hasPrevious));
    }


}
