package org.soyphea;

import lombok.extern.slf4j.Slf4j;
import org.soyphea.feign.BookClient;
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
    public ApiResponse<Book> findBookById(@PathVariable String id) throws Exception{
        log.info("Start search book with id:{}",id);
        Book book= bookClient.getBookById(id);
        ApiResponse apiResponse = ApiResponse.success();
        apiResponse.setBody(book);
        return apiResponse;
    }

    @PostMapping("/books")
    public ApiResponse<Book> addBook(@RequestBody Book book) throws Exception{
        Book bookResponse= bookClient.createBook(book);
        ApiResponse apiResponse = ApiResponse.success();
        apiResponse.setBody(bookResponse);
        return apiResponse;
    }
}
