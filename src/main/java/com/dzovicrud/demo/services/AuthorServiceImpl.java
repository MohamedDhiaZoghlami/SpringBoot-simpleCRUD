package com.dzovicrud.demo.services;

import org.springframework.stereotype.Service;

import com.dzovicrud.demo.model.Author;
import com.dzovicrud.demo.repository.AuthorRepository;
import java.util.List;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author Author) {
        return authorRepository.save(Author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Long id, Author book) {
        return authorRepository.findById(id).map(a -> {
            a.setName(a.getName());
            a.setEmail(a.getEmail());
            a.setBooks(a.getBooks());
            return authorRepository.save(a);
        }).orElseThrow(() -> new RuntimeException("Author Not Found"));
    };

    @Override
    public String deleteAuthor(Long id) {
        authorRepository.deleteById(id);

        return "Author deleted!!!";
    };
}