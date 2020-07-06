package org.soyphea.feign;

import org.soyphea.Book;
import org.soyphea.BookFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "book", value = "book",url = "${book.baseUrl}"
        , fallbackFactory = BookFallbackFactory.class
)
public interface BookClient {

    @PostMapping("/api/books")
    public Book createBook(Book book);

    @GetMapping("/api/books/{id}")
    public Book getBookById(@PathVariable String id);

}
