package com.dzovicrud.demo.services;

import org.springframework.stereotype.Service;

import com.dzovicrud.demo.model.Book;
import com.dzovicrud.demo.model.Author;
import com.dzovicrud.demo.repository.BookRepository;
import com.dzovicrud.demo.repository.AuthorRepository;
import java.util.List;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public Book createBook(Long id, Book book) {
        Author author = authorRepository.findById(id).orElseThrow();
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return bookRepository.findById(id).map(b -> {
            b.setTitle(book.getTitle());
            b.setIsbn(book.getIsbn());
            b.setAuthor(book.getAuthor());
            return bookRepository.save(b);
        }).orElseThrow(() -> new RuntimeException("Book Not Found"));
    };

    @Override
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);

        return "Book deleted!!!";
    };
}
