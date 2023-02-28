package com.dzovicrud.demo.services;

import java.util.List;

import com.dzovicrud.demo.model.Book;

public interface BookService {
    Book createBook(Long id, Book book);

    List<Book> getAllBooks();

    Book updateBook(Long id, Book book);

    String deleteBook(Long id);

}
