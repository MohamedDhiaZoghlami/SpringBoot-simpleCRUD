package com.dzovicrud.demo.services;

import java.util.List;

import com.dzovicrud.demo.model.Author;

public interface AuthorService {
    Author createAuthor(Author author);

    List<Author> getAllAuthors();

    Author updateAuthor(Long id, Author author);

    String deleteAuthor(Long id);
}
