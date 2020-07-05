package org.soyphea.book;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book findBookById(String id){
        return bookDao.findById(id).orElseThrow(() -> new BookException("Boot not found."));
    }
    public Book saveBook(Book book)throws Exception{
        if (bookDao.findByTitle(book.getTitle()).isPresent()) throw new BookException("Book Already existed.");
        Book saveBook = bookDao.add(book);
        return saveBook;
    }
}
