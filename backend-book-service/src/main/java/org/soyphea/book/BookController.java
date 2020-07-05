package org.soyphea.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}")
    public Book findBookById(@PathVariable String id) throws Exception{
        log.info("Start search book with id=>{}",id);
        Thread.sleep(10000);
        return bookService.findBookById(id);
    }
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) throws Exception{
        log.info("Start to create book with title=>{}",book.getTitle());
        Thread.sleep(10000);
        return bookService.saveBook(book);
    }
}
