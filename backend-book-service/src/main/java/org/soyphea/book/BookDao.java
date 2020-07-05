package org.soyphea.book;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookDao {

    public List<Book> books = new ArrayList<>();

    public Optional<Book> findById(String id) {
        return books.stream().filter(bk -> bk.getId().equals(id)).findFirst();
    }
    public Optional<Book> findByTitle(String title) {
        return books.stream().filter(bk -> bk.getTitle().equals(title)).findFirst();
    }

    public Book add(Book newBook) {
        Book bk = Book.builder().publishDate(new Date()).title(newBook.title)
                .id(UUID.randomUUID().toString()).build();
        books.add(bk);
        return bk;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
