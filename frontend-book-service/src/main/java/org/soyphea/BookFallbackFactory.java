package org.soyphea;


import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class BookFallbackFactory implements FallbackFactory<BookClient> {

    Book book = Book.builder().title("failed").id("failed").publishDate(new Date()).build();

    @Override
    public BookClient create(Throwable throwable) {
        log.warn("Issue of {}",throwable.getCause());
        return new BookClient() {
            @Override
            public Book createBook(Book book) {
                return book;
            }

            @Override
            public Book getBookById(String id) {
                return book;
            }
        };
    }
}
