package org.soyphea;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class BookClientController {

    private final BookClient bookClient;

    public BookClientController(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @GetMapping("/books/{id}")
    public Book findBookById(@PathVariable String id) throws Exception{
        log.info("Start search book with id:{}",id);
        return bookClient.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) throws Exception{
        return bookClient.createBook(book);
    }
}
